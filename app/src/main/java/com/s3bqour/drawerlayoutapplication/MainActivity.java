package com.s3bqour.drawerlayoutapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {
    private DrawerLayout drawerLy;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLy = findViewById(R.id.drawerLy);
        frameLayout= findViewById(R.id.content_frame);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                    new HomeFragment())
                    .commit();

            getSupportFragmentManager().beginTransaction().replace(R.id.right_drawer,
                    new LeftDrawerFragment())
                    .commit();
        }
        else {
            getSupportFragmentManager().findFragmentById(R.id.content_frame);
            getSupportFragmentManager().findFragmentById(R.id.right_drawer);
        }

        //side color after Animation for home screen
        drawerLy.setScrimColor(getResources().getColor(R.color.design_default_color_primary));
        //Animation for home screen
        drawerLy.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaldOffset = slideOffset * (1- 0.8f);
                final float offsetScale = 1 - diffScaldOffset;
                frameLayout.setScaleX(offsetScale);
                frameLayout.setScaleY(offsetScale);
                final float xOffset = drawerView.getWidth()* slideOffset;
                final float xOffsetDiff = frameLayout.getWidth()* slideOffset/2;
                final float xTranslation = xOffset - xOffsetDiff;
                frameLayout.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }


        });




    }


    @Override
    public void onBackPressed() {

        // check if drawer is open
        if (drawerLy.isDrawerOpen(Gravity.RIGHT)) {

            // close drawer when it is open
            closeDrawer();
            Toast.makeText(MainActivity.this, "Closed Drawer", Toast.LENGTH_SHORT).show();
        } else {
            // close activity when drawer is closed
            super.onBackPressed();
        }

    }


    @Override
    public void openDrawer() {
        drawerLy.openDrawer(Gravity.LEFT);
    }

    @Override
    public void closeDrawer() {

            drawerLy.closeDrawers();
    }

}