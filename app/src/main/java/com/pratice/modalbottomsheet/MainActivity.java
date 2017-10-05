package com.pratice.modalbottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NoSwipePager viewPager;
    private BottomBarAdapter bottomBarAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupViewPager();
    }

    private void setupViewPager() {
        viewPager = (NoSwipePager) findViewById(R.id.content);
        viewPager.setPagingEnabled(false);
        bottomBarAdapter = new BottomBarAdapter(getSupportFragmentManager());

        //Creating Fragments Objects and adding fragments to adapter
        HomeFragment homeFragment = new HomeFragment();
        bottomBarAdapter.addFragments(homeFragment);
        //bottomBarAdapter.addFragments(createFragment(R.color.bottomtab_1)); --> Add more like this

        viewPager.setAdapter(bottomBarAdapter);
    }



}
