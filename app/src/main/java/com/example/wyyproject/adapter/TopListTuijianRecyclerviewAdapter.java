package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.url.guanfangbandan.ListBean;
import com.example.wyyproject.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopListTuijianRecyclerviewAdapter extends RecyclerView.Adapter<TopListTuijianRecyclerviewAdapter.ViewHolder> {
    private Context context;
    private List<ListBean> resultBeans;

    private OnItemClickListener listener;

    private OnItemLongClickListener longClickListener;

    public TopListTuijianRecyclerviewAdapter(Context context, List<ListBean> resultBeans) {
        this.context = context;
        if (resultBeans==null){
            this.resultBeans = new ArrayList<>();
        }else {
            this.resultBeans = resultBeans;
        }
    }

    int k=0;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_toplist_tuijian,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.textView1=view.findViewById(R.id.toplist_tx_tuijian);
            viewHolder.textView2=view.findViewById(R.id.toplist_tx_tuijian2);
            viewHolder.imgView=view.findViewById(R.id.toplist_img_tuijian);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        holder.textView1.setText(resultBeans.get(i).getUpdateFrequency());
        holder.textView2.setText(resultBeans.get(i).getName());
        Glide.with(context).load(resultBeans.get(i).getCoverImgUrl()).into(holder.imgView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(i);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    longClickListener.onClick(i);
                }
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
        TextView textView1
                ,textView2;
        RoundedImageView imgView;
    }

    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemLongClickListener {
        void onClick(int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
}
