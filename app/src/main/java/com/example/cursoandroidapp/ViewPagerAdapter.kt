package com.example.cursoandroidapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3 // Número total de páginas del ViewPager
    }

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position + 1)
    }
}