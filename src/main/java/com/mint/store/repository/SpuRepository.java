package com.mint.store.repository;

import com.mint.store.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
  /**
   * 通过id查找商品spu
   *
   * @param id
   * @return
   */
  Spu findOneById(Long id);

  /**
   * 通过类别Id查询Spu按时间排序
   *
   * @param cid
   * @param pageable
   * @return
   */
  Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Integer cid, Pageable pageable);

  /**
   * 通过根类别Id查询Spu按时间排序
   *
   * @param cid
   * @param pageable
   * @return
   */
  Page<Spu> findByRootCategoryIdOrderByCreateTimeDesc(Integer cid, Pageable pageable);

}