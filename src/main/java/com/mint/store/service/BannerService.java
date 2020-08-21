package com.mint.store.service;

import com.mint.store.model.Banner;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
public interface BannerService {
  Banner getByName(String name);
}
