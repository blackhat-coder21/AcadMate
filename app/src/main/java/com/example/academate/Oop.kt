package com.example.academate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import com.example.academate.adapters.ViewPagerAdapter
import com.example.academate.fragments.*
import com.google.android.material.tabs.TabLayout

class Oop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        supportActionBar?.hide()

        setUpTabs()
    }
    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MaterialOOPFragment(), "Material")
        adapter.addFragment(PYQsOOPFragment(), "PYQs")
        adapter.addFragment(LinksOOPFragment(), "Links")
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.baseline_book_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.baseline_pyq_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.baseline_link_24)
    }
}