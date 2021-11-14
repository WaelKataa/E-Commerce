package com.wael.e_commerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wael.e_commerce.R;
import com.wael.e_commerce.adapter.AdapterViewPager;
import com.wael.e_commerce.models.ViewPagerModel;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class SliderActivity extends AppCompatActivity {
    private ViewPager viewPagerActivitySlider;
    //  private CircleIndicator circleIndicatorActivitySlider;
    private TextView txtNextSliderActivitySlider, txtNumberSliderActivitySlider;


    private AdapterViewPager adapterViewPager;
    private ViewPagerModel viewPagerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        findViewByIdes();

        sittingViewPager();

        txtNextSliderActivitySlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItemViewPager(+1) >= 3) {
                    Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext() , ChoseLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    viewPagerActivitySlider.setCurrentItem(getItemViewPager(+1), true);
                }
            }
        });

        //هادا الحدث لترقيم صفحات السلايدر
        viewPagerActivitySlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                txtNumberSliderActivitySlider.setText(String.valueOf(position + 1));
            }
        });


    }


    private void findViewByIdes() {
        viewPagerActivitySlider = (ViewPager) findViewById(R.id.viewPagerActivitySlider);

        // circleIndicatorActivitySlider = (CircleIndicator) findViewById(R.id.circleIndicatorActivitySlider);

        txtNextSliderActivitySlider = (TextView) findViewById(R.id.txtNextSliderActivitySlider);

        txtNumberSliderActivitySlider = (TextView) findViewById(R.id.txtNumberSliderActivitySlider);


    }

    private void sittingViewPager() {
        List<ViewPagerModel> viewPagerModelList = new ArrayList<>();

        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider1, "Browse all the Category", "Contrary to popular belief, Lorem Ipsum is not simply rand"));
        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider2, "Amazing Discounts & Offers", "Contrary to popular belief, Lorem Ipsum is not simply rand"));
        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider3, "Delivery in 30 min", "Contrary to popular belief, Lorem Ipsum is not simply rand"));

        adapterViewPager = new AdapterViewPager(SliderActivity.this, viewPagerModelList);
        viewPagerActivitySlider.setAdapter(adapterViewPager);
        // circleIndicatorActivitySlider.setViewPager(viewPagerActivitySlider);
    }

    //هاد المثود مستدعى مشان عند الضغط عالزر يقلب السلايدر
    private int getItemViewPager(int position) {
        return viewPagerActivitySlider.getCurrentItem() + position;
    }
}