package com.github.pockethub.android.ui.bindingutils;

import android.databinding.BindingAdapter;
import android.support.v4.view.PagerAdapter;

import com.github.pockethub.android.ui.ViewPager;

/**
 * Created by kishorandroid on 14/05/17.
 */

public class UIBindingUtils {

    @BindingAdapter({"viewPagerAdapter"})
    public static void setViewPagerAdapter(ViewPager viewPager, PagerAdapter pagerAdapter) {
        viewPager.setAdapter(pagerAdapter);
    }
}
