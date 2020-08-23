package com.mint.store.vo;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
public class PagingCopy<T, K> extends Paging{
  public PagingCopy(Page<T> page, Class<K> kClass) {
    super();
    this.initPageParameters(page);
    List<T> scrList = page.getContent();
    List<K> tarList = new ArrayList<>();

    scrList.forEach(source -> {
      try {
        K target = kClass.newInstance();
        BeanUtils.copyProperties(source , target);
        tarList.add((target));
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    this.setItems(tarList);
  }
}
