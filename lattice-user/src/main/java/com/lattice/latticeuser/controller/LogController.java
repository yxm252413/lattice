package com.lattice.latticeuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Log;
import com.lattice.latticeuser.service.LogService;
import com.lattice.latticeuser.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: 用户日志相关操作 主要用于记录用户的ip 其他功能未实现
 * @author: 张家豪
 * @create: 2018-11-18 10:12
 **/
@RestController
@RequestMapping("/log")
@CrossOrigin
public class LogController {
    
    @Autowired
    private LogService logService;
    
    @ApiOperation(value = "添加用户log信息", notes = "通过Log对象添加用户的log信息")
    @ApiImplicitParam(paramType = "body", name = "log", value = "Log对象", required = true, dataType = "Log")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody Log log) {
        if (CheckUtil.checkLog(log)) {
            boolean insert = logService.insert(log);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
            
        }
        return LayUiResultData.error();
        
    }
    
    @ApiOperation(value = "删除用户的log信息", notes = "通过log的id删除用户的log信息")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "用户日志信息的id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = logService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }
    
    @ApiOperation(value = "更新log", notes = "通过id更新log")
    @ApiImplicitParam(paramType = "body", name = "log", value = "log对象如果不需要更新则为null", required = true, dataType = "Log", allowMultiple = true)
    @PutMapping("/")
    public LayUiResultData update(@RequestBody Log log) {
        if (CheckUtil.checkUpdateLog(log)) {
            boolean update = logService.update(log);
            if (update) {
                return LayUiResultData.ok("更新成功");
            }
            return LayUiResultData.fail("更新失败");
            
        }
        return LayUiResultData.error();
        
    }
    
    @ApiOperation(value = "获取log", notes = "通过logID获取log信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要获取log的id", required = true, dataType = "int")
    @GetMapping("/{id}")
    public LayUiResultData get(@PathVariable("id") Integer id) {
        Log select = logService.select(id);
        if (select.getLogid() != null) {
            return LayUiResultData.ok(select);
        }
        return LayUiResultData.fail("未查找到数据");
    }
    
    @ApiOperation(value = "获取log列表", notes = "通过当前页（page）和每页数据的条数（limit）来获取分页信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页数", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据的条数", required = true, dataType = "int")})
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (limit > 0 && page > 0) {
            return logService.selectList(page, limit);
        }
        return LayUiResultDataList.error();
    }
    
}
