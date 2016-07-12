package cn.Memo.memogank.Model;

public interface IPicModel extends IModel {

	/**
	 * 获得图片集合
	 * @param n 图片个数
	 * @param callBack
	 */
	void loadPicList(int n, CallBack callBack);
}
