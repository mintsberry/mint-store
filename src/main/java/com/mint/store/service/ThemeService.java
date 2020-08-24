package com.mint.store.service;

import com.mint.store.model.Theme;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public interface ThemeService {
  /**
   * 通过一组专题名获取一组专题
   * @param names
   * @return
   */
  List<Theme> getThemesByNames(List<String> names);
}
