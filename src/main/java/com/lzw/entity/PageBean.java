package com.lzw.entity;
import java.util.List;
/**
 * @Classname PageBean
 * @Description TODO 该类是包含当前数据库中数据的总条数和插叙到的list集合说包装的javaBean类
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/20 12:13
 */
public class PageBean {
    private int totalCount;//数据中数据的总条数
    private List<Brand> rows;//分页查询的结果封装成的list集合

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Brand> getRows() {
        return rows;
    }

    public void setRows(List<Brand> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }
}
