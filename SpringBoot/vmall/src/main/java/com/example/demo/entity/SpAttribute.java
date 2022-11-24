package com.example.demo.entity;


public class SpAttribute {

  private long attrId;
  private String attrName;
  private long catId;
  private String attrSel;
  private String attrWrite;
  private String attrVals;
  private long deleteTime;


  public long getAttrId() {
    return attrId;
  }

  public void setAttrId(long attrId) {
    this.attrId = attrId;
  }


  public String getAttrName() {
    return attrName;
  }

  public void setAttrName(String attrName) {
    this.attrName = attrName;
  }


  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }


  public String getAttrSel() {
    return attrSel;
  }

  public void setAttrSel(String attrSel) {
    this.attrSel = attrSel;
  }


  public String getAttrWrite() {
    return attrWrite;
  }

  public void setAttrWrite(String attrWrite) {
    this.attrWrite = attrWrite;
  }


  public String getAttrVals() {
    return attrVals;
  }

  public void setAttrVals(String attrVals) {
    this.attrVals = attrVals;
  }


  public long getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(long deleteTime) {
    this.deleteTime = deleteTime;
  }

}
