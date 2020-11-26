package com.mint.store.service;

import com.mint.store.dto.OrderDTO;

/**
 * (Order)表服务接口
 *
 * @author LingXi
 * @since 2020-11-25 19:22:50
 */
public interface OrderService {
  void isOK(Long uid, OrderDTO orderDTO);
}