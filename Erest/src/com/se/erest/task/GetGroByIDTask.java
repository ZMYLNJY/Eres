package com.se.erest.task;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.se.erest.entity.Menu_item;

import android.os.AsyncTask;
import android.util.Log;

public class GetGroByIDTask extends AsyncTask<String, Void, String> {

	private GetGroCallBack gCallback;
	
	public GetGroByIDTask(GetGroCallBack gCallBack) {
		// TODO Auto-generated constructor stub
		this.gCallback = gCallBack;
	}
	
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = "http://47.93.187.232:8080/Erest/GetItemsOfCategoryServlet";
		
		String category_id = params[0];
		
		HttpClient client=new DefaultHttpClient();
		HttpPost request=new HttpPost(url);
		
		try {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("category_id", category_id));
			request.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
			
			HttpResponse response=client.execute(request);
			
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				String result=EntityUtils.toString(response.getEntity());
				Log.e("result", result);
//				mCallBack.returnMenuData(result);
				
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

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		Gson gson = new Gson();
		Type typeItem = new TypeToken<List<Menu_item>>(){}.getType();
		List<Menu_item> list = gson.fromJson(result, typeItem);
		for (Menu_item menu_item : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("item", menu_item);
			resultList.add(map);
		}
		
		gCallback.returnGroData(resultList);
	}
	
	public interface GetGroCallBack{
		void returnGroData(List<Map<String, Object>> result);
	}
	
}
