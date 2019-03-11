package com.lattice.latticeuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dto.UserDTO;
import com.lattice.latticeuser.entity.User;
import com.lattice.latticeuser.service.UserService;
import com.lattice.latticeuser.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:07
 **/
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @ApiOperation(value = "新增用户", notes = "通过User对象添加用户")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody User user) {
        if (CheckUtil.checkUser(user)) {
            boolean insert = userService.insert(user);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除用户", notes = "通过用户id删除用户可，支持批量删除")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "用户id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids != null && ids.length > 0) {
            boolean delete = userService.delete(ids);
            if (delete) {
                LayUiResultData.ok("删除成功");
            }
            return LayUiResultData.fail("删除失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "更新用户信息", notes = "通过用户对象信息的id更新用户信息")
    @ApiImplicitParam(paramType = "body", name = "user", value = "用户信息必须要有userID", required = true, dataType = "UserDTO")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody User user) {
        if (CheckUtil.checkUpdateUser(user)) {
            boolean update = userService.update(user);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "只查询用户信息", notes = "通过用户的openid查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "openid", value = "用户的wx的唯一标识", required = true, dataType = "String")
    @GetMapping("/wx/{openid}")
    public LayUiResultData getUserByOpenid(@PathVariable("openid") String openid) {
        if (CheckUtil.checkString(openid)) {
            return LayUiResultData.error();
        }
        User user = userService.getUserByOpenid(openid);
        if (user.getUserid() != null) {
            return LayUiResultData.ok(user);
        }
        return LayUiResultData.fail("未查找到数据");
    }
    
    @ApiOperation(value = "只查询用户信息", notes = "通过用户的userid查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "userid", value = "用户的wx的唯一标识", required = true, dataType = "Integer")
    @GetMapping("/{userid}")
    public LayUiResultData getUserByUserid(@PathVariable("userid") Integer userid) {
        if (CheckUtil.checkInteger(userid)) {
            return LayUiResultData.error();
        }
        User user = userService.getUserByUserid(userid);
        if (user.getUserid() != null) {
            return LayUiResultData.ok(user);
        }
        return LayUiResultData.fail("未查找到数据");
    }
    
    @ApiOperation(value = "获取用户列表", notes = "通过当前页（page）和每页数据条数(limit)获取")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页数应该大于等于1", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据的条数大于0", required = true, dataType = "int")})
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (page > 0 && limit > 0) {
            return userService.list(page, limit);
            
        }
        return LayUiResultDataList.error();
        
    }
    
    @ApiOperation(value = "查询用户信息所有信息", notes = "通过用户的openid查询用户信息所有")
    @ApiImplicitParam(paramType = "path", name = "openid", value = "用户的wx的唯一标识", required = true, dataType = "String")
    @GetMapping("/all/{openid}")
    public LayUiResultData getAll(@PathVariable("openid") String openid) {
        UserDTO all = userService.getAll(openid);
        if (all.getUserid() != null) {
            return LayUiResultData.ok(all);
        }
        return LayUiResultData.fail("未查询到数据");
    }
    
}
