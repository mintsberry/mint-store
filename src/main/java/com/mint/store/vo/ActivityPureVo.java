package com.mint.store.vo;

import com.mint.store.model.Activity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author MintsBerry
 * @date 2020/11/24
 */
@Data
@NoArgsConstructor
public class ActivityPureVo {
  private long id;
  private String title;
  private String description;
  private Date startTime;
  private Date endTime;
  private String remark;
  private long online;
  private String entranceImg;

  public ActivityPureVo(Activity activity) {
    BeanUtils.copyProperties(activity, this);
  }

}
