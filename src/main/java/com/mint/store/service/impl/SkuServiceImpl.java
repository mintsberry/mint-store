package com.mint.store.service.impl;

import com.mint.store.model.Sku;
import com.mint.store.repository.SkuRepository;
import com.mint.store.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
@Service
public class SkuServiceImpl implements SkuService {
  @Autowired
  private SkuRepository skuRepository;
  @Override
  public List<Sku> getSkuListByIds(List<Long> ids) {
    return skuRepository.findAllByIdIn(ids);
  }
}
