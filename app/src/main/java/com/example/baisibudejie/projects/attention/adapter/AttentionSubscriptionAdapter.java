package com.example.baisibudejie.projects.attention.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.baisibudejie.R;
import com.example.baisibudejie.bean.AttentionSubscriptionAdapterBean;
import com.example.baisibudejie.projects.essence.view.views.CircleNetWorkImageView;
import com.example.baisibudejie.utils.VolleyUtils;

import java.util.List;

public class AttentionSubscriptionAdapter extends BaseAdapter {
    private Context context;
    private List<AttentionSubscriptionAdapterBean> subscriptionAdapterBeanList;

    public AttentionSubscriptionAdapter(Context context, List<AttentionSubscriptionAdapterBean> subscriptionAdapterBeanList) {
        this.context = context;
        this.subscriptionAdapterBeanList = subscriptionAdapterBeanList;
    }

    @Override
    public int getCount() {
        return subscriptionAdapterBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return subscriptionAdapterBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_attention_layout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.iv_header=(CircleNetWorkImageView)convertView.findViewById(R.id.iv_header);
            viewHolder.tv_name=(TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tv_attention_count=(TextView)convertView.findViewById(R.id.tv_attention_count);
            viewHolder.bt_attention=(Button)convertView.findViewById(R.id.bt_attention);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        AttentionSubscriptionAdapterBean bean=subscriptionAdapterBeanList.get(position);
        VolleyUtils.loadImage(context,viewHolder.iv_header,bean.getImage_list());

        viewHolder.tv_name.setText(bean.getTheme_name());
        viewHolder.tv_attention_count.setText(bean.getSub_number());
        return convertView;
    }
    class ViewHolder{
        public CircleNetWorkImageView iv_header;
        public TextView tv_name;
        public TextView tv_attention_count;
        public Button bt_attention;
    }
}
