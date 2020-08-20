package com.mint.store.exception;

import com.mint.store.config.ApiCodesConfiguration;
import com.mint.store.exception.http.HttpException;
import com.mint.store.vo.UnifyResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MintsBerry
 * @date 2020/8/20
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionAdvice {
  @Autowired
  private ApiCodesConfiguration apiCodesConfiguration;

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public UnifyResponse handleUnexpected(HttpServletRequest request, Exception e) {
    log.error(e);
    int code = -1;
    String message = "服务器错误";
    String method = request.getMethod();
    String url = method + " " + request.getRequestURI();
    return new UnifyResponse(code, message, url);
  }

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException httpException) {
    UnifyResponse unifyResponse = new UnifyResponse();
    int code = httpException.getCode();
    unifyResponse.setCode(code);
    unifyResponse.setMessage(apiCodesConfiguration.getMessage(code));
    String method = request.getMethod();
    String url = method + " " + request.getRequestURI();
    unifyResponse.setUrl(url);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpStatus httpStatus = HttpStatus.resolve(httpException.getCodeStatus());
    return new ResponseEntity<UnifyResponse>(unifyResponse, httpHeaders, httpStatus);
  }
}
