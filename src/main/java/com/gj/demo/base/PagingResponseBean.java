package com.gj.demo.base;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * Paging Result
 *
 */
public class PagingResponseBean<T> {

	/**
	 * 总记录数
	 */
	private long count;

	/**
	 * 一览
	 */
	private List<T> list;

	private boolean isFirstPage;
	private boolean isLastPage;
	private int totalPages;
	private int page;

	private int pageSize = 1;

	private int StartRow;

	private int EndRow;

	public static <T> PagingResponseBean<T> create(Page<T> page) {
		PagingResponseBean<T> response = new PagingResponseBean<>();

		response.count = page.getTotal();
		response.list = page.getResult();
		response.StartRow = page.getStartRow() + 1;
		response.EndRow = page.getEndRow();

		response.page = page.getPageNum();
		response.setFirstPage(response.getPage() <= 1);
		response.pageSize = page.getPageSize();

		if (0 != response.pageSize) {

			response.setTotalPages(Math.toIntExact(response.count / response.pageSize)
					+ ((response.count % response.pageSize) > 0 ? 1 : 0));
		} else {
			response.setTotalPages(0);
		}
		response.setLastPage(response.getPage() >= response.getTotalPages());

		return response;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean firstPage) {
		isFirstPage = firstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean lastPage) {
		isLastPage = lastPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return StartRow;
	}

	public void setStartRow(int startRow) {
		StartRow = startRow;
	}

	public int getEndRow() {
		return EndRow;
	}

	public void setEndRow(int endRow) {
		EndRow = endRow;
	}

}
