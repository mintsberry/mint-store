package com.mint.store.util;

import com.mint.store.bo.PageCounter;

import java.util.Date;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
public class CommonUtil {
  public static PageCounter convertToPageParameter(Integer start, Integer count) {
    int pageNum = start / count;
    PageCounter pageCounter = new PageCounter();
    pageCounter.setPageNum(pageNum);
    pageCounter.setPageSize(count);
    return pageCounter;
  }

  public static Boolean isInTimeLine(Date date, Date start, Date end) {
    Long nowTime = date.getTime();
    Long startTime = start.getTime();
    Long endTime = end.getTime();
    if (nowTime > startTime && nowTime < endTime) {
      return true;
    }
    return false;
  }
}
