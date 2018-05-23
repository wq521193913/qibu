package com.broker.enumerate;

/**
 * @author: Administrator
 * @description: 收益表status状态
 * @date: 2018/5/23 0023 10:30
 * @modified:
 */
public enum BrokerEarningStatus {
    STATUS_DUE("待收",0),
    STATUS_GAIN("已发放",1),
    STATUS_LOSE("已失效",2),
    ;

    private String name;
    private int index;
    BrokerEarningStatus(String name, int index){
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
