package com.mint.store.exception.http;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
public class ParameterException extends HttpException{
  public ParameterException(int code) {
    this.code = code;
    this.codeStatus = 404;
  }
}
