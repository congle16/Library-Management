package com.team4.lib.domain;

import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;

public class Category {

  private Long id;
  private Long idParent;
  
  @NotBlank
  private String name;
  private String createUser;
  private String updateUser;
  private Timestamp createTime;
  private Timestamp updateTime;
  private int status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIdParent() {
    return idParent;
  }

  public void setIdParent(Long idParent) {
    this.idParent = idParent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
