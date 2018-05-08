package com.ccnu.xiahongyun.stmanagementsystem.query;

import java.io.Serializable;
import java.util.List;

public class QueryViewPage<T> implements Serializable {

    private int pageNo = 1;
    private int pageSize = 10;
    private int totalRecord;
    private int currentRecord;
    private int totalPage;
    private List<T> results;
    private int prevNo;
    private int nextNo;
    private boolean prev;
    private boolean next;
    private String lastRowKey;


    public QueryViewPage() {
    }

    public QueryViewPage(int pageNo, int pageSize, int totalPage, int totalRecord, List<T> results) {
        this.prev = pageNo - 1 > 0 && totalPage > 1;
        if (this.prev) {
            this.prevNo = pageNo - 1;
        }

        this.next = pageNo + 1 <= totalPage;
        if (this.next) {
            this.nextNo = pageNo + 1;
        }

        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setTotalPage(totalPage);
        this.setResults(results);
        this.setTotalRecord(totalRecord);
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        int totalPage = totalRecord % this.pageSize == 0 ? totalRecord / this.pageSize : totalRecord / this.pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(int currentRecord) {
        this.currentRecord = currentRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPrevNo() {
        return prevNo;
    }

    public void setPrevNo(int prevNo) {
        this.prevNo = prevNo;
    }

    public int getNextNo() {
        return nextNo;
    }

    public void setNextNo(int nextNo) {
        this.nextNo = nextNo;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public String getLastRowKey() {
        return lastRowKey;
    }

    public void setLastRowKey(String lastRowKey) {
        this.lastRowKey = lastRowKey;
    }
}
