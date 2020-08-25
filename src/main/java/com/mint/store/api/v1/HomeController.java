package com.mint.store.api.v1;

import com.mint.store.annotations.ScopeLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
@RestController
public class HomeController {
  @GetMapping("home")
  @ScopeLevel(5)
  public String home() {
    return "Hello Mint";
  }
}
