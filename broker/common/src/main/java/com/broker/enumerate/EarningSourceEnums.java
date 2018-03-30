package com.broker.enumerate;

/**
 * @author: Administrator
 * @description: 经济人收益来源种类
 * @date: 2018/3/30 0030 16:49
 * @modified:
 */
public enum EarningSourceEnums {
    CUSTOMER("登记客户",0),
    FRIEND("邀请好友",1),
    BRIBE("红包",2);

    private String name;
    private int index;

    EarningSourceEnums(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for (EarningSourceEnums source : EarningSourceEnums.values()){
            if(source.getIndex() == index){
                return source.getName();
            }
        }
        return null;
    }

    public static EarningSourceEnums valueOf(int index){
        for (EarningSourceEnums source : EarningSourceEnums.values()){
            if(source.getIndex() == index){
                return source;
            }
        }
        return null;
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
