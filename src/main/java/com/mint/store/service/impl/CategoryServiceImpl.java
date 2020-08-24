package com.mint.store.service.impl;

import com.mint.store.model.Category;
import com.mint.store.repository.CategoryRepository;
import com.mint.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;
  @Override
  public Map<Integer, List<Category>> getAll() {
    List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
    List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
    Map<Integer, List<Category>> map = new HashMap<>();
    map.put(0, roots);
    map.put(1, subs);
    return map;
  }
}
