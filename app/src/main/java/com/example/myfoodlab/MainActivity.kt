package com.example.myfoodlab


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myfoodlab.ui.fillter.FillterFragment
import com.example.myfoodlab.ui.home.HomeMenuFragment
import com.example.myfoodlab.ui.logout.LogoutFragment
import com.example.myfoodlab.ui.random.RandomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fillterFragment = FillterFragment()
        val homeMenuFragment = HomeMenuFragment()
        val randomFragment = RandomFragment()
        val logoutFragment = LogoutFragment()


        makeCurrentFragment(homeMenuFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu -> makeCurrentFragment(homeMenuFragment)
                R.id.filter -> makeCurrentFragment(fillterFragment)
                R.id.random -> makeCurrentFragment(randomFragment)
                R.id.profile -> makeCurrentFragment(logoutFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }


/*        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, WelcomeSignup::class.java)
                startActivity(intent)
            }, 3000)
        }*/
        }

}