package com.sexyhair.demoimitationmovie.activity.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.bean.News;

import java.util.List;

/**
 * 新闻列表的适配
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private Activity activity;
    private List<News> newsList = null;

    public NewsListAdapter(Activity activity) {
        this.activity = activity;
    }

    public void notifyData(List<News> newsList) {
        if (newsList == null) {
            return;
        }
        this.newsList = newsList;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (newsList != null && newsList.size() > 0) {
            holder.textView2.setText(newsList.get(position).getTitle());
        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.news_item_list, null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (newsList == null) {
            return 0;
        }
        return newsList.size();
    }
}
