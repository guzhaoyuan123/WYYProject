package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.url.paihangbang.TracksBean;
import com.example.wyyproject.R;

import java.util.List;

public class PaiHangBangAdapter extends BaseAdapter {

    private Context context;
    private List<TracksBean> beans;

    public PaiHangBangAdapter(Context context, List<TracksBean> beans) {
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

    int k=0;
    int j=0;
    int x=0;
    int y=0;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_everdaytuijian,viewGroup,false);
        ImageView item_img_navigation_sq=view.findViewById(R.id.item_img_navigation_sq);
        ImageView item_img_navigation_dujia=view.findViewById(R.id.item_img_navigation_dujia);
        ImageView item_img_navigation_touxiang = view.findViewById(R.id.item_img_navigation_touxiang);
        TextView  item_tx_navigation_geming = view.findViewById(R.id.item_tx_navigation_geming);
        TextView item_tx_navigation_dianshiju= view.findViewById(R.id.item_tx_navigation_dianshiju);
        TextView item_tx_navigation_zuozhe=view.findViewById(R.id.item_tx_navigation_zuozhe);
        TextView item_tx_navigation_geming2= view.findViewById(R.id.item_tx_navigation_geming2);

        item_tx_navigation_geming.setText(beans.get(i).getName());
        item_tx_navigation_geming2.setText(beans.get(i).getAl().getName());
        if (beans.get(i).getAlia()==null){
            item_tx_navigation_dianshiju.setText(" ");
        }else {
            item_tx_navigation_dianshiju.setText(" ");
        }
        item_tx_navigation_zuozhe.setText(beans.get(i).getAr().get(0).getName());
        Glide.with(context).load(beans.get(i).getAl().getPicUrl()).into(item_img_navigation_touxiang);
        item_img_navigation_dujia.setVisibility(View.GONE);
        item_img_navigation_sq.setVisibility(View.GONE);

        if (j==2){
            item_img_navigation_dujia.setVisibility(View.VISIBLE);
            j=0;
        }
        j++;
        if (k==3){

            item_img_navigation_sq.setVisibility(View.VISIBLE);
            k=0;
        }
        k++;
        if (x==4){
            item_img_navigation_dujia.setVisibility(View.VISIBLE);
            item_img_navigation_sq.setVisibility(View.VISIBLE);
            x=0;
        }
        x++;
        return view;
    }
}
