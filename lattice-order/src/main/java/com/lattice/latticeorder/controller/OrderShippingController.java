package com.lattice.latticeorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.entity.OrderShipping;
import com.lattice.latticeorder.service.OrderShippingSerivce;
import com.lattice.latticeorder.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 15:06
 **/
@RestController
@CrossOrigin
@RequestMapping("/ordershipping")
public class OrderShippingController {

	@Autowired
	private OrderShippingSerivce orderShippingSerivce;

	@ApiOperation(value = "添加订单地址信息",notes = "通过OrderShipping对象添加订单的地址信息")
	@ApiImplicitParam(paramType = "body",name = "orderShipping",value = "订单的地址信息的对象",required = true,dataType =
			"OrderShipping")
	@PostMapping("")
	public LayUiResultData insert(@RequestBody OrderShipping orderShipping){
		if(CheckUtil.checkOrderShipping(orderShipping)){
            boolean insert = orderShippingSerivce.insert(orderShipping);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
		}
		return LayUiResultData.error();
	}

	@ApiOperation(value = "删除订单地址信息",notes = "通过订单地址信息删除")
	@ApiImplicitParam(paramType = "path",name = "ids",value = "订单地址信息的集合",required = true,dataType = "int",
			allowMultiple = true)
	@DeleteMapping("/{ids}")
	public LayUiResultData delete(@PathVariable("ids")Integer... ids){
		if(ids == null || ids.length < 1){
			return LayUiResultData.error();
		}
        boolean delete = orderShippingSerivce.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
	}

	@ApiOperation(value = "修改订单地址信息",notes = "通过订单地址信息来修改")
	@ApiImplicitParam(paramType = "body",name = "orderShipping",value = "订单地址信息对象",required = true,dataType =
			"OrderShipping")
	@PutMapping("/")
	public LayUiResultData update(@RequestBody OrderShipping orderShipping){
        if (CheckUtil.checkUpdateOrderShipping(orderShipping)) {
            boolean update = orderShippingSerivce.update(orderShipping);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
		}
		return LayUiResultData.error();
	}
    
    @ApiOperation(value = "查询订单地址列表", notes = "通过当前页数（page）和每页数据条数（limit）获得该页的订单地址列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "page", value = "所需要查询数据的页数", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "path", name = "limit", value = "每页数据的条数", required = true, dataType = "int")})
    @GetMapping("/list/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        if (limit > 0 && page > 0) {
            return orderShippingSerivce.list(page, limit);
        }
        return LayUiResultDataList.error();
    }
}
