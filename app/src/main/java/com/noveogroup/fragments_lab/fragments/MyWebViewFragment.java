package com.noveogroup.fragments_lab.fragments;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

public class MyWebViewFragment extends WebViewFragment{
    private final static String CURRENT_URL_TAG = "CURRENT_URL_TAG";

    public static MyWebViewFragment newInstance(String url) {
        MyWebViewFragment myWebViewFragment = new MyWebViewFragment();

        Bundle bundle = new Bundle();
        bundle.putString(CURRENT_URL_TAG, url);

        myWebViewFragment.setArguments(bundle);
        return myWebViewFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getWebView().setWebViewClient(new WebViewClient());

        if (savedInstanceState == null) {
            getWebView().loadUrl(getArguments().getString(CURRENT_URL_TAG));
        } else{
            getWebView().loadUrl(savedInstanceState.getString(CURRENT_URL_TAG));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CURRENT_URL_TAG, getWebView().getUrl());
    }
}
