package com.binar.academy.resourcemodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNama = findViewById(R.id.et_nama);
        final EditText etKelas = findViewById(R.id.et_kelas);
        Button btnNext = findViewById(R.id.btn_next);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Student student = new Student(
                        etNama.getText().toString().trim(),
                        etKelas.getText().toString().trim()
                );

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.IntentKey.KEY_PAKET, student);

                startActivity(intent);
            }
        });
    }

}
