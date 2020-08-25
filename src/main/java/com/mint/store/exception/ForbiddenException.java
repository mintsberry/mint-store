package com.mint.store.exception;

import com.mint.store.exception.http.HttpException;
import org.springframework.http.HttpStatus;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
public class ForbiddenException extends HttpException {
  public ForbiddenException(int code) {
    this.code = code;
    this.codeStatus = HttpStatus.FORBIDDEN.value();
  }
}
