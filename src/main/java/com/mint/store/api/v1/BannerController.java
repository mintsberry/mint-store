package com.mint.store.api.v1;

import com.mint.store.model.Banner;
import com.mint.store.service.BannerService;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author MintsBerry
 * @date 2020/8/21
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
  @Autowired
  private BannerService bannerService;

  @GetMapping("/name/{name}")
  public Banner getByName(@PathVariable String name) {
    Banner banner = bannerService.getByName(name);
    return banner;
  }
}
