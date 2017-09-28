package com.andro.indieschool.reclistapp.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.main.item.MainItemAdapter;
import com.andro.indieschool.reclistapp.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by herisulistiyanto on 8/31/17.
 */

public class SecondActivity extends AppCompatActivity implements MainItemAdapter.OnItemListener {

    private RecyclerView recyclerViewVertical;
    private RecyclerView recyclerViewHorizontal;
    private RecyclerView recyclerViewGrid;
    private MainItemAdapter adapter;
    private ArrayList<ItemModel> itemModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemModelArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            itemModelArrayList.add(new ItemModel(String.valueOf( (i + 1) )));
        }

        adapter = new MainItemAdapter(SecondActivity.this, this, itemModelArrayList);

        recyclerViewVertical = findViewById(R.id.recyclerVertical);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewVertical.setAdapter(adapter);

        recyclerViewGrid = findViewById(R.id.recyclerGrid);
        recyclerViewGrid.setLayoutManager(new GridLayoutManager(this, 5));
        recyclerViewGrid.setAdapter(adapter);

        recyclerViewHorizontal = findViewById(R.id.recyclerHorizontal);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontal.setAdapter(adapter);

        TextView tvAct = findViewById(R.id.tv_act);
        tvAct.setText("SECOND ACTIVITY");
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "KLIK DARI SECOND ACT", Toast.LENGTH_SHORT).show();
    }

}
