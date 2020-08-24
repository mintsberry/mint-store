package com.mint.store.api.v1;

import com.mint.store.model.Theme;
import com.mint.store.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@RestController
@RequestMapping("/theme")
@Validated
public class ThemeController {
  @Autowired
  private ThemeService themeService;
  @GetMapping("/by/names")
  public List<Theme> getThemesGroup(@NotBlank String names) {
    List<String> nameList = Arrays.asList(names.split(","));
    return themeService.getThemesByNames(nameList);
  }
}
