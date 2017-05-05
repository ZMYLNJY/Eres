package com.se.erest.adapter;

import java.util.List;
import java.util.Map;

import com.se.erest.activity.R;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderItemAdapter extends BaseAdapter {
	
	private Context context;
	private List<Map<String, Object>> orderItems;
	private LayoutInflater orderItemInflater;
	public final class OrderItemView{
		public ImageView imgOrderItem;
		public TextView txtItemName;
		public TextView txtItemPrice;
		public TextView txtItemNumber;
		public ImageButton imbAddItem;
		public ImageButton imbSubItem;
		public ImageButton imbDelItem;
		
	}
	public OrderItemAdapter(Context context,List<Map<String, Object>>listItems){
		this.context = context;
		orderItemInflater = LayoutInflater.from(context);
		this.orderItems = listItems;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return orderItems.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e("method", "getView");
        //自定义视图   
		OrderItemView orderItemView = null;
		if(convertView == null){
			orderItemView = new OrderItemView();
			convertView = orderItemInflater.inflate(R.layout.item_listview_ordercusine, null);
			orderItemView.imbAddItem = (ImageButton) convertView.findViewById(R.id.imbAddItem);
			orderItemView.imbDelItem = (ImageButton) convertView.findViewById(R.id.imbDelItem);
			orderItemView.imbSubItem = (ImageButton) convertView.findViewById(R.id.imbSubItem);
			orderItemView.imgOrderItem = (ImageView) convertView.findViewById(R.id.imgOrderItem);
			orderItemView.txtItemName = (TextView) convertView.findViewById(R.id.txtItemName);
			orderItemView.txtItemNumber = (TextView) convertView.findViewById(R.id.txtItemNumber);
			orderItemView.txtItemPrice = (TextView) convertView.findViewById(R.id.txtItemPrice);
			convertView.setTag(orderItemView);
		}else {
			orderItemView = (OrderItemView) convertView.getTag();
		}
		//设置文字和图片   
		orderItemView.imgOrderItem.setBackgroundResource((Integer) orderItems.get(position).get("ItemImage"));   
        orderItemView.txtItemName.setText((String) orderItems.get(position).get("ItemName"));   
        //orderItemView.txtItemNumber.setText((Integer) orderItems.get(position).get("ItemNumber"));   
        //orderItemView.txtItemPrice.setText((Integer) orderItems.get(position).get("ItemPrice"));   
        orderItemView.imbAddItem.setBackgroundResource(R.drawable.ic_launcher);
        orderItemView.imbSubItem.setBackgroundResource(R.drawable.ic_launcher);
        orderItemView.imbDelItem.setBackgroundResource(R.drawable.ic_launcher);
		return convertView;
	}

}
