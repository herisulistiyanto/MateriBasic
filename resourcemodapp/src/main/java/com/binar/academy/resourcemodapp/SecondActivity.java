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
        TextView tvKelamin = findViewById(R.id.tv_kelamin);
        TextView tvUsia = findViewById(R.id.tv_usia);

        Intent intent = getIntent();
        if (null != intent) {
//            Student resultStudent = intent.getParcelableExtra(IntentKey.KEY_PAKET);
//            tvNama.setText(resultStudent.getNama());
//            tvKelamin.setText(resultStudent.getKelas());

            Manusia paketManusia = intent.getParcelableExtra(IntentKey.KEY_PAKET);
            tvNama.setText(paketManusia.getNama());
            tvKelamin.setText(paketManusia.getJenisKelamin());

            int usia = paketManusia.getUsia();
            tvUsia.setText(""+usia);

            tvUsia.setText(String.valueOf(paketManusia.getUsia()));
        }
    }

    public final class IntentKey {
        public static final String KEY_PAKET = "SecondActivity.PAKET";
    }
}
