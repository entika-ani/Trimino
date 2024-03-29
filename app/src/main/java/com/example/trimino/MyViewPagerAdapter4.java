package com.example.trimino;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.trimino.fragments.gameplaceAll;
import com.example.trimino.fragments.gameplaceE;
import com.example.trimino.fragments.gameplaceF;
import com.example.trimino.fragments.gameplaceW;
import com.example.trimino.fragments.gameplaceWind;

public class MyViewPagerAdapter4 extends FragmentStateAdapter {


    public MyViewPagerAdapter4(@NonNull FragmentActivity fragmentActivity, int numPages) {
        super(fragmentActivity);

    }

    public MyViewPagerAdapter4(games fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new gameplaceW();
            case 1:
                return new gameplaceE();
            case 2:
                return new gameplaceF();
            case 3:
                return new gameplaceWind();
            case 4:
                return new gameplaceAll();
            default:
                return new gameplaceW();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
