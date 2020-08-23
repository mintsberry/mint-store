package com.mint.store.vo;

import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@Data
@NoArgsConstructor
public class Paging<T> {
  private Long total;
  private Integer count;
  private Integer page;
  private Integer totalPage;
  private List items;

  public Paging(Page<T> page) {
      this.initPageParameters(page);
      this.items = page.getContent();
  }

  public void initPageParameters(Page<T> page) {
    this.total = page.getTotalElements();
    this.totalPage = page.getTotalPages();
    this.page = page.getNumber();
    this.count = page.getSize();
  }
}
