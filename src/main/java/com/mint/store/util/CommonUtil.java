package com.mint.store.util;

import com.mint.store.bo.PageCounter;

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
}
