package com.andro.indieschool.reclistapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.main.item.MainItemAdapter;
import com.andro.indieschool.reclistapp.model.ItemModel;
import com.andro.indieschool.reclistapp.second.SecondActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainItemAdapter.OnItemListener {

    private RecyclerView recyclerViewVertical;
    private RecyclerView recyclerViewHorizontal;
    private RecyclerView recyclerViewGrid;
    private MainItemAdapter adapter;
    private ArrayList<ItemModel> itemModelArrayList;

    private Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemModelArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            itemModelArrayList.add(new ItemModel(String.valueOf( (i + 1) )));
        }

        adapter = new MainItemAdapter(MainActivity.this, this, itemModelArrayList);

        recyclerViewVertical = findViewById(R.id.recyclerVertical);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewVertical.setAdapter(adapter);

        recyclerViewGrid = findViewById(R.id.recyclerGrid);
        recyclerViewGrid.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerViewGrid.setAdapter(adapter);

        recyclerViewHorizontal = findViewById(R.id.recyclerHorizontal);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontal.setAdapter(adapter);

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        TextView tvAct = findViewById(R.id.tv_act);
        tvAct.setText("MAIN ACTIVITY");
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,
                itemModelArrayList.get(position).getInfo(),
                Toast.LENGTH_SHORT)
                .show();
    }
}
