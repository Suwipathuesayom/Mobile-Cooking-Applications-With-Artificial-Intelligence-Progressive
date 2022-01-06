package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myfoodlab.ui.fillter.FillterFragment
import com.example.myfoodlab.ui.home.HomeMenuFragment
import com.example.myfoodlab.ui.logout.LogoutFragment
import com.example.myfoodlab.ui.random.RandomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class testfragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testfragment)

        val FillterFragment = FillterFragment()
        val HomeFragment = HomeMenuFragment()
        val RandomFragment = RandomFragment()
        val LogoutFragment = LogoutFragment()


        /*makeCurrentFragment(HomeFragment)*/

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.filter -> makeCurrentFragment(FillterFragment)
                R.id.random -> makeCurrentFragment(RandomFragment)
                R.id.menu -> makeCurrentFragment(HomeFragment)
                R.id.profile -> makeCurrentFragment(LogoutFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
    }
