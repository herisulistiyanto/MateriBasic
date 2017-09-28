package com.andro.indieschool.myfragmentapp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andro.indieschool.myfragmentapp.R;

/**
 * Created by herisulistiyanto on 8/18/17.
 */

public class FragmentRight extends Fragment {

    private final String TAG = FragmentRight.class.getSimpleName();

    private Button btnActionRight;
    private FragmentRightListener fragmentRightListener;

    public static FragmentRight newInstance() {
        return new FragmentRight();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_right, container, false);
        btnActionRight = rootView.findViewById(R.id.action_right);
        btnActionRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != fragmentRightListener) {
                    fragmentRightListener.onClickActionRight();
                }
            }
        });
        return rootView;
    }

    public void setFragmentRightListener(FragmentRightListener fragmentRightListener) {
        this.fragmentRightListener = fragmentRightListener;
    }

    public interface FragmentRightListener {
        void onClickActionRight();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView RIGHT");
    }
}
