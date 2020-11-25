package com.mint.store.vo;

import com.mint.store.model.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Data
public class CategoryPureVo {
  private Long id;

  private String name;

  private String description;

  private Boolean isRoot;

  private Integer parentId;

  private String img;

  private Integer index;

  private Integer online;

  private Integer level;

  public CategoryPureVo(Category category) {
    BeanUtils.copyProperties(category, this);
  }
}
