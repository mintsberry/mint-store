package com.mint.store.repository;

import com.mint.store.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
public interface BannerRepository extends JpaRepository<Banner, Long> {
  /**
   *  通过Id查询
   * @param id
   * @return
   */
  Banner findOneById(Long id);

  /**
   *  通过Name查询
   * @param name
   * @return
   */
  Banner findOneByName(String name);
}
