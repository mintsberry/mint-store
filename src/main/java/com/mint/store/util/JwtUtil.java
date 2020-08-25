package com.mint.store.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
@Component
public class JwtUtil {
  private static String secret;
  private static Long expired;
  private static final Integer defalutScope = 8;

  public static Optional<Map<String, Claim>> getClaims(String token) {
    Algorithm algorithm = Algorithm.HMAC256(JwtUtil.secret);
    JWTVerifier verifier = JWT.require(algorithm).build();
    try {
      Map<String, Claim> claims = verifier.verify(token).getClaims();
      return Optional.of(claims);
    } catch (JWTVerificationException e) {
      return Optional.empty();
    }
  }

  @Value("${jwt.secret}")
  public void setSecret(String secret) {
    JwtUtil.secret = secret;
  }
  @Value("${jwt.expired}")
  public void setExpired(Long expired) {
    JwtUtil.expired = expired;
  }

  public static String getToken(Long uid, Integer scope) {
    Algorithm algorithm = Algorithm.HMAC256(JwtUtil.secret);
    return JWT.create()
            .withClaim("uid", uid)
            .withClaim("scope", scope)
            .withExpiresAt(JwtUtil.calcTimeout())
            .sign(algorithm);
  }

  private static Date calcTimeout() {
    long l = System.currentTimeMillis() + JwtUtil.expired;
    return new Date(l);
  }

  public static String getToken(Long id) {
    return JwtUtil.getToken(id, JwtUtil.defalutScope);
  }
}
