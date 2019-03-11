package com.lattice.latticeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.dao.OrderShippingMapper;
import com.lattice.latticeorder.entity.OrderShipping;
import com.lattice.latticeorder.entity.OrderShippingExample;
import com.lattice.latticeorder.exception.OrderShippingDeleteException;
import com.lattice.latticeorder.service.OrderShippingSerivce;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 15:08
 **/
@Service
public class OrderShippingServiceImpl implements OrderShippingSerivce {

	@Autowired
	private OrderShippingMapper orderShippingMapper;

	@Override
    public boolean insert(OrderShipping orderShipping) {
		int i = orderShippingMapper.insertSelective(orderShipping);
        return i > 0;
	}

	@Override
	@Transactional(rollbackFor = OrderShippingDeleteException.class,propagation = Propagation.REQUIRED)
	public boolean delete(Integer[] ids) {
		boolean flag =true;
		for (Integer id : ids) {
			int i = orderShippingMapper.deleteByPrimaryKey(id);
			if(i < 1){
				flag = false;
				throw new OrderShippingDeleteException();
			}
		}
		return flag;
	}

	@Override
	public boolean update(OrderShipping orderShipping) {
		int i = orderShippingMapper.updateByPrimaryKey(orderShipping);
        return i > 0;
    }
    
    @Override
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OrderShipping> orderShippings = orderShippingMapper.selectByExample(new OrderShippingExample());
        if (orderShippings == null) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<OrderShipping> pageInfo = new PageInfo<OrderShipping>(orderShippings);
        return LayUiResultDataList.ok(orderShippings, pageInfo.getTotal());
    }
}
