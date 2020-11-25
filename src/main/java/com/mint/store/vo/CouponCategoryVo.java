package com.mint.store.vo;

import com.mint.store.model.Category;
import com.mint.store.model.Coupon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MintsBerry
 * @date 2020/11/25
 */
public class CouponCategoryVo extends CouponPureVo {
  private List<CategoryPureVo> categoryPureVoList = new ArrayList<>();

  public CouponCategoryVo(Coupon coupon) {
    super(coupon);
    List<Category> categoryList = coupon.getCategoryList();
    this.categoryPureVoList = categoryList.stream().map(CategoryPureVo::new).collect(Collectors.toList());
  }
}
