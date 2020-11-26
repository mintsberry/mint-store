package com.mint.store.service.impl;

import com.mint.store.dto.OrderDTO;
import com.mint.store.dto.SkuInfoDTO;
import com.mint.store.exception.http.NotFoundException;
import com.mint.store.exception.http.ParameterException;
import com.mint.store.logic.CouponChecker;
import com.mint.store.model.Coupon;
import com.mint.store.model.Sku;
import com.mint.store.model.UserCoupon;
import com.mint.store.repository.CouponRepository;
import com.mint.store.repository.UserCouponRepository;
import com.mint.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Order)表服务实现类
 *
 * @author LingXi
 * @since 2020-11-25 19:22:52
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
  @Autowired
  private SkuServiceImpl skuService;
  @Autowired
  private CouponRepository couponRepository;
  @Autowired
  private UserCouponRepository userCouponRepository;
  @Override
  public void isOK(Long uid, OrderDTO orderDTO) {
    if (orderDTO.getFinalTotalPrice().compareTo(new BigDecimal("0")) <= 0) {
      throw new ParameterException(50011);
    }
    List<Long> skuIdList = orderDTO.getSkuInfoDTOList()
            .stream().map(SkuInfoDTO::getId).collect(Collectors.toList());
    List<Sku> skuList = skuService.getSkuListByIds(skuIdList);
    CouponChecker couponChecker = null;
    Long couponId = orderDTO.getCouponId();
    if (couponId != null) {
      Coupon coupon = this.couponRepository.findById(couponId).orElseThrow(() -> new NotFoundException(40004));
      UserCoupon userCoupon = this.userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId).orElseThrow(() -> new NotFoundException(50006));
      couponChecker = new CouponChecker(coupon, userCoupon);
    }
  }
}