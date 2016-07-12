package cn.Memo.memogank.Model.Impl;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import cn.Memo.memogank.App.MemoGankApplication;
import cn.Memo.memogank.Entity.Results;
import cn.Memo.memogank.Entity.Text;
import cn.Memo.memogank.Model.ITextModel;
import cn.Memo.memogank.Util.Url;

public class TextModelImpl implements ITextModel {

	@Override
	public void loadTextList(int i, final CallBack callBack) {
		String url = Url.TEXT_URL+i;
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Text text = gson.fromJson(response, Text.class);
				List<Results> list = text.getResults();
				callBack.onSuccess(list);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		MemoGankApplication.getQueue().add(request);
	}

}
