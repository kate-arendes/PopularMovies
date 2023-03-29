package com.umsl.kma9q7.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleFragment: Fragment(R.layout.people_fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.people_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = view.findViewById<ProgressBar>(R.id.pbPeopleProgressBar)
        val rvPeople = view.findViewById<RecyclerView>(R.id.rvPeople)

        val request = ServiceBuilder.buildService(TmdbEndpoints::class.java)
        val call = request.getPeople(getString(R.string.api_key))

        call.enqueue(object: Callback<PopularPeople> {
            override fun onResponse(call: Call<PopularPeople>, response: Response<PopularPeople>) {
                if(response.isSuccessful){
                    progressBar.visibility = View.GONE
                    rvPeople.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@PeopleFragment.context)
                        adapter = PeopleAdapter(response.body()!!.results)
                    }
                }
            }

            override fun onFailure(call: Call<PopularPeople>, t: Throwable) {
                Toast.makeText(this@PeopleFragment.context, "${t.message}", Toast.LENGTH_LONG).show()
            }
        }
        )
    }
}