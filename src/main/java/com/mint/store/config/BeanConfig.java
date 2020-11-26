package com.mint.store.config;

import com.mint.store.util.money.HalfUpRound;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MintsBerry
 * @date 2020/11/26
 */
@Configuration
public class BeanConfig {
  @Bean
  public HalfUpRound halfUpRound() {
    return new HalfUpRound();
  }
}
