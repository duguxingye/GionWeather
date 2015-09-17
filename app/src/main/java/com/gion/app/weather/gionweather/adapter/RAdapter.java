package com.gion.app.weather.gionweather.adapter;

//import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.gion.app.weather.gionweather.R;

import java.util.List;

/**
 * Created by hua on 2015/9/8.
 */
public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

//    private String[] mDataset;
    private List<String> dataList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView cTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cTextView = (TextView) itemView.findViewById(R.id.text_view);
        }

    }

    public RAdapter(List<String> myDataList) {
        this.dataList = myDataList;
    }

    @Override
    public RAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewTipe) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener rOnItemClickListener;

    public void setOnClickListener(OnItemClickListener rOnItemClickListener) {
        this.rOnItemClickListener = rOnItemClickListener;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.cTextView.setText(dataList.get(position));
        if (rOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rOnItemClickListener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(int position, List<String> dataList) {
        position = dataList.size() + 1;
        dataList.add(position, "insert one");
        notifyItemInserted(position);
    }
    public void removeData(List<String> dataList) {
        int position = dataList.size();
        dataList.remove(position);
        notifyItemRemoved(position);
    }




}
