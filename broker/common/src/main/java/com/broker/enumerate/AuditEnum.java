package com.broker.enumerate;

/**
 * @author: Administrator
 * @description: 客户审计枚举
 * @date: Create in 2018/3/29 0029 下午 8:53
 * @modified:
 */
public enum AuditEnum {
    STATUS_WAIT("待审核", 0),
    STATUS_UNDER_WAY("进行中",1),
    STATUS_COMPLETE("装修完成",2),
    STATUS_FAIL("洽谈失败",3);

    private String name;
    private int index;


    AuditEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for (AuditEnum audit : AuditEnum.values()){
            if(audit.getIndex() == index){
                return audit.getName();
            }
        }
        return null;
    }

    public static AuditEnum valueOf(int index){
        for (AuditEnum audit : AuditEnum.values()){
            if(audit.getIndex() == index){
                return audit;
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
