package com.lattice.latticeorder.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 08:53
 **/
public class OrderDeleteException extends RuntimeException {
	public OrderDeleteException() {
		super("订单删除失败");
	}
}
