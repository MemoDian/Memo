package cn.Memo.memogank.Entity;

import java.util.ArrayList;
import java.util.List;

public class Pic {

	private boolean error;
	private List<PicList> results = new ArrayList<PicList>();

	public Pic() {
		// TODO Auto-generated constructor stub
	}

	public Pic(boolean error, List<PicList> results) {
		super();
		this.error = error;
		this.results = results;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<PicList> getResults() {
		return results;
	}

	public void setResults(List<PicList> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Pic [error=" + error + ", results=" + results + "]";
	}

}
