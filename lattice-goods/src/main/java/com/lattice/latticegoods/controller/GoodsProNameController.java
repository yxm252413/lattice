package com.lattice.latticegoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProName;
import com.lattice.latticegoods.service.GoodsProNameService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:15
 **/
@RestController
@CrossOrigin
@RequestMapping("/goodsproname")
public class GoodsProNameController {
    
    @Autowired
    private GoodsProNameService goodsProNameService;
    
    @ApiOperation(value = "添加商品配置名称", notes = "通过商品配置名称对象进行添加")
    @ApiImplicitParam(paramType = "body", name = "goodsProName", value = "商品配置名称对象", required = true, dataType = "GoodsProName")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsProName goodsProName) {
        if (CheckUtil.checkGoodsProName(goodsProName)) {
            boolean insert = goodsProNameService.insert(goodsProName);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除商品配置名称", notes = "通过商品配置名称id删除")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "商品配置名称id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = goodsProNameService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }
    
    @ApiOperation(value = "修改商品配置名称", notes = "通过商品配置对象修改商品配置信息")
    @ApiImplicitParam(paramType = "body", name = "goodsProName", value = "商品配置对象信息", required = true, dataType = "GoodsProName")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody GoodsProName goodsProName) {
        if (CheckUtil.checkUpdateGoodsProName(goodsProName)) {
            boolean update = goodsProNameService.update(goodsProName);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "查找商品配置名称信息", notes = "通过商品配置名称的id查询")
    @ApiImplicitParam(paramType = "path", name = "goodsProNameID", value = "商品配置名称的id", required = true, dataType = "int")
    @GetMapping("/{goodsProNameID}")
    public LayUiResultData get(@PathVariable("goodsProNameID") Integer goodsProNameID) {
        GoodsProName goodsProName = goodsProNameService.get(goodsProNameID);
        if (goodsProName.getPronameid() != null) {
            return LayUiResultData.ok(goodsProName);
        }
        return LayUiResultData.fail("未查询到数据");
    }
    
    @ApiOperation(value = "查询商品配置名称列表", notes = "通过当前页数（page）和每页数据的条数（limit）查询该页数据列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页数", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据的条数", required = true, dataType = "int")})
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (limit > 0 && page > 0) {
            return goodsProNameService.list(page, limit);
        }
        return LayUiResultDataList.error();
        
    }
}
