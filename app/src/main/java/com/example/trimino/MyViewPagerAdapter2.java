package com.example.trimino;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.trimino.fragments.ElionFragment;
import com.example.trimino.fragments.FairaFragment;
import com.example.trimino.fragments.LunaFragment;
import com.example.trimino.fragments.SilfaFragment;
import com.example.trimino.fragments.gameplaceAll;
import com.example.trimino.fragments.gameplaceE;
import com.example.trimino.fragments.gameplaceF;
import com.example.trimino.fragments.gameplaceW;
import com.example.trimino.fragments.gameplaceWind;

public class MyViewPagerAdapter2 extends FragmentStateAdapter {
    public MyViewPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LunaFragment();
                case 1:
                  return new ElionFragment();
            case 2:
                return  new FairaFragment();
            case 3:
                return  new SilfaFragment();
            default:
                return new LunaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
