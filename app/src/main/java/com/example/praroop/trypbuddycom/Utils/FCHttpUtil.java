package com.example.praroop.trypbuddycom.Utils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FCHttpUtil {
	private static final int HTTP_TIMEOUT = 1000*60*3;
	public FCHttpUtil() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String okhttpPost(String sUrl, String[] keys, String[] Value) {
		try {
			OkHttpClient client = new OkHttpClient.Builder()
					.connectTimeout(30, TimeUnit.SECONDS)
					.writeTimeout(30, TimeUnit.SECONDS)
					.readTimeout(30, TimeUnit.SECONDS)
					.build();
			String url = sUrl;
			final MediaType MEDIA_TYPE = MediaType.parse("application/json");
			JSONObject postData = new JSONObject();
			try {
				for (int i = 0; i < keys.length; i++) {
					postData.put(keys[i], Value[i]);// URLEncoder.encode(data[i]))
				}
			}
			catch (JSONException e){
				e.printStackTrace();
			}

			RequestBody body= RequestBody.create(MEDIA_TYPE,postData.toString());
			final Request request=new Request.Builder()
					.url(url).post(body).build();
			Response response=client.newCall(request).execute();
			 String res1=response.body().string();
			 return res1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	//////////////////////////////////
}