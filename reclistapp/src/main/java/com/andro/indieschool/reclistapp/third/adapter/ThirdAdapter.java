package com.andro.indieschool.reclistapp.third.adapter;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.indieschool.reclistapp.R;

import java.util.List;

/**
 * Created by herisulistiyanto on 11/3/17.
 */

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.MyThirdHolder> {

    private Context context;
    private List<String> header;

    public ThirdAdapter(Context context, List<String> header) {
        this.context = context;
        this.header = header;
    }

    @Override
    public MyThirdHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_input, parent, false);
        return new MyThirdHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyThirdHolder holder, int position) {
        holder.tilInput.setHint(header.get(position));
    }

    @Override
    public int getItemCount() {
        return header.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class MyThirdHolder extends RecyclerView.ViewHolder {

        private TextInputLayout tilInput;
        private TextInputEditText etInput;

        public MyThirdHolder(View itemView) {
            super(itemView);
            tilInput = itemView.findViewById(R.id.til_input);
            etInput = itemView.findViewById(R.id.et_input);
        }
    }

}
