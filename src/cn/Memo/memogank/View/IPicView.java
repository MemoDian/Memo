package cn.Memo.memogank.View;

import java.util.List;

import cn.Memo.memogank.Entity.PicList;

public interface IPicView extends IView{

	/**
	 * 显示图片
	 */
	void showPicList(List<PicList> list);
	
	/**
	 * 上拉加载
	 * @param list 更新的集合
	 */
	void updatePicList(List<PicList> list);
}
