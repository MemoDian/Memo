package cn.Memo.memogank.Model;

public interface IModel {

	public interface CallBack{
		/**
		 * ³É¹¦
		 * @param success
		 */
		void onSuccess(Object success);
		
		/**
		 * Ê§°Ü
		 */
		void onError(Object error);
	}
}
