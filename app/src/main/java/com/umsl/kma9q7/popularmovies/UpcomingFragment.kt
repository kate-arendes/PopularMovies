package com.umsl.kma9q7.popularmovies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingFragment: Fragment(R.layout.upcoming_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = view.findViewById<ProgressBar>(R.id.pbUpcomingProgressBar)
        val spUpcoming = view.findViewById<Spinner>(R.id.spUpcoming)

        val request = ServiceBuilder.buildService(TmdbEndpoints::class.java)
        val call = request.getUpcoming(getString(R.string.api_key))

        call.enqueue(object: Callback<UpcomingMovies> {
            override fun onResponse(call: Call<UpcomingMovies>, response: Response<UpcomingMovies>) {
                if(response.isSuccessful){
                    progressBar.visibility = View.GONE

                    val upcomingList: UpcomingMovies? = response.body()
                    print(upcomingList.toString())
                    if (upcomingList != null) {

                        var movieNames: MutableList<String> = mutableListOf<String>()

                        for(result in upcomingList.results) {
                            movieNames.add(result.toString())
                        }


                        val resultList = listOf(upcomingList.results.toString())
                        val adapter = context?.let { ArrayAdapter<String>(it, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, movieNames) }
                        spUpcoming.adapter = adapter

                        spUpcoming.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                context?.let {Toast.makeText(it, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()}
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {

                            }

                        }

                    }



                }
            }

            override fun onFailure(call: Call<UpcomingMovies>, t: Throwable) {
                Toast.makeText(this@UpcomingFragment.context, "${t.message}", Toast.LENGTH_LONG).show()
            }
        }
        )


    }
}