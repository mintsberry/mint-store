package com.mint.store.service;

import com.mint.store.model.Activity;

/**
 * (Activity)表服务接口
 *
 * @author LingXi
 * @since 2020-11-24 19:22:56
 */
public interface ActivityService {
  Activity getByName(String name);
}