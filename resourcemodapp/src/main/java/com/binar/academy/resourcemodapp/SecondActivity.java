package com.binar.academy.resourcemodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by herisulistiyanto on 11/1/17.
 */

public class SecondActivity extends AppCompatActivity {

    private final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvNama = findViewById(R.id.tv_nama);
        TextView tvKelas = findViewById(R.id.tv_kelas);

        Intent intent = getIntent();
        if (null != intent) {
            Student resultStudent = intent.getParcelableExtra(IntentKey.KEY_PAKET);

            tvNama.setText(resultStudent.getNama());
            tvKelas.setText(resultStudent.getKelas());
        }


    }

    public class IntentKey {
        public static final String KEY_PAKET = "SecondActivity.PAKET";
    }
}
