package cn.Memo.memogank.Adapter;

import java.util.List;

import cn.Memo.memogank.R;
import cn.Memo.memogank.Entity.PicList;
import cn.Memo.memogank.Presenter.ITupianPresenter;
import cn.Memo.memogank.Presenter.Impl.TupianPresenterImpl;
import cn.Memo.memogank.View.ITupianView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PicAdapter extends BaseAdapter implements ITupianView{
	private List<PicList> list;
	private Context context;
	private LayoutInflater inflater;
	private ITupianPresenter TupianPresenterImpl;
	private Bitmap bitmap;
	
	public PicAdapter(List<PicList> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		this.inflater=LayoutInflater.from(context);
		this.TupianPresenterImpl=new TupianPresenterImpl(this);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.item_pic, null);
			holder.ivPic=(ImageView) convertView.findViewById(R.id.ivPic);
			holder.tvTime=(TextView) convertView.findViewById(R.id.tvTime);
			convertView.setTag(holder);
		}
		holder=(ViewHolder) convertView.getTag();
		String time = list.get(position).getPublishedAt();
		time = time.split("T")[0];
		String url = list.get(position).getUrl();
		TupianPresenterImpl.loadPic(url);
		holder.ivPic.setImageBitmap(bitmap);
		holder.tvTime.setText(time);
		return convertView;
	}

	class ViewHolder{
		ImageView ivPic;
		TextView tvTime;
	}

	@Override
	public void showPic(Bitmap bitmap) {
		this.bitmap=bitmap;
	}
}
