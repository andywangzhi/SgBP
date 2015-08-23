package com.gzepro.internal.query.common.util;

import java.util.ArrayList;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class Paging {

	private int currentIndex = 1;
	private long totalRecords = 0;
	private int totalPages = 0;
	private int prevIndex = 0;
	private int nextIndex = 0;
	private int firstIndex = 0;
	private int lastIndex = 0;
	private int pageSize = 10;
	private int startRow = 0;
	private int endRow = 0;
	
	private ArrayList voList;

	public Paging() {

	}

	public Paging(int currentIndex, int pageSize) {
		if (currentIndex > 0)
			this.currentIndex = currentIndex;
		if (pageSize > 0)
			this.pageSize = pageSize;
	}

	public ArrayList getVoList() {
		return voList;
	}

	public void setVoList(ArrayList voList) {
		this.voList = voList;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		if (currentIndex > 0)
			this.currentIndex = currentIndex;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		if (totalRecords > 0) {
			this.totalRecords = totalRecords;
			calTotalPages();
			init();
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPrevIndex() {
		return prevIndex;
	}

	public void setPrevIndex(int prevIndex) {
		this.prevIndex = prevIndex;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0)
			this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	private void calTotalPages() {
		int _totalPages = (int) (totalRecords % pageSize);

		this.totalPages = (int) (totalRecords / pageSize);
		;
		if (_totalPages > 0)
			this.totalPages++;

		if (currentIndex > totalPages)
			currentIndex = totalPages;
	}

	private void init() {
		nextIndex = currentIndex + 1;
		prevIndex = currentIndex - 1;
		if (currentIndex == 1)
			prevIndex = currentIndex;
		if (nextIndex > totalPages)
			nextIndex = totalPages;

		startRow = (currentIndex - 1) * pageSize;
		firstIndex = 1;
		lastIndex = totalPages;
	}

	public String getPagePart() {
		return null;
	}

	public String getTablePart() {
		return null;
	}

	public String toJson() {
		return null;
	}

}
