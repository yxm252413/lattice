package com.lattice.latticeorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.entity.OrderItem;
import com.lattice.latticeorder.service.OrderItemService;
import com.lattice.latticeorder.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 09:09
 **/
@RestController
@CrossOrigin
@RequestMapping("orderitem")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@ApiOperation(value = "添加订单的详情",notes = "通过订单详情对象添加")
	@ApiImplicitParam(paramType = "body",name = "orderItem",value = "订单详情的对象",required = true,dataType = "OrderItem")
	@PostMapping("/")
    public LayUiResultData insert(@RequestBody OrderItem orderItem) {
		if(CheckUtil.checkOrderItem(orderItem)){
            boolean insert = orderItemService.insert(orderItem);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
		}
		return LayUiResultData.error();
	}

	@ApiOperation(value = "删除订单",notes = "通过订单的id删除订单")
	@ApiImplicitParam(paramType = "path",name = "ids",value = "删除订单id的集合",required = true,dataType = "int",
			allowMultiple = true)
	@DeleteMapping("/{ids}")
	public LayUiResultData delete(@PathVariable("ids")Integer... ids){
		if(ids == null || ids.length < 1){
			return LayUiResultData.error();
		}
        boolean delete = orderItemService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
	}

	@ApiOperation(value = "修改订单详情",notes = "通过订单详情对象修改订单详情")
	@ApiImplicitParam(paramType = "body",name = "orderItem",value = "订单详情的对象",required = true,dataType = "OrderItem")
	@PutMapping("/")
	public LayUiResultData update(@RequestBody OrderItem orderItem){
        if (CheckUtil.checkUpdateOrderItem(orderItem)) {
            boolean update = orderItemService.update(orderItem);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
		}
		return LayUiResultData.error();
	}

	@ApiOperation(value = "查询订单详情",notes = "通过订单的id查询订单详情")
	@ApiImplicitParam(paramType = "path",name = "orderID",value = "订单的ID",required = true,dataType = "int")
	@GetMapping("/{orderID}")
	public LayUiResultData getOrderItemByOrderID(@PathVariable("orderID")Integer orderID){
        OrderItem orderItemByOrderID = orderItemService.getOrderItemByOrderID(orderID);
        if (CheckUtil.checkInteger(orderItemByOrderID.getOrderitemid())) {
            return LayUiResultData.ok(orderItemByOrderID);
        }
        return LayUiResultData.fail("未查询到数据");
	}

	@ApiOperation(value = "查询订单的详情列表",notes = "通过当前页数（page）和每页数据条数（limit）获得该页的订单列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path",name = "page",value = "所需要查询数据的页数",required = true,dataType = "int"),
			@ApiImplicitParam(paramType = "path",name = "limit",value = "每页数据的条数",required = true,dataType = "int")
	})
	@GetMapping("/list/{page}/{limit}")
    public LayUiResultDataList list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
		if(limit > 0 && page > 0){
			return orderItemService.list(page,limit);
		}
		return LayUiResultDataList.error();
	}

}
