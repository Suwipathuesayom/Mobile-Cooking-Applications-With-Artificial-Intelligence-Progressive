package com.example.myfoodlab

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlin.math.abs

class MainMenu : AppCompatActivity() {

    // set image
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/11/11/uLmT7l.png"))
        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/11/11/uLmkqt.png"))
        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/11/11/uLm38e.png"))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        /*Handler(Looper.getMainLooper()).postDelayed({
            aaa.visibility = View.GONE
            bbb.visibility = View.GONE
        }, 2*//*000)*/

        //content.visibility = View.VISIBLE

        bottomNavigationView2.setOnItemSelectedListener { position ->
            when (position.itemId) {
                R.id.menu -> {
                    a1.visibility = View.VISIBLE
                    a2.visibility = View.GONE
                    //content.visibility = View.VISIBLE

                }
                R.id.filter -> {
                    a1.visibility = View.GONE
                    a2.visibility = View.VISIBLE
                    //content.visibility = View.GONE
                }
            }
            true

        }

    }

}