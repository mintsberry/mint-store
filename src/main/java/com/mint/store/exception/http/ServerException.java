package com.mint.store.exception.http;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
public class ServerException extends HttpException{
  public ServerException() {
    this.code = 0;
  }
}
