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

public class GetMenuTask extends AsyncTask<Void, Void, String> {

	private MenuCateCallBack mCallBack;
	
	public GetMenuTask(MenuCateCallBack mCallBack) {
		// TODO Auto-generated constructor stub
		this.mCallBack = mCallBack;
	}
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		String url = "http://47.93.187.232:8080/Erest/GetCatoriesServlet";
		
		HttpClient client=new DefaultHttpClient();
		HttpPost request=new HttpPost(url);
		
		try {
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
		mCallBack.returnMenuData(result);
	}
	
	public interface MenuCateCallBack{
		void returnMenuData(String menuData);
	}

}
