package com.qbt.common.entity.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *  分页
 * @author Administrator
 *
 * @param <T>
 */
public class SearchPage<T> implements Serializable {
	
	private static final long serialVersionUID = -1357196555818179804L;

	public static final int MAX_PAGE_SIZE = 5000;// 每页最大记录数限制

	/**
	 * 分页第几页
	 */
	private int pageNumber = 1;
	
	/**
	 * 分页每页数据条数
	 */
	private int pageSize = 20;
	
	/**
	 * 总数据条数
	 */
	private int totalCount = 0;
	
	/**
	 * 总分页条数
	 */
	private int pageCount = 0;
	
	/**
	 * 返回当前页数数据集合
	 */
	private List<T> dataRes = new ArrayList<T>();
	
	/** 
	 * 上次查询页码
	 */
	private Integer lastPageNumber = 0;
	
	/**
	 * 是否有下一页
	 */
	private boolean hasNext;
	
	/**
	 * 排序组合
	 */
	private List<Sort> sortList;
	
	/**
	 * 是否包含查询的分值
	 */
    private boolean isIncludeScore;
    
    /** 
     * 分组 
     */
    private Group group;

    /**
     * facet
     */
    private Facet facet;
    

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if(pageNumber < 1){
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		} else if (pageSize > MAX_PAGE_SIZE) {
			pageSize = MAX_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = totalCount % this.pageSize == 0 ? totalCount / this.pageSize : totalCount / this.pageSize + 1;
		setHasNext(this.pageNumber < this.pageCount);
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getDataRes() {
		return dataRes;
	}

	public void setDataRes(List<T> dataRes) {
		this.dataRes = dataRes;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public Integer getLastPageNumber() {
		return lastPageNumber;
	}

	public void setLastPageNumber(Integer lastPageNumber) {
		this.lastPageNumber = lastPageNumber;
	}

	public List<Sort> getSortList() {
		return sortList;
	}

	public void setSortList(List<Sort> sortList) {
		this.sortList = sortList;
	}

	public boolean isIncludeScore() {
		return isIncludeScore;
	}

	public void setIncludeScore(boolean isIncludeScore) {
		this.isIncludeScore = isIncludeScore;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Facet getFacet() {
		return facet;
	}

	public void setFacet(Facet facet) {
		this.facet = facet;
	}

}
