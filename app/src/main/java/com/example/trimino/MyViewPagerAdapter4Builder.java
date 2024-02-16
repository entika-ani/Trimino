package com.example.trimino;

import androidx.fragment.app.FragmentActivity;

public class MyViewPagerAdapter4Builder {
    private FragmentActivity fragmentActivity;
    private int numPages;

    public MyViewPagerAdapter4Builder setFragmentActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
        return this;
    }

    public MyViewPagerAdapter4Builder setNumPages(int numPages) {
        this.numPages = numPages;
        return this;
    }

    public MyViewPagerAdapter4 createMyViewPagerAdapter4() {
        return new MyViewPagerAdapter4(fragmentActivity, numPages);
    }
}