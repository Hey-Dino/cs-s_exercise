package com.example.demo.entity;


public class SpPermissionApi {

  private long id;
  private long psId;
  private String psApiService;
  private String psApiAction;
  private String psApiPath;
  private long psApiOrder;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPsId() {
    return psId;
  }

  public void setPsId(long psId) {
    this.psId = psId;
  }


  public String getPsApiService() {
    return psApiService;
  }

  public void setPsApiService(String psApiService) {
    this.psApiService = psApiService;
  }


  public String getPsApiAction() {
    return psApiAction;
  }

  public void setPsApiAction(String psApiAction) {
    this.psApiAction = psApiAction;
  }


  public String getPsApiPath() {
    return psApiPath;
  }

  public void setPsApiPath(String psApiPath) {
    this.psApiPath = psApiPath;
  }


  public long getPsApiOrder() {
    return psApiOrder;
  }

  public void setPsApiOrder(long psApiOrder) {
    this.psApiOrder = psApiOrder;
  }

}
