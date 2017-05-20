package com.github.pockethub.android.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

import com.github.pockethub.android.R;
import com.github.pockethub.android.databinding.PagerWithDotsBinding;
import com.github.pockethub.android.ui.MainActivity;
import com.github.pockethub.android.ui.NewWelcomeActivity;
import com.github.pockethub.android.ui.WelcomePagerAdapter;

/**
 * Created by kishorandroid on 01/05/17.
 */

public class NewWelcomeViewModel {

    private Context mContext;
    public WelcomePagerAdapter adapter;
    private PagerWithDotsBinding mBinding;

    public NewWelcomeViewModel(Context context, PagerWithDotsBinding binding) {
        mContext = context;
        mBinding = binding;
        adapter = new WelcomePagerAdapter(R.layout.welcome_pager_item,
                new int[]{R.drawable.waving_android, R.drawable.welcome_app_icon, R.drawable.thumb_up},
                mContext.getResources().getStringArray(R.array.welcome_texts),
                mContext.getResources().getStringArray(R.array.welcome_titles));
        mBinding.dotPageIndicator.setViewPager(binding.vpPages);
    }

    public void closeAndOpenLogin(View view) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
        editor.putBoolean(MainActivity.PREF_FIRST_USE, false);
        editor.apply();
        mContext.startActivity(new Intent(mContext, MainActivity.class));
        ((NewWelcomeActivity) mContext).finish();
    }

    public void showNextPage(View view) {
        if (mBinding.vpPages.getCurrentItem() + 1 < adapter.getCount()) {
            mBinding.vpPages.setCurrentItem(mBinding.vpPages.getCurrentItem() + 1, true);
        }
    }
}
