package com.lattice.latticeorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.dto.OrderDTO;
import com.lattice.latticeorder.entity.Order;
import com.lattice.latticeorder.service.OrderService;
import com.lattice.latticeorder.utils.CheckUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:25
 **/
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @ApiOperation(value = "添加订单", notes = "通过订单对象添加订单")
    @ApiImplicitParam(paramType = "body", name = "order", value = "订单信息", required = true, dataType = "order")
    @PostMapping("/")
    public LayUiResultData insert(@RequestBody Order order) {
        if (CheckUtil.checkOrder(order)) {
            boolean insert = orderService.insert(order);
            if (insert) {
                return LayUiResultData.ok("添加成功");
            }
            return LayUiResultData.fail("添加失败");
        }
        return LayUiResultData.error();
    }
    
    @ApiOperation(value = "删除订单", notes = "通过订单的id删除订单")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "订单id的集合", required = true, dataType = "int", allowMultiple = true)
    @DeleteMapping("/{ids}")
    public LayUiResultData delete(@PathVariable("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean delete = orderService.delete(ids);
        if (delete) {
            return LayUiResultData.ok("删除成功");
        }
        return LayUiResultData.fail("删除失败");
    }
    
    @ApiOperation(value = "修改订单", notes = "通过订单的对象的id修改订单")
    @ApiImplicitParam(paramType = "body", name = "order", value = "需要修改订单的对象", required = true, dataType = "order")
    @PutMapping("/")
    public LayUiResultData update(@RequestBody Order order) {
        if (CheckUtil.checkUpdateOrder(order)) {
            boolean update = orderService.update(order);
            if (update) {
                return LayUiResultData.ok("修改成功");
            }
            return LayUiResultData.fail("修改失败");
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
        boolean updateSatus = orderService.updateSatus((byte)1, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "修改出订单分类状态为不可用", notes = "通过订单id修改商品分类的状态")
    @ApiImplicitParam(paramType = "query", name = "ids", value = "商品分类id的集合", required = true, dataType = "int", allowMultiple = true)
    @PutMapping("/updateStatus/instock")
    public LayUiResultData updateStatusInstock(@RequestParam("ids") Integer... ids) {
        if (ids == null || ids.length < 1) {
            return LayUiResultData.error();
        }
        boolean updateSatus = orderService.updateSatus((byte)0, ids);
        if (updateSatus) {
            return LayUiResultData.ok("修改成功");
        }
        else {
            return LayUiResultData.fail("修改失败");
        }
    }
    
    @ApiOperation(value = "查询订单", notes = "通过订单的orderID查询订单")
    @ApiImplicitParam(paramType = "path", name = "orderID", value = "orderID", required = true, dataType = "int")
    @GetMapping("/{orderID}")
    public LayUiResultData get(@PathVariable("orderID") Integer orderID) {
        Order order = orderService.get(orderID);
        if (order.getOrderid() == null) {
            return LayUiResultData.fail();
        }
        return LayUiResultData.ok(order);
    }
    
    @ApiOperation(value = "查询订单全部信息", notes = "通过订单的orderID查询订单全部信息")
    @ApiImplicitParam(paramType = "path", name = "orderID", value = "orderID", required = true, dataType = "int")
    @GetMapping("/all/{orderID}")
    public LayUiResultData getAll(@PathVariable("orderID") Integer orderID) {
        OrderDTO orderDTO = orderService.getAll(orderID);
        if (orderDTO.getOrder().getOrderid() == null) {
            return LayUiResultData.fail();
        }
        return LayUiResultData.ok(orderDTO);
    }
    @ApiOperation(value = "查询订单", notes = "通过订单的userID查询订单")
    @ApiImplicitParam(paramType = "path", name = "userID", value = "用户的id", required = true, dataType = "int")
    @GetMapping("/user/{userID}")
    public LayUiResultDataList getByUserID(@PathVariable("userID") Integer userID) {
        return orderService.getByUserId(userID);
    }
    
    @ApiOperation(value = "获取订单列表", notes = "通过当前页（page）和每页的数据条数（limit）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页数 ，大于等于1", required = true, dataType = "int"),
        @ApiImplicitParam(paramType = "query", name = "limit", value = "每页数据的条数，大于0", required = true, dataType = "int")})
    @GetMapping("/list")
    public LayUiResultDataList list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        if (page > 0 && limit > 0) {
            return orderService.list(page, limit);
        }
        return LayUiResultDataList.error();
        
    }
}
