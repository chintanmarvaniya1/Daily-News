package com.example.dailynews.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dailynews.fragments.*

class ViewPagerAdapter(manager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(manager, lifecycle)  {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopHeadlines()
            1 -> BusinessNews()
            2 -> TechnologNews()
            3 -> SportNews()
            4 -> EntertainmentNews()
            else -> Fragment()
        }
    }
}