package com.mint.store.service;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public interface WxAuthenticationService {

  String code2Session(String codes);
}
