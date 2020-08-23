package com.mint.store.service.impl;

import com.mint.store.model.Spu;
import com.mint.store.repository.SpuRepository;
import com.mint.store.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@Service
public class SpuServiceImpl implements SpuService {
  @Autowired
  private SpuRepository spuRepository;
  @Override
  public Spu getSpuById(Long id) {
    return spuRepository.findOneById(id);
  }

  @Override
  public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer pageSize) {
    PageRequest page = PageRequest.of(pageNum, pageSize, Sort.by("createTime").descending());
    return spuRepository.findAll(page);
  }

  @Override
  public Page<Spu> getByCategoryId(Integer cid, Boolean isRoot, Integer pageNum, Integer pageSize) {
    PageRequest page = PageRequest.of(pageNum, pageSize);
    if (isRoot) {
      return spuRepository.findByRootCategoryIdOrderByCreateTimeDesc(cid, page);
    } else {
      return spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid, page);
    }
  }
}
