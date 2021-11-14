package com.wael.e_commerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.wael.e_commerce.R;

import java.util.Locale;

import io.paperdb.Paper;

public class ChoseLoginActivity extends AppCompatActivity {
    private AppCompatButton btnDarkModeActivityChoseLogin , btnLiteModeActivityChoseLogin;
    private ImageView imgOpenMenuActivityChoseLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //هادا السطر ضروري لهذه القاعدة
        Paper.init(ChoseLoginActivity.this);

        //language
        String language = Paper.book("language").read("language" , "");
        if (language == null){
            setAppLocale(this, "en");
        }
        else {
            setAppLocale(this, language);
        }


        boolean mode = Paper.book("mode").read("mode", false);

        if (mode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //تكرار بكل الواجهات
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Dark);
        } else {
            setTheme(R.style.Theme_Light);
        }



        setContentView(R.layout.activity_chose_login);

        findViewByIdes();


        btnLiteModeActivityChoseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Paper.book("mode").write("mode", false);
                setTheme(R.style.Theme_Light);

                //اعادة اقلاع التطبيق
                finishAffinity();
                Intent intent = new Intent(ChoseLoginActivity.this , ChoseLoginActivity.class);
                startActivity(intent);
            }
        });

        btnDarkModeActivityChoseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Paper.book("mode").write("mode", true);
                setTheme(R.style.Theme_Dark);

                //اعادة اقلاع التطبيق
                finishAffinity();
                Intent intent = new Intent(ChoseLoginActivity.this , ChoseLoginActivity.class);
                startActivity(intent);
            }
        });

        imgOpenMenuActivityChoseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });
    }



    private void findViewByIdes() {

        btnDarkModeActivityChoseLogin = (AppCompatButton) findViewById(R.id.btnDarkModeActivityChoseLogin);

        btnLiteModeActivityChoseLogin = (AppCompatButton) findViewById(R.id.btnLiteModeActivityChoseLogin);

        imgOpenMenuActivityChoseLogin = (ImageView) findViewById(R.id.imgOpenMenuActivityChoseLogin);

    }


    //وضع هادا الميثود مرة واحدة فقط في واجهة واحدة
    public static void setAppLocale(Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        }
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }


    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(ChoseLoginActivity.this ,view );
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_language , popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.arabic_language){

                    Paper.book("language").write("language" , "ar");

                    finishAffinity();
                    Intent intent = new Intent(ChoseLoginActivity.this , ChoseLoginActivity.class);
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.english_language){

                    Paper.book("language").write("language" , "en");

                    finishAffinity();
                    Intent intent = new Intent(ChoseLoginActivity.this , ChoseLoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        popupMenu.show();
    }
}