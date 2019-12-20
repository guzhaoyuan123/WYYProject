package com.example.wyyproject.musicfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.guanfang.GuanFangApi;
import com.example.url.guanfang.PlaylistsBean;
import com.example.wyyproject.R;
import com.example.wyyproject.adapter.FindGDGCRecyclerviewAdapter;
import com.example.wyyproject.util.Http;

import java.io.IOException;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FashionFragment extends Fragment {

    private RecyclerView recyclerView;
    public FashionFragment() {
    }


    public static com.example.wyyproject.fragment.VideoFragment newInstance() {
        com.example.wyyproject.fragment.VideoFragment fragment = new com.example.wyyproject.fragment.VideoFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_fashion,container,false);
        recyclerView = view.findViewById(R.id.fashion_recylist);
        stagger();
        return view;
    }
    private void stagger() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/top/playlist/catlist?limit=21&order=hot");
                    GuanFangApi api = JSON.parseObject(json, GuanFangApi.class);
                    List<PlaylistsBean> result = api.getPlaylists();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTuiJianGeDan(result);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示推荐歌单
    private void showTuiJianGeDan(List<PlaylistsBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        FindGDGCRecyclerviewAdapter adapter = new FindGDGCRecyclerviewAdapter(getContext(), result);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindGDGCRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "haole", Toast.LENGTH_LONG).show();
            }
        });
    }

}
