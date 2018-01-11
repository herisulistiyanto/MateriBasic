package com.andro.indieschool.myfragmentapp.contoh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by herisulistiyanto on 10/25/17.
 */

public abstract class BaseContoh extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contohFungsi();
    }

    protected abstract void contohFungsi();
}
