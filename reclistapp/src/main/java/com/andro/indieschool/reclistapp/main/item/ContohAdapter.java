package com.andro.indieschool.reclistapp.main.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andro.indieschool.reclistapp.R;

import java.util.List;

/**
 * Created by herisulistiyanto on 1/16/18.
 */

public class ContohAdapter extends RecyclerView.Adapter<ContohAdapter.ContohViewHolder> {

    private Context context;
    private List<String> stringList;
    private ContohOnClickItemListener contohListener;

    public ContohAdapter(Context context, List<String> stringList,
                         ContohOnClickItemListener contohListener) {
        this.context = context;
        this.stringList = stringList;
        this.contohListener = contohListener;
    }

    @Override
    public ContohViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(context).inflate(R.layout.item_scroll, parent,
                false);

        return new ContohViewHolder(holderView, contohListener);
    }

    @Override
    public void onBindViewHolder(ContohViewHolder holder, int position) {
        holder.tvInfo.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ContohViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvInfo;
        public ContohOnClickItemListener contohListener;

        public ContohViewHolder(View itemView, ContohOnClickItemListener listener) {
            super(itemView);
            tvInfo = itemView.findViewById(R.id.tv_info);
            itemView.setOnClickListener(this);
            contohListener = listener;
        }

        @Override
        public void onClick(View v) {
            contohListener.contohOnClick(getAdapterPosition());
        }
    }

    public interface ContohOnClickItemListener {
        void contohOnClick(int position);
    }
}
