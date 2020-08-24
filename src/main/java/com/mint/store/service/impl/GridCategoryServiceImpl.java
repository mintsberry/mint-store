package com.mint.store.service.impl;

import com.mint.store.model.GridCategory;
import com.mint.store.repository.GridCategoryRepository;
import com.mint.store.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Service
public class GridCategoryServiceImpl implements GridCategoryService {
  @Autowired
  private GridCategoryRepository gridCategoryRepository;
  @Override
  public List<GridCategory> getGirdCategoryAll() {
    return gridCategoryRepository.findAll();
  }
}
