package com.lattice.latticegoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsImg;
import com.lattice.latticegoods.service.GoodsImgService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:13
 **/
@RestController
@CrossOrigin
@RequestMapping("goodsimg")
public class GoodsImgController {
    @Autowired
    private GoodsImgService goodsImgService;
    
    @ApiOperation(value = "添加商品图片", notes = "通过商品图片对象进行添加")
    @ApiImplicitParam(paramType = "body", name = "goodsImg", value = "商品图片对象", required = true, dataType = "GoodsImg", allowMultiple = true)
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsImg goodsImg) {
        if (CheckUtil.checkGoodsImg(goodsImg)) {
            boolean insert = goodsImgService.insert(goodsImg);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除商品图片", notes = "通过商品图片的id删除商品图片")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "商品图片的id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = goodsImgService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
        
    }
    
    @ApiOperation(value = "修改商品图片信息", notes = "通过商品图片信息对象进行修改")
    @ApiImplicitParam(paramType = "body", name = "goodsImg", value = "商品对象信息", required = true, dataType = "GoodsImg", allowMultiple = true)
    @PutMapping("/")
    public LayUiResultData update(@RequestBody GoodsImg goodsImg) {
        if (CheckUtil.checkUpdateGoodsImg(goodsImg)) {
            boolean update = goodsImgService.update(goodsImg);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "查询商品图片信息", notes = "通过商品图片id查询")
    @ApiImplicitParam(paramType = "path", name = "id", value = "商品图片id", required = true, dataType = "int")
    @GetMapping("/{id}")
    public LayUiResultData get(@PathVariable("id") Integer id) {
        GoodsImg goodsImg = goodsImgService.get(id);
        if (goodsImg.getImgid() != null) {
            return LayUiResultData.ok(goodsImg);
        }
        return LayUiResultData.fail("未查询到数据");
    }

    @ApiOperation(value = "获取商品图片信息列表", notes = "通过当前页数（page）和每页数据条数（limit）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页数", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据条数", required = true, dataType = "int")})
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (limit > 0 && page > 0) {
            return goodsImgService.list(page, limit);
        }
        return LayUiResultDataList.error();
        
    }
}
