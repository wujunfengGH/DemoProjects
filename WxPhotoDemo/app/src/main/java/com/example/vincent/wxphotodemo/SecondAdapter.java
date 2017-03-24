package com.example.vincent.wxphotodemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @创建者 Vincent
 * @创时间 2017/3/23
 * @描述 ${TODO}
 */
public class SecondAdapter extends RecyclerView.Adapter{


    private Context mContext;

    public SecondAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item_view,parent,false);
        return new SecondHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SecondHolder holder1 = (SecondHolder) holder;
        Glide.with(mContext)
                .load(R.mipmap.aaa)
                .centerCrop()
                .into(holder1.imageView);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SecondHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public SecondHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
