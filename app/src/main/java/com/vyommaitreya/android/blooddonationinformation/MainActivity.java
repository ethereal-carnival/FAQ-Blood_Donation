package com.vyommaitreya.android.blooddonationinformation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private BottomNavigationView mBottomNavigationView;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new MainActivity.SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mBottomNavigationView = findViewById(R.id.navigation);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_pre_donation:
                                mViewPager.setCurrentItem(0);
                                break;
                            case R.id.navigation_post_donation:
                                mViewPager.setCurrentItem(1);
                                break;
                        }
                        return false;
                    }
                });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            InformationListFragment informationListFragment;
            switch (position) {
                case 0:
                    informationListFragment = new InformationListFragment();
                    informationListFragment.setQuestions(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.about_questions))));
                    informationListFragment.setAnswers(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.about_answers))));
                    return informationListFragment;
                case 1:
                    informationListFragment = new InformationListFragment();
                    informationListFragment.setQuestions(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.after_questions))));
                    informationListFragment.setAnswers(new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.after_answers))));
                    return informationListFragment;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
