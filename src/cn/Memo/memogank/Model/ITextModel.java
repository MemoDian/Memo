package cn.Memo.memogank.Model;

public interface ITextModel extends IModel {

	/**
	 * 加载码农新闻列表
	 * @param i 第几页
	 * @param callBack
	 */
	void loadTextList(int i, CallBack callBack);
}
