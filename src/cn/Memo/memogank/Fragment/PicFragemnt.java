package cn.Memo.memogank.Fragment;

import java.io.Serializable;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import cn.Memo.memogank.R;
import cn.Memo.memogank.Activity.OnePicActivity;
import cn.Memo.memogank.Adapter.PicAdapter;
import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.Presenter.IPicPresenter;
import cn.Memo.memogank.Presenter.Impl.PicpresenterImpl;
import cn.Memo.memogank.View.IPicView;

public class PicFragemnt extends Fragment implements IPicView {
	private GridView GvPic;
	private PicAdapter picAdapter;
	private IPicPresenter picPresenter;
	private List<PicList> picLists;
	private int n = 1;
	private TextView tvXiala;
	private Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				n += 1;
				picPresenter.addPic(n);
				picAdapter.notifyDataSetChanged();
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pic, null);
		// 控件初始化
		setViews(view);
		picPresenter.loadPic(n);
		// 图片列表监听
		setLvpicOnScroll();
		return view;
	}

	private void setLvpicOnScroll() {
		//滚动加载监听
		GvPic.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

				if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
					if (view.getLastVisiblePosition() == view.getCount() - 1) {
						tvXiala.setVisibility(View.VISIBLE);
						new Thread(new Runnable() {
							public void run() {
								try {
									Thread.sleep(3000);
									Message msg = new Message();
									msg.what=1;
									handler.sendMessage(msg);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();
					}
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}
		});
		//点击放大监听
		GvPic.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(getActivity(),OnePicActivity.class);
				intent.putExtra("picLists", (Serializable)picLists);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
	}
	
	private void setViews(View view) {
		GvPic = (GridView) view.findViewById(R.id.gvPic);
		tvXiala = (TextView) view.findViewById(R.id.tvXiala);
		picPresenter = new PicpresenterImpl(this);
	}

	@Override
	public void showPicList(List<PicList> list) {
		picLists = list;
		picAdapter = new PicAdapter(picLists, getActivity());
		GvPic.setAdapter(picAdapter);
	}

	@Override
	public void updatePicList(List<PicList> list) {
		picLists = list;
		tvXiala.setVisibility(View.GONE);
	}
}
