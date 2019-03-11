package com.lattice.latticeorder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lattice.latticeorder.dto.OrderDTO;
import com.lattice.latticeorder.entity.Order;
import com.lattice.latticeorder.entity.OrderExample;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    int updateStatus(@Param("status") byte b, @Param("orderid") Integer id);
    
    OrderDTO getAll(Integer orderID);
}