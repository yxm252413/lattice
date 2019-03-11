package com.lattice.latticeorder.dto;

import com.lattice.latticeorder.entity.Order;
import com.lattice.latticeorder.entity.OrderItem;
import com.lattice.latticeorder.entity.OrderShipping;

import lombok.Data;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2019-01-19 18:56
 * @UpdateUser: 张家豪
 * @UpdateDate: 2019-01-19 18:56
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
@Data
public class OrderDTO {
    private Order order;
    
    private String username;
    
    private OrderShipping orderShipping;
    
    private OrderItem orderItem;
    
}
