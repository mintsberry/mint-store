package com.mint.store.service;

import com.mint.store.model.Spu;
import org.springframework.data.domain.Page;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
public interface SpuService {
  /**
   * 通过id查询
   * @param id
   * @return
   */
  Spu getSpuById(Long id);

  /**
   * 以分页查询的方式获取一组最新的spu数据
   * @param pageNum
   * @param pageSize
   * @return
   */
  Page<Spu> getLatestPagingSpu(Integer pageNum, Integer pageSize);

  /**
   * 通过分类id分页查询spu数据
   * @param cid
   * @param isRoot
   * @param pageNum
   * @param pageSize
   * @return
   */
  Page<Spu> getByCategoryId(Integer cid, Boolean isRoot, Integer pageNum, Integer pageSize);
}
