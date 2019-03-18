package com.xmgl.blog.util;


public final class PageCalculator {
    /**
     * 返回记录的开始即rowIndex
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculateRowIndex(int pageIndex, int pageSize){
        pageSize = pageSize <= 0 ? 10 : pageSize;
        return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
    }

    public static int checkPage(int pageIndex) {
        return pageIndex <= 0 ? 1 : pageIndex;
    }

    public static int checkLimit(int pageSize) {
        return pageSize <= 0 ? 10 : pageSize;
    }

    public static int calculateRowIndex(int pageIndex, int pageSize, int count) {
        pageSize = pageSize <= 0 ? 10 : pageSize;
        if(((pageIndex-1)*pageSize + pageSize)<count) {
            return (pageIndex - 1) * pageSize;
        }
        return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
    }
}
