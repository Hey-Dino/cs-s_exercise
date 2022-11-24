package com.example.demo.entity;


public class SpOrder {

  private long orderId;
  private long userId;
  private String orderNumber;
  private double orderPrice;
  private String orderPay;
  private String isSend;
  private String tradeNo;
  private String orderFapiaoTitle;
  private String orderFapiaoCompany;
  private String orderFapiaoContent;
  private String consigneeAddr;
  private String payStatus;
  private long createTime;
  private long updateTime;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }


  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getOrderPay() {
    return orderPay;
  }

  public void setOrderPay(String orderPay) {
    this.orderPay = orderPay;
  }


  public String getIsSend() {
    return isSend;
  }

  public void setIsSend(String isSend) {
    this.isSend = isSend;
  }


  public String getTradeNo() {
    return tradeNo;
  }

  public void setTradeNo(String tradeNo) {
    this.tradeNo = tradeNo;
  }


  public String getOrderFapiaoTitle() {
    return orderFapiaoTitle;
  }

  public void setOrderFapiaoTitle(String orderFapiaoTitle) {
    this.orderFapiaoTitle = orderFapiaoTitle;
  }


  public String getOrderFapiaoCompany() {
    return orderFapiaoCompany;
  }

  public void setOrderFapiaoCompany(String orderFapiaoCompany) {
    this.orderFapiaoCompany = orderFapiaoCompany;
  }


  public String getOrderFapiaoContent() {
    return orderFapiaoContent;
  }

  public void setOrderFapiaoContent(String orderFapiaoContent) {
    this.orderFapiaoContent = orderFapiaoContent;
  }


  public String getConsigneeAddr() {
    return consigneeAddr;
  }

  public void setConsigneeAddr(String consigneeAddr) {
    this.consigneeAddr = consigneeAddr;
  }


  public String getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(String payStatus) {
    this.payStatus = payStatus;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }


  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }

}
