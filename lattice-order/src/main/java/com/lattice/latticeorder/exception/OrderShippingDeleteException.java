package com.lattice.latticeorder.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 17:46
 **/
public class OrderShippingDeleteException extends RuntimeException {
	public OrderShippingDeleteException() {
		super("订单地址信息删除异常");
	}
}
