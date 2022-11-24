package com.example.demo.entity;


public class SpCategory {

  private long catId;
  private String catName;
  private long catPid;
  private long catLevel;
  private long catDeleted;
  private String catIcon;
  private String catSrc;


  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }


  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }


  public long getCatPid() {
    return catPid;
  }

  public void setCatPid(long catPid) {
    this.catPid = catPid;
  }


  public long getCatLevel() {
    return catLevel;
  }

  public void setCatLevel(long catLevel) {
    this.catLevel = catLevel;
  }


  public long getCatDeleted() {
    return catDeleted;
  }

  public void setCatDeleted(long catDeleted) {
    this.catDeleted = catDeleted;
  }


  public String getCatIcon() {
    return catIcon;
  }

  public void setCatIcon(String catIcon) {
    this.catIcon = catIcon;
  }


  public String getCatSrc() {
    return catSrc;
  }

  public void setCatSrc(String catSrc) {
    this.catSrc = catSrc;
  }

}
