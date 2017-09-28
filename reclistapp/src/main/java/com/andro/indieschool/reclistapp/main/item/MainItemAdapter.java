package com.andro.indieschool.reclistapp.main.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andro.indieschool.reclistapp.R;
import com.andro.indieschool.reclistapp.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by herisulistiyanto on 8/31/17.
 */

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.MainItemViewHolder> {

    private final String TAG = MainItemAdapter.class.getSimpleName();

    private final Context context;
    private OnItemListener onItemListener;
    private ArrayList<ItemModel> modelArrayList;

    public MainItemAdapter(Context context,
                           OnItemListener onItemListener,
                           ArrayList<ItemModel> modelArrayList) {
        this.context = context;
        this.onItemListener = onItemListener;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public MainItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_scroll, parent, false);
        return new MainItemViewHolder(rootView, onItemListener);
    }

    @Override
    public void onBindViewHolder(MainItemViewHolder holder, int position) {
        String info = modelArrayList.get(position).getInfo();
        holder.tvInfo.setText(info);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MainItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View rootView;
        private OnItemListener onItemListener;

        public TextView tvInfo;

        public MainItemViewHolder(View itemView, final OnItemListener onItemListener) {
            super(itemView);
            this.rootView = itemView;
            this.onItemListener = onItemListener;
            rootView.setOnClickListener(this);

            tvInfo = rootView.findViewById(R.id.tv_info);
        }

        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }
}
