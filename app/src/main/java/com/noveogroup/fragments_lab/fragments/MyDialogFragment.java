package com.noveogroup.fragments_lab.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.noveogroup.fragments_lab.R;

import butterknife.OnClick;

public class MyDialogFragment extends BaseDialogFragment {

    private static final String SHOWN_DIALOG_FRAGMENT_TAG = "SHOWN_DIALOG_FRAGMENT_TAG";

    public static MyDialogFragment newInstance() {
        return new MyDialogFragment();
    }

    @Override
    void onPostViewCreated(View view, Bundle savedInstanceState) {}

    @OnClick(R.id.dialog_layout)
    public void onClick(View view) {
        Fragment prev = getFragmentManager().findFragmentByTag(SHOWN_DIALOG_FRAGMENT_TAG);

        if (prev != null) {
            return;
        }

        MyDialogFragment myDialogFragment = MyDialogFragment.newInstance();
        myDialogFragment.show(getFragmentManager(), SHOWN_DIALOG_FRAGMENT_TAG);
    }

    @Override
    public int getLayout() {
        return R.layout.dialog_fragment_layout;
    }
}
