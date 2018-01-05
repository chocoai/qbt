package com.qbt.common.result;

public class PageResult<T> extends Result<T> {
	
	private Paging page;

	public Paging getPage() {
		return page;
	}

	public void setPage(Paging page) {
		this.page = page;
	}

}
