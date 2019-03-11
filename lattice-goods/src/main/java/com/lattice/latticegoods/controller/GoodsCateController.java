package com.lattice.latticegoods.controller;


import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsCate;
import com.lattice.latticegoods.service.GoodsCateService;
import com.lattice.latticegoods.utils.CheckUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: lattice
 * @description: 商品分类的相关操作
 * @author: 张家豪
 * @create: 2018-11-16 23:59
 **/
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/goodscate")
public class GoodsCateController {
    
    @Autowired
    private GoodsCateService goodsCateService;
    
    @ApiOperation(value = "添加商品分类", notes = "通过商品的对象添加商品分类")
    @ApiImplicitParam(paramType = "body", name = "goodsCate", value = "商品分类对象", required = true, dataType = "GoodsCate")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody GoodsCate goodsCate) {
        if (CheckUtil.checkGoodsCate(goodsCate)) {
            boolean insert = goodsCateService.insert(goodsCate);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除出商品分类", notes = "通过商品的分类id删除商品")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = goodsCateService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        else {
            return LayUiResultData.fail("删除失败");
        }
    }
    
    @ApiOperation(value = "修改商品分类信息", notes = "通过商品分类信息对象修改商品分类信息")
    @ApiImplicitParam(paramType = "body", name = "goodsCate", value = "商品分类信息对象", required = true, dataType = "GoodsCate")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody GoodsCate goodsCate) {
        if (CheckUtil.checkUpdateGoodsCate(goodsCate)) {
            boolean update = goodsCateService.update(goodsCate);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            else {
                return LayUiResultData.fail("修改失败");
            }
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "修改出商品分类状态为可用", notes = "通过商品的分类id修改商品分类的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/reshelf")
    public LayUiResultData updateStatusReshelf(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = goodsCateService.updateSatus((byte)1, ids);
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
        boolean updateSatus = goodsCateService.updateSatus((byte)0, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "查找商品分类信息", notes = "根据商品分类id")
    @ApiImplicitParam(paramType = "path", name = "goodsCateID", value = "商品分类的ID", required = true, dataType = "int")
    @GetMapping("/get/{goodsCateID}")
    public LayUiResultData get(@PathVariable("goodsCateID") Integer goodsCateID) {
        GoodsCate goodsCate = goodsCateService.get(goodsCateID);
        if (goodsCate != null && goodsCate.getCateid() != null) {
            return LayUiResultData.ok(goodsCate);
        }
        else {
            return LayUiResultData.fail("未查询到");
        }
    }
    
    @ApiOperation(value = "获取商品分类的列表", notes = "通过当前页数(page)和每页数据条数（limit）获取分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页数，大于0", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "query", name = "limit", value = "每页数据的条数应大于等于1", required = true, dataType = "int")})
    @GetMapping("/list")
    public LayUiResultDataList list(@RequestParam Integer page, @RequestParam Integer limit) {
        if (page > 0 && limit > 0) {
            return goodsCateService.list(page, limit);
        }
        else if (page <= 0 && limit <= 0) {
            List<GoodsCate> list = goodsCateService.list();
            if (list == null || list.size() < 1) {
                return LayUiResultDataList.fail("未查询到数据");
            }
            return LayUiResultDataList.ok(list);
        }
        return LayUiResultDataList.error();
        
    }
    
}
