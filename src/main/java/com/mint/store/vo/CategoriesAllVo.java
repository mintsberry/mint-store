package com.mint.store.vo;

import com.mint.store.model.Category;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
@Data
public class CategoriesAllVo {
  private List<CategoryPureVo> roots;
  private List<CategoryPureVo> subs;


  public CategoriesAllVo(Map<Integer, List<Category>> all) {
    List<Category> roots = all.get(0);
    List<Category> subs = all.get(1);
    this.roots = roots.stream().map(CategoryPureVo::new).collect(Collectors.toList());
    this.subs = subs.stream().map(CategoryPureVo::new).collect(Collectors.toList());
  }
}
