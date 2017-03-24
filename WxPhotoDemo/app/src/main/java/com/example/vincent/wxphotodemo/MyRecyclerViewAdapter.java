package com.example.vincent.wxphotodemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 Vincent
 * @创时间 2017/3/21
 * @描述 ${TODO}
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private List<Data> mDataList = new ArrayList<>();

    private MessagePicturesLayout.Callback mCallback;

    public void setCallback(MessagePicturesLayout.Callback callback) {
        mCallback = callback;
    }

    public MyRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void set(List<Data> dataList) {
        mDataList.clear();
        if (dataList != null) {
            mDataList.addAll(dataList);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Data data = mDataList.get(position);
        Glide.with(mContext).load(data.getAvatar()).into(holder1.iAvatar);
        holder1.tNickname.setText(data.getNickname());
        holder1.tTime.setText(data.getCreateTime());
        holder1.tContent.setText(data.getContent());
        holder1.lPictures.set(data.getPictureThumbList(), data.getPictureList());
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size()*2;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
       MessagePicturesLayout lPictures;
       ImageView iAvatar;
       TextView tNickname, tTime, tContent;

        public ViewHolder(View itemView) {
            super(itemView);
            iAvatar = (ImageView) itemView.findViewById(R.id.i_avatar);
            tNickname = (TextView) itemView.findViewById(R.id.t_nickname);
            tTime = (TextView) itemView.findViewById(R.id.t_time);
            tContent = (TextView) itemView.findViewById(R.id.t_content);
            lPictures = (MessagePicturesLayout) itemView.findViewById(R.id.l_pictures);
            lPictures.setCallback(mCallback);
        }
    }
}
