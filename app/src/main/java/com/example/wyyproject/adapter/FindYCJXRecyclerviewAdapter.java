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
import com.example.url.shipingdizhileixing.DataBean;
import com.example.wyyproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FindYCJXRecyclerviewAdapter extends RecyclerView.Adapter<FindYCJXRecyclerviewAdapter.ViewHolder> {
    private Context context;
    private List<DataBean> datasBeans ;

    private OnItemClickListener listener;

    private OnItemLongClickListener longClickListener;

    public FindYCJXRecyclerviewAdapter(Context context, List<DataBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.find_recyclerview_yuncunjingxuan,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvTitle1=view.findViewById(R.id.tx_find_item_yuncunjingxuan);
        viewHolder.imgView2=view.findViewById(R.id.drawee_img_yuncunjingxuan);
        viewHolder.imgView=view.findViewById(R.id.img_find_item_yuncunjingxuan);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        if (i<=2){
            holder.tvTitle1.setText(datasBeans.get(i).getName());

            RoundedCorners roundedCorners2= new RoundedCorners(200);
            RequestOptions options2=RequestOptions.bitmapTransform(roundedCorners2);
            Glide.with(context).load(datasBeans.get(i).getCover()).apply(options2).into(holder.imgView2);

            RoundedCorners roundedCorners= new RoundedCorners(30);
            RequestOptions options=RequestOptions.bitmapTransform(roundedCorners);
            Glide.with(context).load(datasBeans.get(i).getCover()).apply(options2).apply(options).into(holder.imgView);

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
        return datasBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
        TextView tvTitle1;
        ImageView imgView,imgView2;
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
