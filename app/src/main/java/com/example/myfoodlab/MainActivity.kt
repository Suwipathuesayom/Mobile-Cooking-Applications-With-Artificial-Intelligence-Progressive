package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myfoodlab.ui.fillter.filtlterFragment
import com.example.myfoodlab.ui.home.homeMenuFragment
import com.example.myfoodlab.ui.like.likeFragment
import com.example.myfoodlab.ui.logout.logoutFragment
import com.example.myfoodlab.ui.random.randomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, WelcomeSignup::class.java)
                startActivity(intent)
            }, 3000)
        }*/

        val FillterFragment = filtlterFragment()
        val HomeFragment = homeMenuFragment()
        val LikeFragment = likeFragment()
        val RandomFragment = randomFragment()
        val LogoutFragment = logoutFragment()


        makeCurrentFragment(HomeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.filter -> makeCurrentFragment(FillterFragment)
                R.id.random -> makeCurrentFragment(RandomFragment)
                R.id.menu -> makeCurrentFragment(HomeFragment)
                R.id.like -> makeCurrentFragment(LikeFragment)
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