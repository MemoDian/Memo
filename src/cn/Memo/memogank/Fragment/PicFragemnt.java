package cn.Memo.memogank.Fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import cn.Memo.memogank.R;
import cn.Memo.memogank.Adapter.PicAdapter;
import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.Presenter.IPicPresenter;
import cn.Memo.memogank.Presenter.Impl.PicpresenterImpl;
import cn.Memo.memogank.View.IPicView;


public class PicFragemnt extends Fragment implements IPicView{
	private ListView lvPic;
	private PicAdapter picAdapter;
	private IPicPresenter picPresenter;
	private List<PicList> picLists;
	private int n=1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pic, null);
		//控件初始化
		setViews(view);
		picPresenter.loadPic(n);
		//图片列表监听
		setLvpicOnScroll();
		return view;
	}

	private void setLvpicOnScroll() {
		lvPic.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if(scrollState==OnScrollListener.SCROLL_STATE_IDLE){
					if(view.getLastVisiblePosition()==view.getCount()-1){
						n+=1;
						picPresenter.addPic(n);
						picAdapter.notifyDataSetChanged();
					}
				}
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}
		});		
	}

	private void setViews(View view) {
		lvPic = (ListView) view.findViewById(R.id.lvPic);
		picPresenter=new PicpresenterImpl(this);
	}

	@Override
	public void showPicList(List<PicList> list) {
		picLists=list;
		picAdapter = new PicAdapter(picLists,getActivity());
		lvPic.setAdapter(picAdapter);
	}

	@Override
	public void updatePicList(List<PicList> list) {
		picLists=list;
	}
}
