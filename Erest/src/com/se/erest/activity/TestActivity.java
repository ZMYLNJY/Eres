package com.se.erest.activity;

import com.se.erest.task.GenerateOrderIDTask;
import com.se.erest.task.GenerateOrderIDTask.OrderIDCallBack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity implements OrderIDCallBack{

	private String orderID;
	
	private String table_id = "1";
	private String wai_id = "10";
	private String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		url = this.getString(R.string.url);
		
		Button button = (Button)findViewById(R.id.btnTestOrder);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Log.e("onclick", "onclick le");
				new GenerateOrderIDTask(TestActivity.this).execute(table_id, wai_id, url);
			}
		});
		
	}

	@Override
	public void returnOrderID(String ord_id) {
		// TODO Auto-generated method stub
		//this.orderID =  Integer.parseInt(orderID);
		orderID = ord_id;
		if(! "0".equals(orderID)){
			Intent intent = new Intent(TestActivity.this, MenuActivity.class);
			intent.putExtra("order_id", this.orderID);
			intent.putExtra("table_id", table_id);
			intent.putExtra("waiter_id", wai_id);
			startActivity(intent);
		}
	}
}
