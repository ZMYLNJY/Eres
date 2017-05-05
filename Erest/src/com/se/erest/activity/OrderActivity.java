package com.se.erest.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.se.erest.adapter.OrderItemAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class OrderActivity extends Activity {
	private ListView itemListView;
	private OrderItemAdapter itemAdapter;
	private List<Map<String, Object>> listItems;
	private Integer[] imgIDs = {R.drawable.ic_launcher,    
	            R.drawable.ic_launcher, R.drawable.ic_launcher,   
	            R.drawable.ic_launcher, R.drawable.ic_launcher,   
	            R.drawable.ic_launcher};   
    private String[] txtItemNames = {"蛋糕", "礼物",    
	            "邮票", "爱心", "鼠标", "音乐CD"};   
    private Integer[] txtItemPrice = {   
	            24,23,13,19,18,29 }; 
    private Integer[] txtItemNumber = {   
    			2,1,1,1,1,2 };
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		Intent intent = getIntent();
        //People people = (People) intent.getSerializableExtra("people");
        //Log.i("DATA_SHOW","name-->"+people.getName()+",sex-->"+people.getSex()+",age-->"+people.getAge());
		int tableID = (Integer) intent.getSerializableExtra("tableID");
		initOrderView(tableID);
		itemListView =  (ListView) findViewById(R.id.lv_Order_Item);
		listItems = getListItems();
		itemAdapter = new OrderItemAdapter(this, listItems); //创建适配器   
        itemListView.setAdapter(itemAdapter);   
		
	}

	private void initOrderView(int tableID) {
		// TODO Auto-generated method stub
		
		
	}
	 private List<Map<String, Object>> getListItems() {   
	        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
	        for(int i = 0; i < txtItemNames.length; i++) {   
	            Map<String, Object> map = new HashMap<String, Object>();    
	            map.put("ItemImage", imgIDs[i]);              //图片资源   
	            map.put("ItemName", txtItemNames[i]);         //物品标题  
	            Log.e("name", txtItemNames[i]);
	            map.put("ItemNumber", txtItemNumber[i]);     //物品数量    
	            map.put("ItemPrice", txtItemPrice[i]);     //物品价格
	            listItems.add(map);   
	        }      
	        return listItems;   
	    } 
}
