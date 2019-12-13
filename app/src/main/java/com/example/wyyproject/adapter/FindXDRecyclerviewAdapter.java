package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.url.tuijiangedan.ResultBean;
import com.example.url.xindie.AlbumsBean;
import com.example.wyyproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FindXDRecyclerviewAdapter extends RecyclerView.Adapter<FindXDRecyclerviewAdapter.ViewHolder> {
    private Context context;
    private List<AlbumsBean> albumsBeans ;

    private OnItemClickListener listener;

    private OnItemLongClickListener longClickListener;

    public FindXDRecyclerviewAdapter(Context context, List<AlbumsBean> albumsBeans) {
        this.context = context;
        this.albumsBeans = albumsBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.find_recyclerview_xindie,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvTitle1=view.findViewById(R.id.tx1_find_item_xindie);
        viewHolder.tvTitle2=view.findViewById(R.id.tx2_find_item_xindie);
        viewHolder.imgView=view.findViewById(R.id.img_find_item_xindie);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        if (i<=2){
            holder.tvTitle1.setText(albumsBeans.get(i).getName());
            holder.tvTitle2.setText(albumsBeans.get(i).getArtist().getName());
            RoundedCorners roundedCorners= new RoundedCorners(10);
            RequestOptions options=RequestOptions.bitmapTransform(roundedCorners);
            Glide.with(context).load(albumsBeans.get(i).getPicUrl()).apply(options).into(holder.imgView);
//
//        Glide.with(context).load(resultBeans.get(i).getPicUrl()).into(holder.imgView);
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
        else {}

    }


    @Override
    public int getItemCount() {
        return albumsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
        TextView tvTitle1,tvTitle2;
        ImageView imgView;
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
