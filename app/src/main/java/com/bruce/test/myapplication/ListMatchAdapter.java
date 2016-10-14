package com.bruce.test.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListMatchAdapter extends BaseAdapter{
	private List<String> beans;
	Context context;
	public ListMatchAdapter(Context context, List<String> beans){
		this.context =context;
		this.beans = beans;

	}
	@Override
	public int getCount() {
		return beans == null ? 0 : beans.size();
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public String getItem(int position) {
		return beans.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(android.R.layout.activity_list_item, null);
			viewHolder.tvCode =(TextView)convertView.findViewById(android.R.id.text1);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		String bean = getItem(position);
		
		viewHolder.tvCode.setText(bean);
		return convertView;
	}
	
    private class ViewHolder{
        TextView tvCode;
        TextView tvAddress; 
        TextView tvDate;
        TextView tvStatus;
    }
}
