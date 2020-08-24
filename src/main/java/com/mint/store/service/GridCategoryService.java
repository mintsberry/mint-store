package com.mint.store.service;

import com.mint.store.model.GridCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public interface GridCategoryService {
  /**
   * 获取六宫格数据
   * @return
   */
  List<GridCategory> getGirdCategoryAll();
}
