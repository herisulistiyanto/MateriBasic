package com.andro.indieschool.myfragmentapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.indieschool.myfragmentapp.R;

/**
 * Created by herisulistiyanto on 8/18/17.
 */

public class FragmentTop extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, true);
    }
}
