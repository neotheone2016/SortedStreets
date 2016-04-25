package com.example.developer.sortedstreets.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.sortedstreets.BaseFragment;
import com.example.developer.sortedstreets.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupFragment extends BaseFragment implements Validator.ValidationListener {

    @NotEmpty
    @Bind(R.id.et_username)
    EditText mEtUsername;

    @NotEmpty
    @Bind(R.id.et_password)
    EditText mEtPassword;

    @NotEmpty
    @Bind(R.id.et_phone)
    EditText mEtPhone;

    @NotEmpty
    @Bind(R.id.tv_signup)
    TextView mTvSignup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onValidationSucceeded() {
        startActivity(new Intent(getActivity(), ProfileActivity.class));
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_fb, R.id.iv_google, R.id.tv_signup})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_signup:
                Validator validator = new Validator(this);
                validator.setValidationListener(this);
                validator.validate();
                break;

            case R.id.iv_fb:
                Snackbar.make(mTvSignup, "Facebook clicked",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.iv_google:
                Snackbar.make(mTvSignup, "Google plus clicked",Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
