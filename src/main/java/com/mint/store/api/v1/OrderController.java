package com.mint.store.api.v1;


import com.mint.store.annotations.ScopeLevel;
import com.mint.store.dto.OrderDTO;
import com.mint.store.service.OrderService;
import com.mint.store.util.LocalUser;
import com.mint.store.vo.OrderIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Order)表控制层
 *
 * @author LingXi
 * @since 2020-11-25 19:22:55
 */
@RestController
@RequestMapping("order")
public class OrderController {
  @Autowired
  private OrderService orderService;
  @PostMapping()
  @ScopeLevel()
  public OrderIdVo placeOrder(@RequestBody OrderDTO orderDTO) {
    Long uid = LocalUser.getUser().getId();
    return null;
  }
}