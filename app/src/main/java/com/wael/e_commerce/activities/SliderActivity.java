package com.wael.e_commerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wael.e_commerce.R;

import me.relex.circleindicator.CircleIndicator;

public class SliderActivity extends AppCompatActivity {
    private ViewPager viewPagerActivitySlider;
    private CircleIndicator circleIndicatorActivitySlider;
    private TextView txtNextSliderActivitySlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        findViewByIdes();

        sittingViewPager();

        txtNextSliderActivitySlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextSlider(view);
            }
        });


    }




    private void findViewByIdes() {
        viewPagerActivitySlider = (ViewPager) findViewById(R.id.viewPagerActivitySlider);

        circleIndicatorActivitySlider = (CircleIndicator) findViewById(R.id.circleIndicatorActivitySlider);

        txtNextSliderActivitySlider = (TextView) findViewById(R.id.txtNextSliderActivitySlider);

    }

    private void sittingViewPager() {

    }

    private void nextSlider(View view) {
        int nextPosition = viewPagerActivitySlider.getCurrentItem();

        switch (view.getId()){

            case R.id.left:
                viewPagerActivitySlider.setCurrentItem(nextPosition - 1);
                break;

            case R.id.right:
                viewPagerActivitySlider.setCurrentItem(nextPosition + 1);
                break;

        }
    }
}