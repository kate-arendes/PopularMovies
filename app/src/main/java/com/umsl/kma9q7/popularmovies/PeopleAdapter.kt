package com.umsl.kma9q7.popularmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PeopleAdapter (private val people: List<PeopleResult>) : RecyclerView.Adapter<PeopleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        return holder.bind(people[position])
    }


}

class PeopleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val photo: ImageView = itemView.findViewById(R.id.ivPersonPhoto)
    private val title: TextView = itemView.findViewById(R.id.tvPersonTitle)
    private val rating: TextView = itemView.findViewById(R.id.tvPersonRating)

    fun bind(person: PeopleResult){
        Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${person.profile_path}").into(photo)
        title.text = "Name: " + person.name
        rating.text = "Popularity: " + person.popularity.toString()
    }
}
