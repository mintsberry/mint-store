package com.mint.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {
  @JsonIgnore
  private Date createTime;
  @JsonIgnore
  private Date updateTime;
  @JsonIgnore
  private Date deleteTime;
}
