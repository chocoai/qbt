package com.qbt.common.result;

import com.qbt.common.entity.PageEntity.OrderByType;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装. 注意所有序号从1开始.
 */
public class Paging {
	// -- 分页参数 --//
	private int	pageNo	= 1;// 当前页码
	private int	pageSize	= 10;// 每页记录数
	private long totalCount	= 0;// 总记录数
	private int	totalPages	= 0;// 总页数
	private boolean hasNext = false;//是否有下一页
	
	private int lastRecordId = 0;//最后一条记录的id
	
	private int lastRownum = 0;
	
	private String orderByColumn;
	private OrderByType orderByType = OrderByType.desc;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		long size = (long) pageSize;
		setTotalPages((int) (totalCount / size + (totalCount % size == 0 ? 0 : 1)));
		setHasNext(this.pageNo < this.totalPages);
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public int getLastRecordId() {
		return lastRecordId;
	}

	public void setLastRecordId(int lastRecordId) {
		this.lastRecordId = lastRecordId;
	}

	public int getLastRownum() {
		return lastRownum;
	}

	public void setLastRownum(int lastRownum) {
		this.lastRownum = lastRownum;
	}

	public String getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public OrderByType getOrderByType() {
		return orderByType;
	}

	public void setOrderByType(OrderByType orderByType) {
		this.orderByType = orderByType == null ? OrderByType.desc : orderByType;
	}

}
