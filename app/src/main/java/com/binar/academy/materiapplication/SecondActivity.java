package com.binar.academy.materiapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSharedPref();

        final EditText etNama = findViewById(R.id.et_name);
        final TextView tvNama = findViewById(R.id.tv_name);

        final EditText etUmur = findViewById(R.id.et_umur);
        final TextView tvUmur = findViewById(R.id.tv_umur);

        final Button btnSave = findViewById(R.id.btn_save);
        final Button btnClear = findViewById(R.id.btn_clear);

        tvNama.setText(preferenceHelper.getString(ConstantPreferences.PREF_KEY_NAMA,
                "INI DEFAULT VALUE"));

        tvUmur.setText(String.format("%s Tahun",
                preferenceHelper.getString(ConstantPreferences.PREF_KEY_UMUR, "17")));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                tvNama.setText(nama);

                String umur = etUmur.getText().toString();
                tvUmur.setText(String.format("%s Tahun", umur));

                save(nama, umur);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.clear(ConstantPreferences.PREF_KEY_NAMA);
                preferenceHelper.clear(ConstantPreferences.PREF_KEY_UMUR);
                tvNama.setText("");
                tvUmur.setText("");
            }
        });

    }

    private void save(String nama, String umur) {
        preferenceHelper.setString(ConstantPreferences.PREF_KEY_NAMA, nama);
        preferenceHelper.setString(ConstantPreferences.PREF_KEY_UMUR, umur);
    }

    private void setupSharedPref() {
        preferenceHelper = PreferenceHelper.getInstance(SecondActivity.this);
    }

}
