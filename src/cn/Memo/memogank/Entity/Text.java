package cn.Memo.memogank.Entity;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private boolean error;
	private List<Results> results = new ArrayList<Results>();

	public Text() {
		// TODO Auto-generated constructor stub
	}

	public Text(boolean error, List<Results> results) {
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

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Text [error=" + error + ", results=" + results + "]";
	}

}
