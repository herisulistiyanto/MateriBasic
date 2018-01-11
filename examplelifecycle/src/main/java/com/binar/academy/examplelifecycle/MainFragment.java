package com.binar.academy.examplelifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by herisulistiyanto on 1/11/18.
 */

public class MainFragment extends Fragment {

    private final String TAG = MainFragment.class.getSimpleName();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        Log.e(TAG, "Fragment onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Fragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "Fragment onCreateView");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "Fragment onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e(TAG, "Fragment onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG, "Fragment onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG, "Fragment onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "Fragment onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "Fragment onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "Fragment onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG, "Fragment onDetach");
        super.onDetach();
    }
}
