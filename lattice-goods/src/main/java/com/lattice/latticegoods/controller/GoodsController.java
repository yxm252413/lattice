package com.lattice.latticegoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dto.GoodsDto;
import com.lattice.latticegoods.entity.Goods;
import com.lattice.latticegoods.service.GoodsService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:11
 **/
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/goods")
public class GoodsController {
    
    @Autowired
    private GoodsService goodsService;
    
    @ApiOperation(value = "添加商品信息", notes = "通过商品对象来添加商品信息")
    @ApiImplicitParam(paramType = "body", name = "goods", value = "商品信息对象", required = true, dataType = "Goods")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody Goods goods) {
        if (CheckUtil.checkGoods(goods)) {
            boolean insert = goodsService.insert(goods);
            if (insert) {
                return LayUiResultData.ok("商品信息添加成功");
            }
            else {
                return LayUiResultData.fail("商品信息添加失败");
            }
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除商品信息", notes = "通过商品id删除商品信息")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "商品对象id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = goodsService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        else {
            return LayUiResultData.fail("删除失败");
        }
    }
    
    @ApiOperation(value = "修改出商品分类状态为可用", notes = "通过商品的分类id修改商品分类的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/reshelf")
    public LayUiResultData updateStatusReshelf(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = goodsService.updateSatus((byte)1, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "修改出商品分类状态为不可用", notes = "通过商品的分类id修改商品分类的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/instock")
    public LayUiResultData updateStatusInstock(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = goodsService.updateSatus((byte)0, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "获取商品的详细信息", notes = "通过商品id获取商品详细信息")
    @ApiImplicitParam(paramType = "path", name = "goodsID", value = "商品id", required = true, dataType = "int")
    @GetMapping("/all/{goodsID}")
    public LayUiResultData getAll(@PathVariable("goodsID") Integer goodsID) {
        GoodsDto goodsDto = goodsService.getAll(goodsID);
        if (goodsDto.getGoodsid() != null) {
            return LayUiResultData.ok(goodsDto);
        }
        return LayUiResultData.fail("查询不到");
    }
    
    @ApiOperation(value = "修改商品信息", notes = "通过商品信息来修")
    @ApiImplicitParam(paramType = "body", name = "goods", value = "商品信息", required = true, dataType = "Goods")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody Goods goods) {
        if (CheckUtil.checkUpdateGoods(goods)) {
            return LayUiResultData.ok(goodsService.update(goods) ? "修改成功" : "修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "获取商品信息", notes = "通过商品的id获取商品信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "商品的id", required = true, dataType = "int")
    @GetMapping("/get/{id}")
    public LayUiResultData get(@PathVariable("id") Integer id) {
        return LayUiResultData.ok(goodsService.get(id));
    }
    
    @ApiOperation(value = "获取商品信息列表", notes = "通过当前页（page）和每页数据条数（limit）获取该页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", name = "page", value = "当前页数", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "body", name = "limit", value = "当前页的数据条数", required = true, dataType = "int")})
    @GetMapping("/list")
    public LayUiResultDataList list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        if (page > 0 && limit > 0) {
            return goodsService.list(page, limit);
        }
        return LayUiResultDataList.error();
    }
    
}
