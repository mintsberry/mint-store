package com.mint.store.service.impl;

import com.mint.store.model.Banner;
import com.mint.store.repository.BannerRepository;
import com.mint.store.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
@Service
public class BannerServiceImpl implements BannerService {
  @Autowired
  private BannerRepository bannerRepository;
  @Override
  public Banner getByName(String name) {
    return bannerRepository.findOneByName(name);
  }
}
