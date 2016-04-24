package com.example.developer.sortedstreets.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.sortedstreets.BaseFragment;
import com.example.developer.sortedstreets.R;

import butterknife.ButterKnife;

public class SignupFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container ,false);
        ButterKnife.bind(this, view);

        return view;
    }
}
