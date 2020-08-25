package com.mint.store.api.v1;

import com.mint.store.dto.LoginDTO;
import com.mint.store.exception.http.NotFoundException;
import com.mint.store.service.WxAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@RestController
@RequestMapping("/token")
public class TokenController {
  @Autowired
  private WxAuthenticationService wxAuthenticationService;
  @PostMapping("/login")
  public Map<String, String> Login(@RequestBody @Validated LoginDTO account) {
    switch (account.getType()) {
      case WX:
        wxAuthenticationService.code2Session(account.getAccount());
        break;
      case WEB:
        break;
      default:
        throw new NotFoundException(10003);
    }
    return null;
  }
}
