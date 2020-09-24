package com.lazday.imageslider

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

class SliderAdapter( private val context: Context,
//                     private val stringList: List<String>
                     private val stringList: List<Int>
    ) : PagerAdapter() {

    private val TAG = "SliderAdapter"
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun destroyItem( container: ViewGroup, position: Int, `object`: Any ) {
        container.removeView(`object` as View)
    }

    override fun getCount() = stringList.size

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.adapter_slider, view, false)!!
        val imageView = imageLayout.findViewById<ImageView>(R.id.image)
        Picasso.get().load(stringList[position])
            .placeholder(R.drawable.img_no_images)
            .error(R.drawable.img_no_images)
            .into(imageView)
        view.addView(imageLayout, 0)
        return imageLayout
    }

    override fun isViewFromObject( view: View, `object`: Any ) = view == `object`

    override fun restoreState( state: Parcelable?, loader: ClassLoader? ) {

    }

    override fun saveState(): Parcelable? {
        return null
    }

}
