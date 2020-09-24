package com.lazday.imageslider.sliderjava;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.lazday.imageslider.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private final String TAG = "SliderAdapter";

    private List<String> stringList;
    private LayoutInflater inflater;
    private Context context;


    public SliderAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.adapter_slider, view, false);
        assert imageLayout != null;
        final ImageView imageView = imageLayout .findViewById(R.id.image);
        Picasso.get().load(stringList.get(position))
                .placeholder(R.drawable.img_no_images)
                .error(R.drawable.img_no_images)
                .into(imageView);
        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
