package cn.Memo.memogank.Fragment;

import java.util.List;

import cn.Memo.memogank.R;
import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.View.IPicView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class PicFragemnt extends Fragment implements IPicView{
	private ListView lvPic;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pic, null);
		//¿Ø¼þ³õÊ¼»¯
		setViews(view);
		
		return view;
	}

	private void setViews(View view) {
		lvPic = (ListView) view.findViewById(R.id.lvPic);
	}

	@Override
	public void showPicList(List<PicList> list) {
		
	}
}
