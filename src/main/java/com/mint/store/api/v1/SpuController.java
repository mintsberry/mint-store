package com.mint.store.api.v1;

import com.mint.store.exception.http.NotFoundException;
import com.mint.store.model.Spu;
import com.mint.store.service.SpuService;
import com.mint.store.vo.PagingCopy;
import com.mint.store.vo.SpuSimplifyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

/**
 * @author MintsBerry
 * @date 2020/8/22
 */
@RestController
@RequestMapping("/spu")
@Validated
@Api("spu接口")
public class SpuController {
  @Autowired
  private SpuService spuService;

  @GetMapping("/id/{id}/detail")
  @ApiOperation("通过id查询商品详情")
  public Spu getDetail(@PathVariable @Positive  Long id) {
    Spu spu = spuService.getSpuById(id);
    if (spu == null) {
      throw new NotFoundException(30003);
    }
    return spu;
  }

  @GetMapping("/latest")
  public PagingCopy<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize) {
    Page<Spu> latestPagingSpu = spuService.getLatestPagingSpu(pageNum, pageSize);
    return new PagingCopy<>(latestPagingSpu, SpuSimplifyVO.class);
  }

  @GetMapping("/by/category/{cid}")
  public PagingCopy<Spu, SpuSimplifyVO> getByCategoryId(@RequestParam(defaultValue = "0") Integer pageNum,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        @PathVariable Integer cid,
                                                        @RequestParam(defaultValue = "false", name = "is_root") Boolean isRoot) {
    Page<Spu> latestPagingSpu = spuService.getByCategoryId(cid, isRoot, pageNum, pageSize);
    return new PagingCopy<>(latestPagingSpu, SpuSimplifyVO.class);
  }
}
