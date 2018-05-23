package com.sexyhair.demoimitationmovie.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sexyhair.demoimitationmovie.R;
import com.sexyhair.demoimitationmovie.common.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sexyhair on 18/4/8.
 */

public class New5RecyclerViewAdapter extends RecyclerView.Adapter<New5RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mList;

    public New5RecyclerViewAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        if (mList != null && mList.size() > 0) {
            this.mList = mList;
        } else {
            this.mList = new ArrayList<>();
            Logger.i(Logger.Log_warn, "New5RecyclerViewAdapter 数据是空");
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //为item创建视图
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(mContext).
                inflate(
                        R.layout.item_activity_recyclerviewclick, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //绑定数据到item上
        holder.textView.setText(mList.get(position));

        if (mOnItemClickListener != null) {
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击item中的textview--" + holder.getLayoutPosition(), Toast.LENGTH_LONG).show();
                }
            });
            holder.new5_recyclerViewItemContanier.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClickListener(holder.new5_recyclerViewItemContanier, holder.getLayoutPosition());

                }
            });
            holder.new5_recyclerViewItemContanier.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClickListener(holder.new5_recyclerViewItemContanier, holder.getLayoutPosition());
                    return false;
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout new5_recyclerViewItemContanier;
        TextView textView;
        Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            button = (Button) itemView.findViewById(R.id.button4);
            new5_recyclerViewItemContanier = (RelativeLayout) itemView.findViewById(R.id.new5_recyclerViewItemContanier);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        if (mOnItemClickListener != null) {
            this.mOnItemClickListener = mOnItemClickListener;
        } else {
            Logger.i(Logger.Log_warn, "New5RecyclerViewAdapter--setOnItemClickListener() 事件监听为空");
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);

        void onItemLongClickListener(View view, int position);
    }
}
