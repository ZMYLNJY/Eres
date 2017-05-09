package com.se.erest.adapter;

import java.util.List;
import java.util.Map;

import com.se.erest.activity.R;
import com.se.erest.entity.Category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class MenuCateAdapter extends BaseAdapter {

	private Context context;
	private List<Map<String, Object>> list;
	
	public MenuCateAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuCateAdapter(Context context, List<Map<String, Object>> list){
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = View.inflate(context, R.layout.item_listview_menucate, null);
		
		if(position == 0){
			convertView.setBackgroundColor(Color.WHITE);
		}
		
		Map<String, Object> map = list.get(position);

		TextView textView = (TextView)convertView.findViewById(R.id.txtMenuCateItem);
		Category category = (Category) map.get("category");
		textView.setText(category.getCategory_name());
		
		convertView.setTag(category.getCategory_id()+"");
		
		return convertView;
	}

}
