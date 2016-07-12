package cn.Memo.memogank.Adapter;

import java.util.List;

import cn.Memo.memogank.R;
import cn.Memo.memogank.Entity.Results;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter {
	private Context context;
	private List<Results> list;
	private LayoutInflater inflater;
	
	public TextAdapter(Context context, List<Results> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.item_text, null);
			holder = new viewHolder();
			holder.tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
			holder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
			convertView.setTag(holder);
		}
		holder = (viewHolder) convertView.getTag();
		holder.tvAuthor.setText(list.get(position).getWho());
		holder.tvContent.setText(list.get(position).getDesc());
		return convertView;
	}

	class viewHolder{
		TextView tvAuthor;
		TextView tvContent;
	}
}
