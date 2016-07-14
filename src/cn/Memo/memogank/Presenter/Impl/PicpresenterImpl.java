package cn.Memo.memogank.Presenter.Impl;

import java.util.List;

import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.Model.IModel.CallBack;
import cn.Memo.memogank.Model.IPicModel;
import cn.Memo.memogank.Model.Impl.PicModelImpl;
import cn.Memo.memogank.Presenter.IPicPresenter;
import cn.Memo.memogank.View.IPicView;

public class PicpresenterImpl implements IPicPresenter{
	private IPicView iPicView;
	private IPicModel iPicModel;
	private List<PicList> list;
	
	public PicpresenterImpl(IPicView iPicView) {
		this.iPicView=iPicView;
		this.iPicModel=new PicModelImpl();
	}

	@Override
	public void loadPic(int n) {
		iPicModel.loadPicList(n, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				list =(List<PicList>) success;
				iPicView.showPicList(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}

	@Override
	public void addPic(int n) {
		iPicModel.addPicList(n, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				list=(List<PicList>) success;
				iPicView.updatePicList(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}
}
