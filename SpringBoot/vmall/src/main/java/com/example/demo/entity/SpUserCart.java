package com.example.demo.entity;


public class SpUserCart {

  private long cartId;
  private long userId;
  private String cartInfo;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deleteTime;


  public long getCartId() {
    return cartId;
  }

  public void setCartId(long cartId) {
    this.cartId = cartId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getCartInfo() {
    return cartInfo;
  }

  public void setCartInfo(String cartInfo) {
    this.cartInfo = cartInfo;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public java.sql.Timestamp getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(java.sql.Timestamp deleteTime) {
    this.deleteTime = deleteTime;
  }

}
