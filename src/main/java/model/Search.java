package model;

import java.io.Serializable;

public class Search implements Serializable {
	private static final long serialVersionUID = 1L;
	private String searchKeyword;
	private String filterBy;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}
}
