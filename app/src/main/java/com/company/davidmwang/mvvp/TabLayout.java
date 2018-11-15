package com.company.davidmwang.mvvp;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Space;

import com.company.davidmwang.fragments.OneFragment;
import com.company.davidmwang.fragments.ThreeFragment;
import com.company.davidmwang.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class TabLayout extends AppCompatActivity {
        SpaceTabLayout spaceTabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);


        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add( new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());

      viewPager=findViewById(R.id.pager);
       spaceTabLayout=(SpaceTabLayout) findViewById(R.id.spaceTabLayout);




//        ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
//        mPagerAdapter.addFragment(new OneFragment());
//        mPagerAdapter.addFragment(new TwoFragment());
//        mPagerAdapter.addFragment(new ThreeFragment());
//
//        viewPager.setAdapter(mPagerAdapter);



        //we need the savedInstanceState to get the position
//        spaceTabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList);

        spaceTabLayout.initialize(viewPager,getSupportFragmentManager(),fragmentList,savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        spaceTabLayout.saveState(outState);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    //Simple pager adapter for our three pages:
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        List<Fragment> fragments=new ArrayList<>();


        public void addFragment(Fragment f){
            fragments.add(f);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
