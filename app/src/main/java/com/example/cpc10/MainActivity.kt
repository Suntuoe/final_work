package com.example.cpc10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

const val BACK_STAG = "BackStake"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var bottomNavigationView: BottomNavigationView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.fragment_1 -> {
                    fragment = Fragment_1()

                }
                R.id.fragment_2 -> {
                    fragment = Fragment_2()
                }
            }
            replaceFragment(fragment!!)
            true
        }

       bottomNavigationView.selectedItemId = R.id.fragment_2


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(BACK_STAG)
            .commit()
    }
}