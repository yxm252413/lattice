package com.lattice.latticegoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProValue;
import com.lattice.latticegoods.service.GoodsProValueService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:17
 **/
@RestController
@CrossOrigin
@RequestMapping("goodsprovalue")

public class GoodsProValueController {
    @Autowired
    private GoodsProValueService goodsProValueService;

    @ApiOperation(value = "添加商品配置值",notes = "通过商品配置值的对象添加")
    @ApiImplicitParam(paramType = "body",name = "goodsProValue",value = "商品配置值的对象",required = true,dataType =
            "GoodsProValue")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsProValue goodsProValue){
        if(CheckUtil.checkGoodsProValue(goodsProValue)){
            boolean insert = goodsProValueService.insert(goodsProValue);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }

    @ApiOperation(value = "删除商品配置值",notes = "通过商品配置值的id删除")
    @ApiImplicitParam(paramType = "path",name = "ids",value = "商品配置值的id的集合",required = true,dataType = "int")
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids")Integer... ids){
        if(ids == null || ids.length < 1){
            return LayUiResultData.error();
        }
        boolean delete = goodsProValueService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }

    @ApiOperation(value = "修改商品配置值",notes = "通过商品配置值对象进行修改")
    @ApiImplicitParam(paramType = "body",name = "goodsProValue",value = "商品配置值的对象",required = true,dataType =
            "GoodsProValue")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody GoodsProValue goodsProValue){
        if(CheckUtil.checkUpdateGoodsProValue(goodsProValue)){
            boolean update = goodsProValueService.update(goodsProValue);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }

    @ApiOperation(value = "查询商品配置值",notes = "通过商品配置值的id进行查询")
    @ApiImplicitParam(paramType = "path",name = "id",value = "商品配置值的id",required = true,dataType = "int")
    @GetMapping("/")
    public LayUiResultData get(@PathVariable("id")Integer id){
        GoodsProValue goodsProValue = goodsProValueService.get(id);
        if (goodsProValue.getProvalueid() != null) {
            return LayUiResultData.ok(goodsProValue);
        }
        return LayUiResultData.fail("未查询到商品");
    }

    @ApiOperation(value = "查询商品配置值的列表",notes = "通过当前页（page）和每页数据的条数（limit）获取")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "page",value = "当前数据的页数",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "path",name = "limit",value = "每页数据的条数",required = true,dataType = "int")
    })
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page")Integer page , @PathVariable("limit")Integer limit){
        if (limit > 0 && page > 0) {
            return goodsProValueService.list(page, limit);
        }
        return LayUiResultDataList.error();
    }

}
