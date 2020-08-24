package com.mint.store.repository;

import com.mint.store.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {
  /**
   * in查询
   * @param name
   * @return
   */
  List<Theme> findByNameIn(List<String> name);
}
