package com.mint.store.service;

import com.mint.store.model.Sku;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public interface SkuService {
  List<Sku> getSkuListByIds(List<Long> ids);
}
