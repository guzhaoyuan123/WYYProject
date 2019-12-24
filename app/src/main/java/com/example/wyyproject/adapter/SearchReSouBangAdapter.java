package com.example.wyyproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.url.resoubang.DataBean;
import com.example.wyyproject.R;

import java.util.List;

public class SearchReSouBangAdapter extends BaseAdapter {
    private Context context;
    private List<DataBean> beans;

    public SearchReSouBangAdapter(Context context, List<DataBean> beans) {
        this.context = context;
        this.beans = beans;

    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int i) {
        return beans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_search_resoubang,viewGroup,false);
        ImageView hot=view.findViewById(R.id.img_item_search_hot);
        TextView geming = view.findViewById(R.id.tx_item_search_geming);
        TextView geci= view.findViewById(R.id.tx_item_search_geci);
        TextView renshu=view.findViewById(R.id.tx_item_search_renshu);
        TextView num=view.findViewById(R.id.tx_item_search_num);
        if (i<=2){
            num.setTextColor(Color.RED);
            num.setText(i+1+"");
        }else if (i>2){
            num.setText(i+1+"");
        }
        geming.setText(beans.get(i).getSearchWord());
        geci.setText(beans.get(i).getContent());
        renshu.setText(beans.get(i).getScore());
        if (beans.get(i).getIconUrl()!=null){
            Glide.with(context).load(beans.get(i).getIconUrl()).into(hot);
        }else hot.setVisibility(View.GONE);

        return view;
    }
}
