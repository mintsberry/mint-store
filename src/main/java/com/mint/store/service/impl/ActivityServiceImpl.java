package com.mint.store.service.impl;

import com.mint.store.exception.http.NotFoundException;
import com.mint.store.model.Activity;
import com.mint.store.repository.ActivityRepository;
import com.mint.store.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Activity)表服务实现类
 *
 * @author LingXi
 * @since 2020-11-24 19:22:59
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
  @Autowired
  private ActivityRepository activityRepository;

  @Override
  public Activity getByName(String name) {
    Activity activity = activityRepository.findByName(name);
    if (activity == null) {
      throw new NotFoundException(40001);
    }
    return activity;
  }
}