package com.example.developer.sortedstreets;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public abstract class BaseFragment<T> extends Fragment{

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //enabling toolbar to have menu items in fragment
        setHasOptionsMenu(true);
    }

    protected void showProgress() {
//        if (mProgressDialog == null) {
//            mProgressDialog = new LoadingProgressDialog(getActivity());
//        }
//
//        if (getActivity() != null && !getActivity().isFinishing() && !mProgressDialog.isShowing()) {
//            mProgressDialog.show();
//        }
    }

    protected void hideProgress() {
//        if (mProgressDialog != null) {
//            mProgressDialog.dismiss();
//        }
    }
}