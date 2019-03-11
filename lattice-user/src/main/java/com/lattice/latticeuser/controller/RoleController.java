package com.lattice.latticeuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Role;
import com.lattice.latticeuser.service.RoleService;
import com.lattice.latticeuser.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 14:31
 **/
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @ApiOperation(value = "添加角色", notes = "通过Role对象进行添加")
    @ApiImplicitParam(paramType = "body", name = "role", value = "需要添加的Rolee对象", required = true, dataType = "Role")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody Role role) {
        if (CheckUtil.checkRole(role)) {
            boolean insert = roleService.insert(role);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除角色", notes = "通过角色的id删除角色")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "角色的id的集合", required = true, dataType = "Integer", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = roleService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }
    
    @ApiOperation(value = "更新角色", notes = "通过角色对象Role更新角色")
    @ApiImplicitParam(paramType = "body", name = "role", value = "角色对象Role", required = true, dataType = "Role")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody Role role) {
        if (CheckUtil.checkUpdateRole(role)) {
            boolean update = roleService.update(role);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "查询角色", notes = "通过角色的id查询角色")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色的id", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public LayUiResultData get(@PathVariable("id") Integer id) {
        return LayUiResultData.ok(roleService.get(id));
    }
    
    @ApiOperation(value = "查询角色分页信息", notes = "通过当前页(page)和每页数据条数(limit)查询")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "当前页数", required = true, dataType = "Integer"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据的条数", required = true, dataType = "Integer")})
    @GetMapping("/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (limit > 0 && page > 0) {
            return roleService.list(page, limit);
        }
        return LayUiResultDataList.error();
    }
}
