package cn.Memo.memogank.Activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;
import cn.Memo.memogank.R;
import cn.Memo.memogank.Adapter.OnePicAdapter;
import cn.Memo.memogank.Entity.PicList;

public class OnePicActivity extends Activity {
	private Gallery gallery;
	private int position;
	private List<PicList> picLists;
	private OnePicAdapter onePicAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_pic);
		Intent intent=getIntent();
		intent.getIntExtra("position", position);
		picLists=(List<PicList>) intent.getSerializableExtra("picLists");
		
		gallery=(Gallery) findViewById(R.id.gallery);
		onePicAdapter=new OnePicAdapter(this, picLists);
		gallery.setAdapter(onePicAdapter);
		
	}

}
