package com.se.erest.adapter;

import java.util.List;
import java.util.Map;

import com.se.erest.activity.R;
import com.se.erest.entity.Menu_item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ViewHolder")
public class MenuItemAdpter extends BaseAdapter {

	private Context context;
	private List<Map<String, Object>> list;
	private ButtonOnClickListener clickListener;
	
	Menu_item mItem;
	
	public MenuItemAdpter(List<Map<String, Object>>list, Context context, ButtonOnClickListener clickListener){
		this.list = list;
		this.context = context;
		this.clickListener = clickListener;
	}
	
	public MenuItemAdpter() {
		// TODO Auto-generated constructor stub
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
		convertView = View.inflate(context, R.layout.item_listview_menuitem, null);
		
		Map<String, Object> map = list.get(position);
		
		ImageView imageView = (ImageView)convertView.findViewById(R.id.imgMenuMenuItem);
//		imageView.setBackgroundResource(R.drawable.ic_launcher);
		
		TextView txtName = (TextView)convertView.findViewById(R.id.txtMenuItemName);
		TextView txtDesc = (TextView)convertView.findViewById(R.id.txtMenuItemDesc);
		TextView txtPrice = (TextView)convertView.findViewById(R.id.txtMenuItemPrice);
		mItem = (Menu_item) map.get("item");
		txtName.setText(mItem.getItem_name());
		txtDesc.setText(mItem.getItem_description());
		txtPrice.setText("￥" + mItem.getItem_price());
		
		Button btnAdd = (Button)convertView.findViewById(R.id.btnMenuAddItem);
		btnAdd.setTag(position);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				clickListener.onClickButton(view, mItem);
			}
		});
		
		return convertView;
	}

	public interface ButtonOnClickListener{
		void onClickButton(View view, Object... objects);
	}
	
}
