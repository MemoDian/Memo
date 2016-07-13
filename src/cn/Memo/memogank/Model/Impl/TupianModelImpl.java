package cn.Memo.memogank.Model.Impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import cn.Memo.memogank.App.MemoGankApplication;
import cn.Memo.memogank.Model.ITupianModel;

public class TupianModelImpl implements ITupianModel{

	@Override
	public void loadPic(String url,final CallBack callBack) {
		ImageRequest request=new ImageRequest(url, new Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				callBack.onSuccess(response);
			}
		}, 0, 0, Config.RGB_565, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		MemoGankApplication.getQueue().add(request);
	}
}
