package com.sexyhair.demoimitationmovie.activity.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.activity.adapter.New5RecyclerViewAdapter;
import com.sexyhair.demoimitationmovie.common.context.AppContext;
import com.sexyhair.demoimitationmovie.common.utils.ResFileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sexyhair on 18/5/3.
 */

public class HomeSortFragment extends BaseFragment {
    private RecyclerView new5_recyclerView;
    private New5RecyclerViewAdapter mNew5RecyclerViewAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_home_sort;
    }

    @Override
    protected void findViews(View viewContainer) {
        super.findViews(viewContainer);
        new5_recyclerView = (RecyclerView)findViewById(R.id.new5_recyclerView);
        //设置布局管理器：
        /***
         *  默认是垂直方向的写法
         new5_recyclerView.setLayoutManager(new LinearLayoutManager(New5RecyclerViewActivity.this));
         */

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        new5_recyclerView.setLayoutManager(mLinearLayoutManager);
        mNew5RecyclerViewAdapter = new New5RecyclerViewAdapter(this.getActivity(),getData());
        //addItemDecoration（）在setAdapter之前调用；自定义的divider
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL);
        mDividerItemDecoration.setDrawable(ResFileUtil.getDrawable(R.drawable.divider_item_new5recyclerview));
        new5_recyclerView.addItemDecoration(mDividerItemDecoration);
        new5_recyclerView.setAdapter(mNew5RecyclerViewAdapter);
        mNew5RecyclerViewAdapter.setOnItemClickListener(new New5RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(AppContext.appContext,"点击整条item--",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(AppContext.appContext,"长按整条item--",Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<String> getData(){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < 100 ;i++){
            list.add("你好----"+i);
        }
        return list;
    }

}
