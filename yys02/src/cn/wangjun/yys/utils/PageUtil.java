package cn.wangjun.yys.utils;

/**
 * ��ҳ������
 */
public class PageUtil {
	/**
	 * ��ǰҳ��
	 */
	private Integer currPage;
	/**
	 * ÿҳ��ʾ��¼��
	 */
	private Integer pageCount;
	/**
	 * �ܼ�¼��
	 */
	private Integer totalCount;
	/**
	 * ��ҳ��
	 */
	private Integer totalPages;
	
	/**
	 * ��õ�ǰҳ��
	 */
	public Integer getCurrPage() {
		return currPage;
	}
	
	/**
	 * ���õ�ǰҳ��
	 */
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ���ÿҳ��ʾ��¼��
	 */
	public Integer getPageCount() {
		return pageCount;
	}
	
	/**
	 * ����ÿҳ��ʾ��¼��
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * ����ܼ�¼��
	 */
	public Integer getTotalCount() {
		return totalCount;
	}
	
	/**
	 * �����ܼ�¼��
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * �����ҳ��
	 */
	public Integer getTotalPages() {
		return totalPages;
	}
	
	/**
	 * ������ҳ��
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
