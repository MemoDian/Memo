package cn.Memo.memogank.Model;

public interface IPicModel extends IModel {

	/**
	 * ���ͼƬ����
	 * @param n ͼƬ����
	 * @param callBack
	 */
	void loadPicList(int n, CallBack callBack);
}
