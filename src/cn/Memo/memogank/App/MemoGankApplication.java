package cn.Memo.memogank.App;


import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MemoGankApplication extends Application {
	private static RequestQueue mQueue;
	private static MemoGankApplication app;
	
	public void onCreate() {
		mQueue = Volley.newRequestQueue(this);
		app = this;
	}
	
	public static RequestQueue getQueue(){
		return mQueue;
	}
	
	public static MemoGankApplication getApp(){
		return app;
	}
}
