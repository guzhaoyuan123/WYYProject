package com.example.wyyproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.url.guanfangbandan.ListBean;
import com.example.url.guanfangbandan.TracksBean;
import com.example.wyyproject.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopListGuanFangRecyclerviewAdapter extends RecyclerView.Adapter<TopListGuanFangRecyclerviewAdapter.ViewHolder> {
    private Context context;
    private List<ListBean> resultBeans;

    private OnItemClickListener listener;

    private OnItemLongClickListener longClickListener;

    public TopListGuanFangRecyclerviewAdapter(Context context, List<ListBean> resultBeans) {
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

        View view = LayoutInflater.from(context).inflate(R.layout.item_toplist_guanfang,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.toplistTxmeizhougx=view.findViewById(R.id.toplist_tx_meizhougx);
            viewHolder.toplistTxGeming1=view.findViewById(R.id.toplist_tx_geming1);
            viewHolder.toplistTxZuozhe1=view.findViewById(R.id.toplist_tx_zuozhe1);
            viewHolder.toplistTxeming2=view.findViewById(R.id.toplist_tx_geming2);
            viewHolder.toplistTxZuozhe2=view.findViewById(R.id.toplist_tx_zuozhe2);
            viewHolder.toplistTxeming3=view.findViewById(R.id.toplist_tx_geming3);
            viewHolder.toplistTxZuozhe3=view.findViewById(R.id.toplist_tx_zuozhe3);
            viewHolder.imgView=view.findViewById(R.id.toplist_img);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {

            holder.toplistTxmeizhougx.setText(resultBeans.get(i).getUpdateFrequency());
        List<TracksBean> tracksBean = resultBeans.get(i).getTracks();
        Log.e("LLLLLLLLLLLLLLLLL",""+tracksBean.size());
        if (tracksBean.size()==0){

        }else {
                    holder.toplistTxGeming1.setText(tracksBean.get(0).getFirst());
                    holder.toplistTxZuozhe1.setText(resultBeans.get(i).getTracks().get(0).getSecond());
                     holder.toplistTxeming2.setText(resultBeans.get(i).getTracks().get(1).getFirst());
                     holder.toplistTxZuozhe2.setText(resultBeans.get(i).getTracks().get(1).getSecond());
                      holder.toplistTxeming3.setText(resultBeans.get(i).getTracks().get(2).getFirst());
                     holder.toplistTxZuozhe3.setText(resultBeans.get(i).getTracks().get(2).getSecond());
        }

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
        TextView toplistTxmeizhougx
                ,toplistTxGeming1
                ,toplistTxZuozhe1
                ,toplistTxeming2
                ,toplistTxZuozhe2
                ,toplistTxeming3
                ,toplistTxZuozhe3;
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
