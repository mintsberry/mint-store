package com.mint.store.api.v1;

import com.mint.store.model.Activity;
import com.mint.store.service.ActivityService;
import com.mint.store.vo.ActivityCouponVo;
import com.mint.store.vo.ActivityPureVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Activity)表控制层
 *
 * @author LingXi
 * @since 2020-11-24 19:23:01
 */
@RestController
@RequestMapping("activity")
public class ActivityController  {
  /**
   * 服务对象
   */
  @Resource
  private ActivityService activityService;

  @GetMapping("/name/{name}")
  private ActivityPureVo getHomeActivity(@PathVariable String name) {
    Activity activity = activityService.getByName(name);
    return new ActivityPureVo(activity);
  }


  @GetMapping("/name/{name}/with_coupon")
  private ActivityCouponVo getHomeActivityWithCoupon(@PathVariable String name) {
    Activity activity = activityService.getByName(name);
    return new ActivityCouponVo(activity);
  }
}