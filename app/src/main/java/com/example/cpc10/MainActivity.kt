package com.example.cpc10

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

const val BACK_STACK = "BackStake"
private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        var itemid: Int = -1

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.fragment_1 -> {
                    fragment = Fragment_1()
                    replaceFragment(fragment)

                }
                R.id.fragment_2 -> {
                    fragment = Fragment_2()
                    replaceFragment(fragment)

                }
                R.id.send_email -> {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_EMAIL, "hi@hi.ru");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    startActivity(intent)
                    bottomNavigationView.selectedItemId = R.id.fragment_2


                }
            }

            true
        }

        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.fragment_2


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(BACK_STACK)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)


    }
}