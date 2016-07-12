package cn.Memo.memogank.Fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import cn.Memo.memogank.R;
import cn.Memo.memogank.Adapter.TextAdapter;
import cn.Memo.memogank.Entity.Results;
import cn.Memo.memogank.Presenter.ITextPresenter;
import cn.Memo.memogank.Presenter.Impl.TextPresenterImpl;
import cn.Memo.memogank.View.ITextView;


public class TextFragemnt extends Fragment implements ITextView {
	private ListView lvText;
	private int i=1;
	private ITextPresenter textPresenter;
	private TextAdapter textAdapter;
	private Button btnLast;
	private Button btnNext;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_text, null);
		//初始化
		setViews(view);
		//加载码农新闻列表
		deTextList(i);
		//按钮监听
		setOnClicks();
		return view;
	}

	private void setOnClicks() {
		btnLast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(i!=1){
					i=i-1;
					deTextList(i);
				}
			}
		});
		btnNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					i=i+1;
					deTextList(i);
			}
		});
	}

	private void deTextList(int k) {
		textPresenter.ObtainText(k);
	}

	private void setViews(View view) {
		lvText = (ListView) view.findViewById(R.id.lvText);
		textPresenter = new TextPresenterImpl(this);
		btnNext = (Button) view.findViewById(R.id.btnNext);
		btnLast = (Button) view.findViewById(R.id.btnLast);
	}

	@Override
	public void showText(List<Results> list) {
		textAdapter = new TextAdapter(getActivity(), list);
		lvText.setAdapter(textAdapter);
	}
}
