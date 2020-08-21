package com.mint.store.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
@Entity
@Table(name = "banner")
public class Banner {
  @Id
  private long id;

  private String name;

  private String description;
  private String img;
  private String title;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "bannerId")
  private List<BannerItem> items;
}
