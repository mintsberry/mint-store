package com.mint.store.repository;

import com.mint.store.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public interface SkuRepository extends JpaRepository<Sku, Long> {
  List<Sku> findAllByIdIn(List<Long> idList);
}
