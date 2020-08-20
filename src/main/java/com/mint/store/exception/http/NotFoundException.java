package com.mint.store.exception.http;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
public class NotFoundException extends HttpException{
  public NotFoundException(int code) {
    this.code = code;
    this.codeStatus = 404;
  }
}
