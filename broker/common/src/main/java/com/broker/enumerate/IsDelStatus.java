package com.broker.enumerate;

/**
 * 数据删除状态
 * @author: Administrator
 * @description:
 * @date: 2018/4/19 0019 19:50
 * @modified:
 */
public enum IsDelStatus {

    IS_DEL_NO("未删除",0),
    IS_DEL_YES("已删除",1);

    private String name;
    private int index;
    IsDelStatus(String name, int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
