package cn.Memo.memogank.Presenter.Impl;

import android.graphics.Bitmap;
import cn.Memo.memogank.Model.IModel.CallBack;
import cn.Memo.memogank.Model.ITupianModel;
import cn.Memo.memogank.Model.Impl.TupianModelImpl;
import cn.Memo.memogank.Presenter.ITupianPresenter;
import cn.Memo.memogank.View.ITupianView;

public class TupianPresenterImpl implements ITupianPresenter{
	private ITupianModel iTupianModel;
	private ITupianView iTupianView;
	
	public TupianPresenterImpl(ITupianView iTupianView) {
		this.iTupianView=iTupianView;
		this.iTupianModel=new TupianModelImpl();
	}

	@Override
	public void loadPic(String url) {
		iTupianModel.loadPic(url, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				Bitmap bitmap=(Bitmap) success;
				iTupianView.showPic(bitmap);
			}
			@Override
			public void onError(Object error) {
				
			}
		});
	}

}
