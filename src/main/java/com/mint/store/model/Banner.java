package com.mint.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@Entity
@Data
public class Banner extends BaseEntity {
  @Id
  private Long id;
  private String name;
  private String description;

  private String title;
  private String img;

  @OneToMany
  @JoinColumn(name = "banner_id")
  private List<BannerItem> items;
}
