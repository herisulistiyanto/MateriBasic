package com.andro.indieschool.myfragmentapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.andro.indieschool.myfragmentapp.R;
import com.andro.indieschool.myfragmentapp.second.SecondActivity;

public class MainActivity extends AppCompatActivity implements FragmentRight.FragmentRightListener {

    private FrameLayout containerFragment;
    private FragmentLeft fragmentLeft;
    private FragmentRight fragmentRight;
    private FragmentManager fragmentManager;

    private Button btnLeft;
    private Button btnRight;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerFragment = (FrameLayout) findViewById(R.id.container_fragment);
        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);
        btnNext = (Button) findViewById(R.id.btn_next);

        fragmentLeft = FragmentLeft.newInstance();
        fragmentRight = FragmentRight.newInstance();
        fragmentRight.setFragmentRightListener(this);

        fragmentManager = getSupportFragmentManager();

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                containerFragment.setVisibility(View.VISIBLE);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container_fragment, fragmentRight).commit();
                ft.addToBackStack(null);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                containerFragment.setVisibility(View.VISIBLE);
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container_fragment, fragmentLeft).commit();
                ft.addToBackStack(null);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 123);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Toast.makeText(this, "HOLAAAAAAA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClickActionRight() {
        Toast.makeText(this, "onClickActionRight", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show();
    }
}
