package cn.wangjun.yys.utils;

/**
 * 分页工具类
 */
public class PageUtil {
	/**
	 * 当前页码
	 */
	private Integer currPage;
	/**
	 * 每页显示记录数
	 */
	private Integer pageCount;
	/**
	 * 总记录数
	 */
	private Integer totalCount;
	/**
	 * 总页数
	 */
	private Integer totalPages;
	
	/**
	 * 获得当前页码
	 */
	public Integer getCurrPage() {
		return currPage;
	}
	
	/**
	 * 设置当前页码
	 */
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 获得每页显示记录数
	 */
	public Integer getPageCount() {
		return pageCount;
	}
	
	/**
	 * 设置每页显示记录数
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * 获得总记录数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}
	
	/**
	 * 设置总记录数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 获得总页数
	 */
	public Integer getTotalPages() {
		return totalPages;
	}
	
	/**
	 * 设置总页数
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
