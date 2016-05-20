package com.view.sg.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/11/21
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<DataBeans> mData;

    public ListAdapter(Context mContext,List<DataBeans> dataBeans) {
        this.mContext = mContext;
        this.mData = dataBeans;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //当ViewHolder创建时的回调
        View v = View.inflate(mContext, R.layout.item_list, null);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListViewHolder holder, int position) {
        //当ViewHolder和数据绑定时的回调
        DataBeans dataBeans = mData.get(position);
        holder.setData(dataBeans);
    }

    @Override
    public int getItemCount() {
        //返回的是list数据的个数
        return mData != null ? mData.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivIcon;
        private TextView tvName;

        public ListViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.item_list_iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.item_list_tv_name);
        }

        public void setData(DataBeans dataBeans) {
            ivIcon.setImageResource(dataBeans.icon);
            tvName.setText(dataBeans.title);
        }
    }
}
