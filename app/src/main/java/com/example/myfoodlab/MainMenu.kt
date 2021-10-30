package com.example.myfoodlab

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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


        // การแสดงรูปภาพ imageslider จาก URL
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/10/17/uweZdl.png"))
        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/10/17/uwe1ne.png"))
        imageList.add(SlideModel("https://sv1.picz.in.th/images/2021/10/17/uwewQt.png"))

        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        imageSlider.setImageList(imageList)

    }

}