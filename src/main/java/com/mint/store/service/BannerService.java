package com.mint.store.service;

import com.mint.store.model.Banner;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
public interface BannerService {
  /**
   * 通过name查询
   * @param name
   * @return
   */
  Banner getByName(String name);
}
