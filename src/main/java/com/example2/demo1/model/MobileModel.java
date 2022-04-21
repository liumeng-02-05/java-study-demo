package com.example2.demo1.model;

import com.example2.demo1.enums.GoodsIsList;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MobileModel {

    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 子标题
     */
    private String subName;

    private Integer category;

    private String categoryName;

    private String cover;

    private Integer isList;

    private int sortNo;

    private BigDecimal price;

    public Boolean getIsHot() {
        return id != null && id % 2 == 0;
    }

    /**
     * 销量
     */
    private int sales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getIsList() {
        return isList;
    }

    public void setIsList(Integer isList) {
        this.isList = isList;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getIsListName() {
        return GoodsIsList.getValue(isList);
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
