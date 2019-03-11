package com.lattice.latticeorder.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeorder.entity.OrderShipping;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 15:07
 **/
public interface OrderShippingSerivce {
    boolean insert(OrderShipping orderShipping);

	boolean delete(Integer[] ids);

	boolean update(OrderShipping orderShipping);
    
    LayUiResultDataList list(Integer page, Integer limit);
}
