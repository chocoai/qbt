package com.qbt.common.base;

import java.util.ArrayList;
import java.util.List;


/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 
 * 注意所有序号从1开始.
 * 
 * @param <T> Page中记录的类型.
 * 
 * @author calvin
 */
public class Page<T> {
	//-- 公共变量 --//
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	//-- 分页参数 --//
	protected int pageNo = 1;
	protected int pageSize = 10;
	protected boolean autoCount = true;

	//-- 返回结果 --//
	protected List<T> result = new ArrayList<T>();
	protected long totalCount = 0;
	protected int totalPages = 0;
	protected int searchFlag=0;
	
	public Page(){}
	
	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	//-- 分页参数访问函数 --//
	/**
	 * 获得当前页的页号,序号从1开始,默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
	 */
	public void setPageNo( int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}
	public void setPageNo( String pageNo) {
		this.pageNo = Integer.valueOf(pageNo);

		if ( Integer.valueOf(pageNo) < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * 返回Page对象自身的setPageNo函数,可用于连续设置。
	 */
	public Page<T> pageNo( int thePageNo) {
		setPageNo(thePageNo);
		return this;
	}

	/**
	 * 获得每页的记录数量, 默认为-1.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量.
	 */
	public void setPageSize( int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 返回Page对象自身的setPageSize函数,可用于连续设置。
	 */
	public Page<T> pageSize( int thePageSize) {
		setPageSize(thePageSize);
		return this;
	}

	/**
	 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
	 */
	public int getFirst() {
		return ((pageNo - 1) * pageSize) + 1;
	}

	

	
	/**
	 * 获得查询对象时是否先自动执行count查询获取总记录数, 默认为false.
	 */
	public boolean isAutoCount() {
		return autoCount;
	}

	/**
	 * 设置查询对象时是否自动先执行count查询获取总记录数.
	 */
	public void setAutoCount( boolean autoCount) {
		this.autoCount = autoCount;
	}

	/**
	 * 返回Page对象自身的setAutoCount函数,可用于连续设置。
	 */
	public Page<T> autoCount( boolean theAutoCount) {
		setAutoCount(theAutoCount);
		return this;
	}

	//-- 访问查询结果函数 --//

	/**
	 * 获得页内的记录列表.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * 设置页内的记录列表.
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 获得总记录数, 默认值为-1.
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置总记录数.
	 */
	public void setTotalCount( long totalCount) {
		this.totalCount = totalCount;
		init();
	}

	/**
	 * 根据pageSize与totalCount计算总页数, 默认值为-1.
	 */
	public int getTotalPages() {
		if (totalCount < 0) {
			return -1;
		}
		int count = (int)totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 取得下页的页号, 序号从1开始.
	 * 当前页为尾页时仍返回尾页序号.
	 */
	public int getNextPage() {
		if (isHasNext()) {
			return pageNo + 1;
		} else {
			return pageNo;
		}
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页号, 序号从1开始.
	 * 当前页为首页时返回首页序号.
	 */
	public int getPrePage() {
		if (isHasPre()) {
			return pageNo - 1;
		} else {
			return pageNo;
		}
	}

	public int getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(int searchFlag) {
		this.searchFlag = searchFlag;
	}
	
	
	private final int SHOWPAGE = 6;// 页面中显示的总页数 baidu,google显示的总页数是20  
	private int startpage;// 页面中的起始页  
	private int endpage;// 页面中的结束页 
	
	private int[] pages = new int[SHOWPAGE];
	    
	/** 根据当前页及总记录数来构造分页对象 */  
    public void init() {
    	
        long countrecord = this.totalCount;  
        int countPage = this.getTotalPages();
  
        /** 计算startpage与endpage的值 */  
        
        /** 总页数数是否小于4 */  
        if ( countPage < (this.SHOWPAGE / 2 + 1)) {  
            this.startpage = 1; // 页面中起始页就是1  
            this.endpage = countPage;// 页面中的最终页就是总页数  
        } else {  
            /** else中是总页数大于4的情况 */  
  
            /** 首先当前页的值是否小于等于4 */  
            if (this.pageNo <= (this.SHOWPAGE / 2 + 1)) {  
                this.startpage = 1;  
                this.endpage = (this.SHOWPAGE / 2 + 1) + 2;  
                /** 判断页面的最终页是否大于总页数 */  
                if (this.endpage >= countPage) {  
                    this.endpage = countPage;  
                }  
            } else {  
                this.startpage = this.pageNo - 3;  
                this.endpage = this.pageNo + 2;  
  
                if (this.endpage >= countPage) {  
                    this.endpage = countPage;  
                    if (countPage < this.SHOWPAGE) {  
                        this.startpage = 1;  
                    } else {  
                        this.startpage = this.endpage - 5;  
                    }  
  
                }  
            }  
  
        }
        
        for(int s=startpage,i=0; s<= endpage;s++,i++){
        	pages[i]=s;
        }
  
    }

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getSHOWPAGE() {
		return SHOWPAGE;
	}

	public int[] getPages() {
		return pages;
	}

	public void setPages(int[] pages) {
		this.pages = pages;
	}  


}
