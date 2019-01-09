package com.Mybatis.Query;
//高级查询封装条件
import java.math.BigDecimal;

public class EmployeeQueryObject {

	private String keyworld;   //关键字查询
	private BigDecimal minprice;
	private BigDecimal maxprice;
	private static int CurrentPage = 1; //当前页
	private static int PageSize = 5; //显示条数
	
	public void setKeyworld(String keyworld) {
		this.keyworld = keyworld;
	}
	public BigDecimal getMinprice() {
		return minprice;
	}
	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}
	public BigDecimal getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
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
	public String getKeyworld() {
		return empty(keyworld);
	}

	//传递给Mapper中使用
	public static Object getStart() {
		return (CurrentPage -1)*PageSize;
	}
	
	
	//如果字符串为空设置给keyworld
	private String empty(String str){
		return haslength(str)? str : null;
	}
	
	//判断字符串
	private boolean haslength(String str) {
		return str != null && !"".equals(str.trim()); 
	}
}
