package com.charlesedu.course.boot.util;

import java.util.List;

public class PaginationUtil<T> {
    private Integer length;
    private Integer page;
    private Long pagesTotal;
    private String sort;
    private List<T> records;

    public PaginationUtil(Integer length, Integer page, Long pagesTotal, String sort, List<T> records) {
        this.length = length;
        this.page = page;
        this.pagesTotal = pagesTotal;
        this.sort = sort;
        this.records = records;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getPage() {
        return page;
    }

    public Long getPagesTotal() {
        return pagesTotal;
    }

    public String getSort() {
        return sort;
    }

    public List<T> getRecords() {
        return records;
    }
}
