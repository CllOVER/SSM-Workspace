package com.Mybatis.Service;

import java.util.List;
@SuppressWarnings("all")
public class PageResult {

	private static List<?> result ;
	private int totalCount;  //总计
	private static int CurrentPage = 1; //当前页
	private static int PageSize = 5; //显示条数
	
	private int PrevPage; //上页
	private int NextPage; //下页
	private int totalPage; //尾页
	
	
	//设置参数
	public PageResult(List<?> result, int totalCount, int currentPage, int pageSize) {
		super();
		this.result = result;
		this.totalCount = totalCount;
		CurrentPage = currentPage;
		PageSize = pageSize;
		
		this.totalPage = totalCount % PageSize ==0 ? totalPage / PageSize : totalPage / PageSize + 1;
		this.NextPage = CurrentPage +1 < totalPage ?  CurrentPage + 1:totalPage ;
		this.PrevPage = CurrentPage -1 >=1 ? CurrentPage -1 : 1 ;
		CurrentPage = CurrentPage > totalPage ? totalPage : CurrentPage;
	}
	
	

	public static List<?> getResult() {
		return result;
	}
	public void setResult(List<?> result) {
		this.result = result;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return CurrentPage;
	}
	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getPrevPage() {
		return PrevPage;
	}

	public void setPrevPage(int prevPage) {
		PrevPage = prevPage;
	}

	public int getNextPage() {
		return NextPage;
	}

	public void setNextPage(int nextPage) {
		NextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
