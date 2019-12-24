package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.url.sousuoliebiao.AllMatchBean;
import com.example.wyyproject.R;

import java.util.List;

public class SearchListAdatper extends BaseAdapter {

    private Context context;
    private List<AllMatchBean> beans;

    public SearchListAdatper(Context context, List<AllMatchBean> beans) {
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
        view = LayoutInflater.from(context).inflate(R.layout.item_search_list,viewGroup,false);

        TextView name=view.findViewById(R.id.tx_item_search_list_name);
        name.setText(beans.get(i).getKeyword());
        return view;
    }
}

