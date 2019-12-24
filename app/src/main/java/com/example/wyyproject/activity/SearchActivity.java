package com.example.wyyproject.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.morensousuo.MoRenSearch;
import com.example.url.resoubang.DataBean;
import com.example.url.resoubang.SerachReSouBang;
import com.example.url.sousuoliebiao.SearchList;
import com.example.wyyproject.R;
import com.example.wyyproject.adapter.SearchListAdatper;
import com.example.wyyproject.adapter.SearchReSouBangAdapter;
import com.example.wyyproject.util.Http;

import java.io.IOException;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.img_search_fanhui)
    ImageView imgSearchFanhui;
    @BindView(R.id.et_search_searchName)
    EditText etSearchSearchName;
    @BindView(R.id.img_search_searchimg)
    ImageView imgSearchSearchimg;
    @BindView(R.id.list_search_resoubang)
    ListView listSearchResoubang;
    @BindView(R.id.search_linear)
    LinearLayout searchLinear;
    @BindView(R.id.search_nest)
    NestedScrollView searchNest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initView();
        initView2();
    }
    //加载热搜榜
    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/search/hot/detail");
                    SerachReSouBang theNewDisc = JSON.parseObject(json, SerachReSouBang.class);
                    List<DataBean> albums = theNewDisc.getData();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showXin(albums);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //展示热搜榜
    private void showXin(List<DataBean> albums) {
        SearchReSouBangAdapter adapter = new SearchReSouBangAdapter(this, albums);
        listSearchResoubang.setAdapter(adapter);
        fixListViewHeight(listSearchResoubang);
        adapter.notifyDataSetChanged();
        listSearchResoubang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SearchActivity.this, "okok", Toast.LENGTH_LONG).show();
            }
        });
    }

    //加载热搜榜
    private void initView2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/search/default");
                    MoRenSearch api = JSON.parseObject(json, MoRenSearch.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            etSearchSearchName.setHint(api.getData().getShowKeyword());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    ///search/hot
    @OnClick({R.id.img_search_fanhui, R.id.img_search_searchimg, R.id.search_nest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_search_fanhui:
                SearchActivity.this.finish();
                break;
            case R.id.img_search_searchimg:
                searchMusicName();
                break;
            case R.id.search_nest:
                break;
        }
    }

    //    /search/suggest?keywords= 海阔天空
//    /search/suggest?keywords= 海阔天空&type=mobile
    private void searchMusicName() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/search/suggest?keywords="
                            + etSearchSearchName.getText().toString() + "&type=mobile");
                    SearchList api = JSON.parseObject(json, SearchList.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            shouList(api);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void shouList(SearchList api) {
        if (api.getResult()==null){
        }else {
            SearchListAdatper adapter = new SearchListAdatper(this, api.getResult().getAllMatch());

            AlertDialog alertDialog = new AlertDialog
                    .Builder(this)
                    .setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create();
            alertDialog.show();
        }
    }


    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int index = 0, len = listAdapter.getCount(); index < len; index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
