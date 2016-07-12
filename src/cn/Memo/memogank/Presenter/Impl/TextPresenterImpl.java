package cn.Memo.memogank.Presenter.Impl;

import java.util.List;

import cn.Memo.memogank.Entity.Results;
import cn.Memo.memogank.Model.IModel.CallBack;
import cn.Memo.memogank.Model.ITextModel;
import cn.Memo.memogank.Model.Impl.TextModelImpl;
import cn.Memo.memogank.Presenter.ITextPresenter;
import cn.Memo.memogank.View.ITextView;

public class TextPresenterImpl implements ITextPresenter {
	private ITextModel textModel;
	private ITextView textView;
	
	public TextPresenterImpl(ITextView textView) {
		this.textModel = new TextModelImpl();
		this.textView = textView;
	}

	@Override
	public void ObtainText(int i) {
		textModel.loadTextList(i, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				List<Results> list = (List<Results>) success;
				textView.showText(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}

}
