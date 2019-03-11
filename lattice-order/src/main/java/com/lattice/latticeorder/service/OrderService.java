package com.lattice.latticeorder.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.dto.OrderDTO;
import com.lattice.latticeorder.entity.Order;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:26
 **/
public interface OrderService {
	LayUiResultDataList list(Integer page, Integer limit);

    boolean insert(Order order);

	boolean delete(Integer[] ids);

    boolean update(Order order);

	LayUiResultDataList getByUserId(Integer userID);

    Order get(Integer orderID);

    boolean updateSatus(byte b, Integer[] ids);

    OrderDTO getAll(Integer orderID);
}
