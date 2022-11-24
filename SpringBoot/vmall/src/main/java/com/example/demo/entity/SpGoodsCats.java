package com.example.demo.entity;


public class SpGoodsCats {

  private long catId;
  private long parentId;
  private String catName;
  private long isShow;
  private long catSort;
  private long dataFlag;
  private long createTime;


  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }


  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }


  public long getCatSort() {
    return catSort;
  }

  public void setCatSort(long catSort) {
    this.catSort = catSort;
  }


  public long getDataFlag() {
    return dataFlag;
  }

  public void setDataFlag(long dataFlag) {
    this.dataFlag = dataFlag;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }

}
