package com.wael.e_commerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wael.e_commerce.R;
import com.wael.e_commerce.activities.SliderActivity;
import com.wael.e_commerce.models.ViewPagerModel;

import java.util.List;


public class AdapterViewPager extends PagerAdapter
{
    private ImageView imgItemViewPaper ;
    private TextView txtTitleItemViewPager , txtBodyItemViewPager;

    private LayoutInflater inflater;
    private Context context;
    private List<ViewPagerModel> viewPagerModels;
    private SliderActivity activity;


    public AdapterViewPager(Context context , List<ViewPagerModel> viewPagerModels)
    {
        this.context = context;
        this.viewPagerModels = viewPagerModels;

        activity = (SliderActivity) context;
    }

    @Override
    public int getCount()
    {
        return viewPagerModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view == (object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_view_pager, container , false);

        imgItemViewPaper = (ImageView) itemView.findViewById(R.id.imgItemViewPaper);
        txtTitleItemViewPager = (TextView) itemView.findViewById(R.id.txtTitleItemViewPager);
        txtBodyItemViewPager = (TextView) itemView.findViewById(R.id.txtBodyItemViewPager);

        ViewPagerModel viewPagerModel = viewPagerModels.get(position);


        imgItemViewPaper.setImageResource(viewPagerModel.getImage());
        txtTitleItemViewPager.setText(viewPagerModel.getTitle());
        txtBodyItemViewPager.setText(viewPagerModel.getBody());



        ((ViewPager)container).addView(itemView);




        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        ((ViewPager)container).removeView((View) object);
    }

    public void add(List<ViewPagerModel> viewPagerModels )
    {
        this.viewPagerModels = viewPagerModels;
    }
}
