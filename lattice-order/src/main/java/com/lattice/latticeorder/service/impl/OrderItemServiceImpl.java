package com.lattice.latticeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.dao.OrderItemMapper;
import com.lattice.latticeorder.entity.OrderItem;
import com.lattice.latticeorder.entity.OrderItemExample;
import com.lattice.latticeorder.exception.OrderItemDeleteException;
import com.lattice.latticeorder.service.OrderItemService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 09:10
 **/
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
    public boolean insert(OrderItem orderItem) {
		int i = orderItemMapper.insertSelective(orderItem);
        return i > 0;
	}

	@Override
	@Transactional(rollbackFor = OrderItemDeleteException.class, propagation = Propagation.REQUIRED)
	public boolean delete(Integer[] ids) {
		boolean flag = true;
		for (Integer id : ids) {
			if (orderItemMapper.deleteByPrimaryKey(id) < 1) {
				flag = false;
				throw new OrderItemDeleteException();
			}
		}
		return flag;
	}

	@Override
    public boolean update(OrderItem orderItem) {
		int i = orderItemMapper.updateByPrimaryKeySelective(orderItem);
        return i > 0;
	}

	@Override
	public OrderItem getOrderItemByOrderID(Integer orderID) {
		OrderItemExample example = new OrderItemExample();
		example.createCriteria().andOrderidEqualTo(orderID);
		List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
		if(orderItems != null && orderItems.size() > 0){
			return orderItems.get(0);
		}
		return new OrderItem();

	}

	@Override
	public LayUiResultDataList list(Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		List<OrderItem> orderItems = orderItemMapper.selectByExample(new OrderItemExample());
		if(orderItems == null || orderItems.size() < 1){
			return LayUiResultDataList.error();
		}
		PageInfo pageInfo = new PageInfo<OrderItem>(orderItems);
		return LayUiResultDataList.ok(orderItems,pageInfo.getTotal());
	}
}
