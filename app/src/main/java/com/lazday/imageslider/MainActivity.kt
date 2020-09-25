package com.lazday.imageslider

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var currentPage = 0
    private var numPages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lists: List<String> = listOf(
            "https://images.pexels.com/photos/3843443/pexels-photo-3843443.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/39853/woman-girl-freedom-happy-39853.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/37728/pexels-photo-37728.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
        )

        val assets = listOf(
            R.drawable.photo_one,
            R.drawable.photo_two,
            R.drawable.photo_three
        )

//        createSlider( lists )
        createSlider( assets )
    }

//    private fun createSlider(string: List<String>) {
    private fun createSlider(string: List<Int>) {

        vpSlider.adapter = SliderAdapter(this, string)
        indicator.setViewPager(vpSlider)
        val density = resources.displayMetrics.density
        //Set circle indicator radius
        indicator.radius = 5 * density
        numPages = string.size
        // Auto getData of viewpager
        val update = Runnable {
            if (currentPage === numPages) {
                currentPage = 0
            }
            vpSlider.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post(update)
            }
        }, 5000, 5000)
        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }
}