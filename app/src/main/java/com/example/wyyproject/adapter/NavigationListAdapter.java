package com.example.wyyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wyyproject.R;

import java.util.List;

public class NavigationListAdapter extends BaseAdapter {

    private Context context;
    private List<String> strings;
    private List<Integer> integers;

    public NavigationListAdapter(Context context, List<String> strings, List<Integer> integers) {
        this.context = context;
        this.strings = strings;
        this.integers = integers;
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
        view = LayoutInflater.from(context).inflate(R.layout.item_navigation_list,viewGroup,false);

        ImageView imageView=view.findViewById(R.id.item_img_navigation);
        TextView textView=view.findViewById(R.id.item_tx_navigation);

        imageView.setImageResource(integers.get(i));
        textView.setText(strings.get(i));

        return view;
    }
}
