package com.example.demo.entity;


public class SpOrderGoods {

  private long id;
  private long orderId;
  private long goodsId;
  private double goodsPrice;
  private long goodsNumber;
  private double goodsTotalPrice;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }


  public long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }


  public double getGoodsTotalPrice() {
    return goodsTotalPrice;
  }

  public void setGoodsTotalPrice(double goodsTotalPrice) {
    this.goodsTotalPrice = goodsTotalPrice;
  }

}
