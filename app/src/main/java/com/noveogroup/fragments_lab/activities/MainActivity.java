package com.noveogroup.fragments_lab.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noveogroup.fragments_lab.R;
import com.noveogroup.fragments_lab.fragments.MyDialogFragment;
import com.noveogroup.fragments_lab.fragments.MyWebViewFragment;
import com.noveogroup.fragments_lab.fragments.TopFragment;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private final static Logger logger = Logger.getLogger(MainActivity.class.getName());

    private final static String TOP_FRAGMENT_TAG = "TOP_FRAGMENT_TAG";
    private final static String DIALOG_FRAGMENT_TAG = "DIALOG_FRAGMENT_TAG";
    private final static String WEB_FRAGMENT_TAG = "WEB_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.top_right_fragment_layout, TopFragment.newInstance(false), TOP_FRAGMENT_TAG)
                    .add(R.id.bottom_right_fragment_layout, MyWebViewFragment.newInstance(getString(R.string.default_site)), WEB_FRAGMENT_TAG)
                    .add(R.id.bottom_left_fragment_layout, MyDialogFragment.newInstance(), DIALOG_FRAGMENT_TAG)
                    .commit();
        }
    }

    public void replaceDialogAndTopFragments() {
        Fragment topFragment = getFragmentManager().findFragmentByTag(TOP_FRAGMENT_TAG);
        Fragment dialogFragment = getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);

        getFragmentManager()
                .beginTransaction()
                .remove(topFragment)
                .remove(dialogFragment)
                .commit();

        getFragmentManager().executePendingTransactions();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.top_right_fragment_layout, dialogFragment, DIALOG_FRAGMENT_TAG)
                .add(R.id.bottom_left_fragment_layout, topFragment, TOP_FRAGMENT_TAG)
                .commit();

    }
}
