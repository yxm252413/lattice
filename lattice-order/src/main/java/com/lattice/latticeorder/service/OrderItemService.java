package com.lattice.latticeorder.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.entity.OrderItem;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 09:09
 **/
public interface OrderItemService {
    boolean delete(Integer[] ids);
    
    boolean insert(OrderItem orderItem);
    
    boolean update(OrderItem orderItem);
    
    OrderItem getOrderItemByOrderID(Integer orderID);
    
    LayUiResultDataList list(Integer page, Integer limit);
}
