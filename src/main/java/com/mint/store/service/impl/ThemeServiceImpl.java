package com.mint.store.service.impl;

import com.mint.store.model.Theme;
import com.mint.store.repository.ThemeRepository;
import com.mint.store.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Service
public class ThemeServiceImpl implements ThemeService {
  @Autowired
  private ThemeRepository themeRepository;
  @Override
  public List<Theme> getThemesByNames(List<String> names) {
    return themeRepository.findByNameIn(names);
  }
}
