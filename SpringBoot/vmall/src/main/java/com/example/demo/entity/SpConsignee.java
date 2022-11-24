package com.example.demo.entity;


public class SpConsignee {

  private long cgnId;
  private long userId;
  private String cgnName;
  private String cgnAddress;
  private String cgnTel;
  private String cgnCode;
  private long deleteTime;


  public long getCgnId() {
    return cgnId;
  }

  public void setCgnId(long cgnId) {
    this.cgnId = cgnId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getCgnName() {
    return cgnName;
  }

  public void setCgnName(String cgnName) {
    this.cgnName = cgnName;
  }


  public String getCgnAddress() {
    return cgnAddress;
  }

  public void setCgnAddress(String cgnAddress) {
    this.cgnAddress = cgnAddress;
  }


  public String getCgnTel() {
    return cgnTel;
  }

  public void setCgnTel(String cgnTel) {
    this.cgnTel = cgnTel;
  }


  public String getCgnCode() {
    return cgnCode;
  }

  public void setCgnCode(String cgnCode) {
    this.cgnCode = cgnCode;
  }


  public long getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(long deleteTime) {
    this.deleteTime = deleteTime;
  }

}
