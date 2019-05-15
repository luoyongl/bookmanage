package com.wtu.jht.bookmanage.enums;

public enum ApplyBookEnum {

    waitReview(1, "待审核"),
    reviewSuccess(2, "审核通过，学生选取中"),
    student(3, "选取结束"),
    waitSubmit(4,"订单待提交"),
    waitorder(8,"待备货"),
    order(9,"备货完成"),
    waitRevice(5,"学生待领取"),
    waitFail(6,"审核不通过"),
    end(7,"以结束");


    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private ApplyBookEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

    public static ApplyBookEnum getEnumByCode(String code) {
        for (ApplyBookEnum broadcastTypeEnum : ApplyBookEnum.values()) {
            if (code != null && code.equals(String.valueOf(broadcastTypeEnum.getCode()))) {
                return broadcastTypeEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
		/*
		int code2 = emergency.getCode();
		System.out.println(code2);*/
    }
}
