package com.team4.lib.domain;

import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;

public class Book {

  private Long id;
  
  @NotBlank
  private String idCategory;
  
  @NotBlank
  private String title;
  
  @NotBlank
  private String contentShort;
  
  @NotBlank
  private Integer stock;
  
  private Integer outStock;
  
  @NotBlank
  private String author;
  
  @NotBlank
  private String year;
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

  public String getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(String idCategory) {
    this.idCategory = idCategory;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContentShort() {
    return contentShort;
  }

  public void setContentShort(String contentShort) {
    this.contentShort = contentShort;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getOutStock() {
    return outStock;
  }

  public void setOutStock(Integer outStock) {
    this.outStock = outStock;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
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
