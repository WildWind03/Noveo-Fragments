package com.noveogroup.fragments_lab.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.noveogroup.fragments_lab.R;
import com.noveogroup.fragments_lab.activities.MainActivity;

import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class TopFragment extends BaseFragment {
    private static final Logger logger = Logger.getLogger(TopFragment.class.getName());

    private static final String IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY = "IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY";

    private boolean isPossibleToChangeFragments;

    @BindView(R.id.top_fragment_button)
    protected Button changedFragmentsButton;

    public static TopFragment newInstance(boolean isPossibleToChangeFragments) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY, isPossibleToChangeFragments);
        TopFragment topFragment = new TopFragment();
        topFragment.setArguments(bundle);
        return topFragment;
    }

    @Override
    public void onPostViewCreated(View view, Bundle savedInstanceState) {
        if (null == savedInstanceState) {
            isPossibleToChangeFragments = ((getArguments() == null) || getArguments().getBoolean(IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY));
        } else {
            isPossibleToChangeFragments = savedInstanceState.getBoolean(IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY);
        }

        changedFragmentsButton.setEnabled(isPossibleToChangeFragments);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_POSSIBLE_TO_CHANGE_FRAGMENTS_KEY, isPossibleToChangeFragments);
    }

    @OnClick(R.id.top_fragment_button)
    void onClick(View view){
        changedFragmentsButton.setEnabled(false);
        isPossibleToChangeFragments = false;

        Activity activity = getActivity();
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).replaceDialogAndTopFragments();
        }
    }

    @Override
    public int getLayout() {
        return R.layout.top_fragment_layout;
    }
}
