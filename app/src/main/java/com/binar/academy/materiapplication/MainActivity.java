package com.binar.academy.materiapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private final String NAMA_PREF = "namaPref";
    private final String PREF_KEY_NAMA = "PREF_KEY_NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSharedPref();

        final EditText etNama = findViewById(R.id.et_name);
        final TextView tvNama = findViewById(R.id.tv_name);

        final Button btnSave = findViewById(R.id.btn_save);
        final Button btnClear = findViewById(R.id.btn_clear);

        tvNama.setText(preferences.getString(PREF_KEY_NAMA, "INI DEFAULT VALUE"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                tvNama.setText(nama);

                saveNama(nama);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearNama(PREF_KEY_NAMA);
                tvNama.setText("");
            }
        });

    }

    private void setupSharedPref() {
        preferences = this.getSharedPreferences(NAMA_PREF, MODE_PRIVATE);
    }

    private void saveNama(String nama) {
        preferences.edit().putString(PREF_KEY_NAMA, nama).apply();
    }

    private void clearNama(String key) {
        preferences.edit().remove(key).apply();
    }
}
