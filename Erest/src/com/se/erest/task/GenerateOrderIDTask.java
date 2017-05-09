package com.se.erest.task;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class GenerateOrderIDTask extends AsyncTask<String, Integer, String> {

	private OrderIDCallBack oCallback;
	
	public GenerateOrderIDTask(OrderIDCallBack oCallBack) {
		// TODO Auto-generated constructor stub
		this.oCallback = oCallBack;
	}
	
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String table_id = params[0];
		String wai_id = params[1];
		String url = params[2] + "GetOrderIdServlet";
		
		HttpClient client=new DefaultHttpClient();
		HttpPost request=new HttpPost(url);
		
		try {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("table_id", table_id));
			pairs.add(new BasicNameValuePair("waiter_id", wai_id));
			request.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
			
			HttpResponse response=client.execute(request);
			
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			
				String result=EntityUtils.toString(response.getEntity());
				
				oCallback.returnOrderID(result);
				
                return result;	
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public interface OrderIDCallBack{
		void returnOrderID(String orderID);
	}
	
}
