package cn.Memo.memogank.Activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.Memo.memogank.R;
import cn.Memo.memogank.Adapter.OnePicAdapter;
import cn.Memo.memogank.Entity.PicList;

public class OnePicActivity extends Activity {
	private int position;//控制初始化位置,暂未实现.
	private List<PicList> picLists;
	private OnePicAdapter onePicAdapter;
	private Gallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_pic);
		Intent intent = getIntent();
		intent.getIntExtra("position", position);
		picLists = (List<PicList>) intent.getSerializableExtra("picLists");

		gallery=(Gallery) findViewById(R.id.gallery1);
		onePicAdapter=new OnePicAdapter(this, picLists);
		gallery.setAdapter(onePicAdapter);
		
		
	}
}
