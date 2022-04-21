package com.example2.demo1.enums;

public enum GoodsIsList {
    /// 上架
    ON_SHELVES(1, "已上架"),

    /// 未上架
    NOT_ON_SHELVES(2, "未上架");

    private int key;

    private String value;

    GoodsIsList() {
    }

    GoodsIsList(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(Integer key) {
        if (key == null) {
            return null;
        }
        GoodsIsList[] enums = values();
        for (GoodsIsList enu : enums) {
            if (enu.getKey() == key) {
                return enu.getValue();
            }
        }
        return null;
    }
}
