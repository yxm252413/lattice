package com.lattice.latticeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.dao.OrderMapper;
import com.lattice.latticeorder.dto.OrderDTO;
import com.lattice.latticeorder.entity.Order;
import com.lattice.latticeorder.entity.OrderExample;
import com.lattice.latticeorder.exception.OrderDeleteException;
import com.lattice.latticeorder.exception.OrderUpdateException;
import com.lattice.latticeorder.service.OrderService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:26
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    
    @Override
    // @Cacheable(value = "OrderServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectByExample(new OrderExample());
        if (orders == null || orders.size() == 0) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
        return LayUiResultDataList.ok(orders, pageInfo.getTotal());
    }
    
    @Override
    public boolean insert(Order order) {
        int i = orderMapper.insertSelective(order);
        return i > 0;
    }
    
    @Override
    @Transactional(rollbackFor = OrderDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            int i = orderMapper.deleteByPrimaryKey(id);
            if (i < 1) {
                flag = false;
                throw new OrderDeleteException();
            }
        }
        return flag;
    }
    
    @Override
    public boolean update(Order order) {
        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i > 0;
    }
    
    @Override
    public LayUiResultDataList getByUserId(Integer userID) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUseridEqualTo(userID);
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders == null) {
            LayUiResultDataList.fail("未查询到数据");
        }
        return LayUiResultDataList.ok(orders);
    }
    
    @Override
    public Order get(Integer orderID) {
        return orderMapper.selectByPrimaryKey(orderID);
    }
    
    @Override
    @Transactional(rollbackFor = OrderUpdateException.class, propagation = Propagation.REQUIRED)
    public boolean updateSatus(byte b, Integer[] ids) {
        for (Integer id : ids) {
            if (orderMapper.updateStatus(b, id) == 0) {
                throw new OrderUpdateException();
            }
        }
        return true;
    }
    
    @Override
    public OrderDTO getAll(Integer orderID) {
        return orderMapper.getAll(orderID);
    }
}
