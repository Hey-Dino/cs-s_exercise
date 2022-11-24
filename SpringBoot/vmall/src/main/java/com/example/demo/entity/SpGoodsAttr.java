package com.example.demo.entity;


public class SpGoodsAttr {

  private long id;
  private long goodsId;
  private long attrId;
  private String attrValue;
  private double addPrice;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getAttrId() {
    return attrId;
  }

  public void setAttrId(long attrId) {
    this.attrId = attrId;
  }


  public String getAttrValue() {
    return attrValue;
  }

  public void setAttrValue(String attrValue) {
    this.attrValue = attrValue;
  }


  public double getAddPrice() {
    return addPrice;
  }

  public void setAddPrice(double addPrice) {
    this.addPrice = addPrice;
  }

}
