package com.mint.store.exception.http;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
public class HttpException extends RuntimeException {
  protected int code;
  protected int codeStatus ;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getCodeStatus() {
    return codeStatus;
  }

  public void setCodeStatus(int codeStatus) {
    this.codeStatus = codeStatus;
  }

}
