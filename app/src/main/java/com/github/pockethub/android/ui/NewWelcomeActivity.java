package com.github.pockethub.android.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.pockethub.android.R;
import com.github.pockethub.android.databinding.PagerWithDotsBinding;
import com.github.pockethub.android.viewmodels.NewWelcomeViewModel;

public class NewWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PagerWithDotsBinding binding = DataBindingUtil.setContentView(this, R.layout.pager_with_dots);

        NewWelcomeViewModel viewModel = new NewWelcomeViewModel(this, binding);

        binding.setVm(viewModel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            // On Lollipop, the action bar shadow is provided by default, so have to remove it explicitly
            getSupportActionBar().setElevation(0);
        }
    }
}
