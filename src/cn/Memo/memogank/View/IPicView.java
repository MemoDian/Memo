package cn.Memo.memogank.View;

import java.util.List;

import cn.Memo.memogank.Entity.PicList;

public interface IPicView extends IView{

	/**
	 * ��ʾͼƬ
	 */
	void showPicList(List<PicList> list);
}
