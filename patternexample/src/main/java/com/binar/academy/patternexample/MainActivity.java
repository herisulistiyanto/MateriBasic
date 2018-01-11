package com.binar.academy.patternexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        final EditText etInputA = findViewById(R.id.etInputA);
        final EditText etInputB = findViewById(R.id.etInputB);

        tvResult = findViewById(R.id.tvResult);

        final Button btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.multiplyInput(
                        Integer.valueOf(etInputA.getText().toString()),
                        Integer.valueOf(etInputB.getText().toString())
                );
            }
        });

        final Button btnSum = findViewById(R.id.btnSum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sumInput(
                        Integer.valueOf(etInputA.getText().toString()),
                        Integer.valueOf(etInputB.getText().toString())
                );
            }
        });
    }

    private void setupUiResult(int i) {
        String result = getString(R.string.label_result, i);
        tvResult.setText(result);
    }

    @Override
    public void executeMultiply(int i) {
        setupUiResult(i);
    }

    @Override
    public void executeSum(int i) {
        setupUiResult(i);
    }

    @Override
    public void executeSubstract(int i) {
        setupUiResult(i);
    }
}
