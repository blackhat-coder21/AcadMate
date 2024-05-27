package com.example.academate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.example.academate.adapters.ViewPagerAdapter
import com.example.academate.fragments.LinksFragment
import com.example.academate.fragments.MaterialFragment
import com.example.academate.fragments.PYQsFragment
import com.google.android.material.tabs.TabLayout

class os : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_os)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        supportActionBar?.hide()

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MaterialFragment(), "Material")
        adapter.addFragment(PYQsFragment(), "PYQs")
        adapter.addFragment(LinksFragment(), "Links")
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.baseline_book_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.baseline_pyq_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.baseline_link_24)

    }
}