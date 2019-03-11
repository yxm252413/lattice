package com.lattice.latticeuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Permission;
import com.lattice.latticeuser.service.PermissionService;
import com.lattice.latticeuser.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 11:33
 **/
@RestController
@RequestMapping("/permission")
@CrossOrigin
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@ApiOperation(value = "添加权限信息",notes = "通过Permission对象添加权限信息")
	@ApiImplicitParam(paramType = "body",name = "permission",value = "添加权限的对象信息",required = true,dataType =
			"Permission")
	@PostMapping("/")
	public LayUiResultData insert(@RequestBody Permission permission) {
		if (CheckUtil.checkPermission(permission)) {
            boolean insert = permissionService.insert(permission);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
		}
		return LayUiResultData.error();
	}


	@ApiOperation(value = "删除权限信息",notes = "通过权限信息的id删除权限信息")
	@ApiImplicitParam(paramType = "path",name = "ids",value = "权限对应permissionID的集合",required = true,dataType = "int",
			allowMultiple = true)
	@DeleteMapping("/{ids}")
	public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
		if (ids != null && ids.length > 0) {
            boolean delete = permissionService.delete(ids);
            if (delete) {
                return LayUiResultData.ok("删除成功");
            }
            return LayUiResultData.fail("删除失败");
		}
		return LayUiResultData.error();
	}

	@ApiOperation(value = "修改权限信息",notes = "通过Permission对象修改权限信息")
	@ApiImplicitParam(paramType = "body",name = "permission",value = "要修改权限的对象信息，无须修改的则为null",required = true,
			dataType = "Permission")
	@PutMapping("/")
	public LayUiResultData update(@RequestBody Permission permission){
        
        if (CheckUtil.checkUpdatePermission(permission)) {
            boolean update = permissionService.update(permission);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
        }
        return LayUiResultData.error();
	}

	@ApiOperation(value = "获取权限信息",notes = "通过权限信息的ID获取权限信息")
	@ApiImplicitParam(paramType = "path",name = "id",value = "权限信息的id",required = true,dataType = "int")
	@GetMapping("/{id}")
	public LayUiResultData get(@PathVariable("id")Integer id){
		return LayUiResultData.ok(permissionService.get(id));
	}

	@ApiOperation(value = "获取权限列表",notes = "通过当前页（page）和每页数据条数（limit）获取分页信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path",name = "page",value = "当前页",required = true,dataType = "int"),
			@ApiImplicitParam(paramType = "path",name = "limit",value = "每页数据条数",required = true,dataType = "int")
	})
	@GetMapping("/{page}/{limit}")
	public LayUiResultDataList list(@PathVariable("page")Integer page,@PathVariable("limit")Integer limit){
		if(page > 0 && limit > 0 ){
			return permissionService.list(page,limit);
		}
		return LayUiResultDataList.error();
	}
}
