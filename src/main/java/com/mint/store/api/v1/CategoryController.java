package com.mint.store.api.v1;

import com.mint.store.model.Category;
import com.mint.store.model.GridCategory;
import com.mint.store.service.CategoryService;
import com.mint.store.service.GridCategoryService;
import com.mint.store.vo.CategoriesAllVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private GridCategoryService gridCategoryService;
  @GetMapping("/all")
  public CategoriesAllVo getAll() {
    Map<Integer, List<Category>> all = categoryService.getAll();
    return new CategoriesAllVo(all);
  }
  @ApiOperation("获取六宫格数据")
  @GetMapping("/grid/all")
  public List<GridCategory> getGridAll() {
    List<GridCategory> girdCategoryAll = gridCategoryService.getGirdCategoryAll();
    return girdCategoryAll;
  }
}
