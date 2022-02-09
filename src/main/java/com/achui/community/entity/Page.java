package com.achui.community.entity;

/**
 * @author achui
 * 分页类
 */
public class Page {

    private final static int MAX_LIMIT = 100;
    /**
     * 当前页码
     */
    private int current = 1;

    /**
     * 显示上限
     */
    private int limit = 10;

    /**
     * 数据总数 (用于计算总页数)
     */
    private int rows;

    /**
     * 查询路径
     */
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= MAX_LIMIT) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return pages count
     */
    public int getTotal() {
        return (int) Math.ceil((double)rows / limit);
    }

    /**
     * 获取起始页码
     */
    public int getFrom() {
        int from = current - 3;
        return Math.max(from, 1);
    }

    /**
     * 获取结束码
     */
    public int getTo() {
        int to = current + 3;
        int total = getTotal();
        return Math.min(to, total);
    }
}
