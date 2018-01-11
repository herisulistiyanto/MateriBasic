package com.andro.indieschool.reclistapp.third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.third.adapter.ThirdAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by herisulistiyanto on 11/3/17.
 */

public class ThirdActivity extends AppCompatActivity {

    private ThirdAdapter adapter;
    private RecyclerView rvInputs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String[] header = {
                "nama", "alamat", "nik", "perusahaan", "alamat kantor", "pendidikan terakhir",
                "alamat tinggal", "telepon", "keperluan", "kemampuan", "alamat kampus", "merk laptop",
                "merk hp", "kendaraan", "alokasi waktu", "title", "occupation"
        };

        List<String> headerList = new ArrayList<>(Arrays.asList(header));
        rvInputs = findViewById(R.id.rv_inputs);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvInputs.setLayoutManager(manager);

        adapter = new ThirdAdapter(this, headerList);
        rvInputs.setAdapter(adapter);
    }
}
