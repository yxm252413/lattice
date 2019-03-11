package com.lattice.latticegoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProperties;
import com.lattice.latticegoods.service.GoodsPropertiesService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:19
 **/
@RestController
@CrossOrigin
@RequestMapping("goodsproperties")
public class GoodsPropertiesController {
    @Autowired
    private GoodsPropertiesService goodsPropertiesService;

    @ApiOperation(value = "添加商品配置信息",notes = "通过商品配置信息对象进行添加")
    @ApiImplicitParam(paramType = "body",name = "goodsProperties",value = "商品配置对象信息",required = true,dataType =
            "GoodsProperties")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsProperties goodsProperties){
        if(CheckUtil.checkGoodsPropereties(goodsProperties)){
            boolean insert = goodsPropertiesService.insert(goodsProperties);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.ok("添加失败");
        }
        return LayUiResultData.error();
    }

    @ApiOperation(value = "删除商品配置信息",notes = "通过商品配置信息的id删除")
    @ApiImplicitParam(paramType = "path",name = "ids",value = "商品配置信息的id的集合",required = true,dataType = "int",
            allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids")Integer... ids){
        if(ids == null || ids.length < 1){
            return  LayUiResultData.error();
        }
        boolean delete = goodsPropertiesService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }

    @ApiOperation(value = "修改商品配置信息",notes = "通过商品配置对象进行修改")
    @ApiImplicitParam(paramType = "body",name = "goodsProperties",value = "商品配置信息对象",required = true,dataType =
            "GoodsProperties")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody GoodsProperties goodsProperties){
        if(CheckUtil.chekUpdateGoodsProperties(goodsProperties)){
            boolean update = goodsPropertiesService.update(goodsProperties);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
       return LayUiResultData.error();
    }

    @ApiOperation(value = "查找商品配置信息",notes = "通过商品配置信息的id进行查找")
    @ApiImplicitParam(paramType = "path",name = "goodsPropertiesID",value = "商品配置信息对象的id",required = true,dataType =
            "int")
    @GetMapping("/{goodsPropertiesID}")
    public LayUiResultData get(@PathVariable("goodsPropertiesID")Integer goodsPropertiesID){
        GoodsProperties goodsProperties = goodsPropertiesService.get(goodsPropertiesID);
        if (goodsProperties.getProid() != null) {
            return LayUiResultData.ok(goodsProperties);
        }
        return LayUiResultData.fail("未查询到数据");
    }

    @ApiOperation(value = "获取商品配置信息的分页数据",notes = "通过当前页（page）和每页数据的条数（limit）来进行获取")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "page",value = "当前页数",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "limit",name = "limit",value = "每页数据的条数",required = true,dataType = "int")
    })
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page")Integer page, @PathVariable("limit")Integer limit){
        if (page > 0 && limit > 0) {
            return goodsPropertiesService.list(page, limit);
        }
        return LayUiResultDataList.error();
        
    }
}
