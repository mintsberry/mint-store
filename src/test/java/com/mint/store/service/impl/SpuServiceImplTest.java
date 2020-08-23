package com.mint.store.service.impl;

import com.mint.store.MintStoreApplicationTests;
import com.mint.store.model.Spu;
import com.mint.store.repository.SpuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
class SpuServiceImplTest extends MintStoreApplicationTests {
  @Autowired
  private SpuRepository spuRepository;
  @Test
  void getByCategoryId() {
    PageRequest of = PageRequest.of(0, 10);
    Page<Spu> byCategoryIdOrderByCreateTimeDesc = spuRepository.findByCategoryIdOrderByCreateTimeDesc(28, of);
    System.out.println(byCategoryIdOrderByCreateTimeDesc.getContent());
  }
}