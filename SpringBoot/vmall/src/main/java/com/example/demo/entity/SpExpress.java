package com.example.demo.entity;


public class SpExpress {

  private long expressId;
  private long orderId;
  private String expressCom;
  private String expressNu;
  private long createTime;
  private long updateTime;


  public long getExpressId() {
    return expressId;
  }

  public void setExpressId(long expressId) {
    this.expressId = expressId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getExpressCom() {
    return expressCom;
  }

  public void setExpressCom(String expressCom) {
    this.expressCom = expressCom;
  }


  public String getExpressNu() {
    return expressNu;
  }

  public void setExpressNu(String expressNu) {
    this.expressNu = expressNu;
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
