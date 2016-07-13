package cn.Memo.memogank.Model.Impl;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import cn.Memo.memogank.App.MemoGankApplication;
import cn.Memo.memogank.Entity.Pic;
import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.Model.IPicModel;
import cn.Memo.memogank.Util.Url;

public class PicModelImpl implements IPicModel {

	@Override
	public void loadPicList(int n, final CallBack callBack) {
		String url = Url.PIC_URL + n + "/1";
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Pic pic = gson.fromJson(response, Pic.class);
				List<PicList> picLists = pic.getResults();
				callBack.onSuccess(picLists);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		MemoGankApplication.getQueue().add(request);
	}
}
