package com.umsl.kma9q7.popularmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.umsl.kma9q7.popularmovies.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val mainViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainViewBinding.root)

        val moviesFragment = MoviesFragment()
        val peopleFragment = PeopleFragment()
        val upcomingFragment = UpcomingFragment()

        setFragment(moviesFragment)

        val moviesBadge = mainViewBinding.bottomNavView.getOrCreateBadge(R.id.miMovies)
        val peopleBadge = mainViewBinding.bottomNavView.getOrCreateBadge(R.id.miPeople)
        val upcomingBadge = mainViewBinding.bottomNavView.getOrCreateBadge(R.id.miUpcoming)

        mainViewBinding.bottomNavView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.miMovies -> {
                    setFragment(moviesFragment)
                    moviesBadge.isVisible = false
                }
                R.id.miPeople -> {
                    setFragment(peopleFragment)
                    peopleBadge.isVisible = false
                }
                R.id.miUpcoming -> {
                    setFragment(upcomingFragment)
                    upcomingBadge.isVisible = false
                }
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}