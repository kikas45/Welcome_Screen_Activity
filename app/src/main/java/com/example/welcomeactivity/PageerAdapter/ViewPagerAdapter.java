package com.example.welcomeactivity.PageerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.welcomeactivity.screens.FirstScreen;
import com.example.welcomeactivity.screens.SecondScreen;
import com.example.welcomeactivity.screens.ThirdScreen;


public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, @NonNull Lifecycle lifecycle) {
        super(fm, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new FirstScreen();
            case 1:
                return new SecondScreen();
            case 2:
                return new ThirdScreen();
        }
        return null;
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
