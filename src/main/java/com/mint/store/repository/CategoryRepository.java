package com.mint.store.repository;

import com.mint.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
  /**
   * 通过是否为根分类排序查询所有类
   * @param isRoot
   * @return
   */
  List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
