package com.mint.store.service;

import com.mint.store.model.Category;

import java.util.List;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public interface CategoryService {
  /**
   * 获取全部分类
   * @return
   */
  public Map<Integer, List<Category>> getAll();
}
