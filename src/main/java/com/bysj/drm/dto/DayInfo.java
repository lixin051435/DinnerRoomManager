package com.bysj.drm.dto;

/**
 * 每天信息
 */
public class DayInfo {
    // 总金额
    private Integer totalPrice;
    // 接待人数
    private Integer totalPersonNumber;
    // 订单数目
    private Integer totalOrderNumber;

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalPersonNumber() {
        return totalPersonNumber;
    }

    public void setTotalPersonNumber(Integer totalPersonNumber) {
        this.totalPersonNumber = totalPersonNumber;
    }

    public Integer getTotalOrderNumber() {
        return totalOrderNumber;
    }

    public void setTotalOrderNumber(Integer totalOrderNumber) {
        this.totalOrderNumber = totalOrderNumber;
    }
}
