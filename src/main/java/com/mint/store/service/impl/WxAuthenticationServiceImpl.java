package com.mint.store.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mint.store.model.User;
import com.mint.store.repository.UserRepository;
import com.mint.store.service.WxAuthenticationService;
import com.mint.store.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {
  @Autowired
  private ObjectMapper mapper;
  @Autowired
  private UserRepository userRepository;
  @Value("${wx.appid}")
  private String appid;
  @Value("${wx.secret}")
  private String secret;
  @Value("${wx.code2session}")
  private String code2session;
  @Override
  public String code2Session(String codes) {
    String url = MessageFormat.format(this.code2session, this.appid, this.secret, codes);
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(url, String.class);
    try {
      Map<String, Object> map = mapper.readValue(result, HashMap.class);
      String openid = (String) map.get("openid");
      if (openid == null) {
        return "";
      }
      return this.generateToken(openid);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "";
  }
  private String generateToken(String openid) {
    User user = this.userRepository.findByOpenid(openid);
    if (user == null) {
      user = new User();
      user.setOpenid(openid);
      user = this.userRepository.save(user);
    }
    return JwtUtil.getToken(user.getId());
  }
}
