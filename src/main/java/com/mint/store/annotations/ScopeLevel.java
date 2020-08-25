package com.mint.store.annotations;

import java.lang.annotation.*;

/**
 * @author MintsBerry
 * @date 2020/8/25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ScopeLevel {
  int value() default 0;
}
