package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.wyyproject.R;

import java.util.List;

public class EveryDayTuiJianAdapter extends BaseAdapter {

    private Context context;
    private List<String> strings;

    public EveryDayTuiJianAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;

    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_everdaytuijian,viewGroup,false);

        return view;
    }
}
