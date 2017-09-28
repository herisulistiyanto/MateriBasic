package com.andro.indieschool.myfragmentapp.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andro.indieschool.myfragmentapp.R;

import static com.andro.indieschool.myfragmentapp.second.SlideFragment.BundleKey.LABEL_KEY;

/**
 * Created by herisulistiyanto on 8/29/17.
 */

public class SlideFragment extends Fragment {

    private View rootView;
    private TextView tvLabel;

    public static SlideFragment newInstance(String label) {

        Bundle args = new Bundle();
        args.putString(LABEL_KEY, label);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_slide, container, false);
        tvLabel = rootView.findViewById(R.id.tv_label);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (null != bundle) {
            String label = bundle.getString(LABEL_KEY, "ouch !!");
            tvLabel.setText(label);
        }
    }

    public final class BundleKey {
        private BundleKey() {
        }

        public static final String LABEL_KEY = "SlideFragment.labelKey";
    }

}
