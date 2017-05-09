package com.se.erest.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.se.erest.adapter.MenuCateAdapter;
import com.se.erest.adapter.MenuItemAdpter;
import com.se.erest.adapter.MenuItemAdpter.ButtonOnClickListener;
import com.se.erest.entity.Category;
import com.se.erest.entity.Contain;
import com.se.erest.entity.Menu_item;
import com.se.erest.task.GetGroByIDTask;
import com.se.erest.task.GetGroByIDTask.GetGroCallBack;
import com.se.erest.task.GetMenuTask;
import com.se.erest.task.GetMenuTask.MenuCateCallBack;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements ButtonOnClickListener, MenuCateCallBack ,
		GetGroCallBack{

	String[] stringsMenuCate = {"今日特价", "主食类", "肉类", "炒菜类", "凉菜类", "汤类", "饮品类"};
	
	private List<Map<String, Object>> dataItemList = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList1 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList2 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList3 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList4 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList5 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList6 = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> dataItemList7 = new ArrayList<Map<String,Object>>();
	
	private List<List<Map<String, Object>>> testList = new ArrayList<List<Map<String,Object>>>();
	private List<Map<String, Object>> cateList = new ArrayList<Map<String,Object>>();
	private List<Map<String, Object>> itemList = new ArrayList<Map<String,Object>>();
	
	public List<Contain> containList = new ArrayList<Contain>();
	
	ListView lsvMenuCate;
	ListView lsvMenuItem;
	TextView txtPrice;
	
	private int catePos;
	private int itemPos;
	private double orderPrice = 0.0;
	
	private String table_id;
	private String wai_id;
	private String ord_id;
	
	MenuItemAdpter adapter;
	MenuCateAdapter cateAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		new GetMenuTask(this).execute();
		
		ord_id = this.getIntent().getStringExtra("order_id");
		table_id = this.getIntent().getStringExtra("table_id");
		wai_id = this.getIntent().getStringExtra("waiter_id");
		
		/*getDataList("红烧牛肉", dataItemList1);
		testList.add(dataItemList1);
		dataItemList.addAll(dataItemList1);
		getDataList("白米饭", dataItemList2);
		testList.add(dataItemList2);
		getDataList("牛肉", dataItemList3);
		testList.add(dataItemList3);
		getDataList("青椒土豆丝", dataItemList4);
		testList.add(dataItemList4);
		getDataList("凉菜系列", dataItemList5);
		testList.add(dataItemList5);
		getDataList("西红柿蛋汤",dataItemList6);
		testList.add(dataItemList6);
		getDataList("甜品类", dataItemList7);
		testList.add(dataItemList7);
		getCateDataList();*/
		
		lsvMenuCate = (ListView)findViewById(R.id.lsv_Menu_cate);
		lsvMenuItem = (ListView)findViewById(R.id.lsv_Menu_dish);
		txtPrice = (TextView)findViewById(R.id.txt_Menu_price);
		TextView txtTable = (TextView)findViewById(R.id.txt_Menu_tableNum);
		txtTable.setText("桌号： #table " + table_id + "          订单号： #order " + ord_id);
		
		cateAdapter = new MenuCateAdapter(getApplicationContext(), cateList);
		lsvMenuCate.setAdapter(cateAdapter);
		
		lsvMenuCate.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int counts = parent.getChildCount();
				for(int i = 0; i < counts; ++i){
					parent.getChildAt(i).setBackgroundColor(Color.rgb(0xd0, 0xd0, 0xd0));
				}
				view.setBackgroundColor(Color.WHITE);
				catePos = position;
				
				new GetGroByIDTask(MenuActivity.this).execute(view.getTag().toString());
			}
		});
		
		adapter = new MenuItemAdpter(itemList, getApplicationContext(), this);
		lsvMenuItem.setAdapter(adapter);
	}
	
	
	public void getDataList(String name, List<Map<String, Object>> list){
		for(int i = 0; i < 10; i++){
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("name", name + i);
			item.put("description", "描述" + i);
			item.put("price", 15.0 + i);
			list.add(item);
		}
	}
	
	public void getCateDataList(){
		for(int i = 0; i < stringsMenuCate.length; i++){
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("name", stringsMenuCate[i]);
			cateList.add(item);
		}
	}


	@Override
	public void onClickButton(View view, Object... objects) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnMenuAddItem:
//			itemPos = (Integer) view.getTag();
//			orderPrice += (Double)testList.get(catePos).get(itemPos).get("price");
			Menu_item mItem = (Menu_item) objects[0];
			orderPrice += mItem.getItem_price();
			txtPrice.setText("￥ " + orderPrice);
			break;

		default:
			break;
		}
	}


	@Override
	public void returnMenuData(String menuData) {
		// TODO Auto-generated method stub
		String[] dataTemp = menuData.split("\\+");
		Gson gson = new Gson();
		
		Type typeCate = new TypeToken<List<Category>>(){}.getType();
		Type typeItem = new TypeToken<List<Menu_item>>(){}.getType();
		
		List<Category> cateLists = new ArrayList<Category>();
		List<Menu_item> itemLists = new ArrayList<Menu_item>();
		cateLists = gson.fromJson(dataTemp[0], typeCate);
		itemLists = gson.fromJson(dataTemp[1], typeItem);
		
		for (Category category : cateLists) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("category", category);
			cateList.add(item);
		}
		
		for (Menu_item menu_item : itemLists) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("item", menu_item);
			itemList.add(item);
		}
		
		adapter.notifyDataSetChanged();
		cateAdapter.notifyDataSetChanged();
	}


	@Override
	public void returnGroData(List<Map<String, Object>> result) {
		// TODO Auto-generated method stub
		this.itemList.clear();
		this.itemList.addAll(result);
		
		adapter.notifyDataSetChanged();
	}
}
