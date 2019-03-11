package com.lattice.latticegoods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsSku;
import com.lattice.latticegoods.service.GoodsSkuService;
import com.lattice.latticegoods.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:21
 **/
@RestController
@CrossOrigin
@RequestMapping("/goodssku")
public class GoodsSkuController {
    @Autowired
    private GoodsSkuService goodsSkuService;
    
    @ApiOperation(value = "添加商品sku信息", notes = "通过商品Sku对象添加")
    @ApiImplicitParam(paramType = "body", name = "goodsSku", value = "商品Sku对象", required = true, dataType = "GoodsSku")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsSku goodsSku) {
        if (CheckUtil.checkGoodsSku(goodsSku)) {
            boolean insert = goodsSkuService.insert(goodsSku);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除商品SKu", notes = "通过商品Sku的id删除")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "商品Sku的id", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = goodsSkuService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }
    
    @ApiOperation(value = "修改商品Sku", notes = "通过商品Sku的对象")
    @ApiImplicitParam(paramType = "body", name = "goodsSku", value = "修改商品Sku对象", required = true, dataType = "GoodsSku")
    @PutMapping("/{goodsSkuID")
    public LayUiResultData update(@RequestBody GoodsSku goodsSku) {
        if (CheckUtil.checkUpdateGoodsSku(goodsSku)) {
            boolean update = goodsSkuService.update(goodsSku);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "修改出商品Sku状态为可用", notes = "通过商品的分类id修改商品Sku的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/reshelf")
    public LayUiResultData updateStatusReshelf(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = goodsSkuService.updateSatus((byte)1, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "修改出商品Sku状态为不可用", notes = "通过商品的分类id修改商品Sku的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/instock")
    public LayUiResultData updateStatusInstock(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = goodsSkuService.updateSatus((byte)0, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    @ApiOperation(value = "查找商品Sku", notes = "通过商品Sku的ID查找")
    @ApiImplicitParam(paramType = "path", name = "goodsSkuID", value = "商品Sku的ID", required = true, dataType = "int")
    @GetMapping("/{goodsSkuID}")
    public LayUiResultData get(@PathVariable("goodsSkuID") Integer goodsSkuID) {
        GoodsSku goodsSku = goodsSkuService.get(goodsSkuID);
        if (goodsSku.getSkuid() != null) {
            return LayUiResultData.ok(goodsSku);
        }
        return LayUiResultData.fail("未查找到数据");
    }
    
    @ApiOperation(value = "通过商品的id获得商品Sku列表", notes = "通过商品的id获得商品Sku列表")
    @ApiImplicitParam(paramType = "path", name = "goodid", value = "商品id", required = true, dataType = "int")
    @GetMapping("/list/{goodid}")
    public LayUiResultDataList listByGoodsID(@PathVariable("goodid") Integer goodid) {
        List<GoodsSku> list = goodsSkuService.listByGoodsID(goodid);
        if (list == null || list.size() == 0) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        return LayUiResultDataList.ok(list);
        
    }
    
}
