package com.example.wyyproject.musicfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.tuijiangedan.RecommendThePlayList;
import com.example.url.tuijiangedan.ResultBean;
import com.example.wyyproject.R;
import com.example.wyyproject.adapter.FindTJGDRecyclerviewAdapter;
import com.example.wyyproject.util.Http;

import java.io.IOException;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChineseFragment extends Fragment {


    private RecyclerView recyclerView;
    public ChineseFragment() {

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
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_chinese,container,false);
        recyclerView = view.findViewById(R.id.chinese_recylist);
        stagger();
        return view;
    }


    private void stagger() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/personalized?limit=21");
                    RecommendThePlayList recommendThePlayList = JSON.parseObject(json, RecommendThePlayList.class);
                    List<ResultBean> result = recommendThePlayList.getResult();
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
    private void showTuiJianGeDan(List<ResultBean> result) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        FindTJGDRecyclerviewAdapter adapter = new FindTJGDRecyclerviewAdapter(getContext(), result);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FindTJGDRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "haole", Toast.LENGTH_LONG).show();
            }
        });
    }



}
