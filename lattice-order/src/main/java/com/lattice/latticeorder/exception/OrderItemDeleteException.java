package com.lattice.latticeorder.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 14:06
 **/
public class OrderItemDeleteException extends RuntimeException {
	public OrderItemDeleteException() {
		super("订单详情删除失败");
	}
}
