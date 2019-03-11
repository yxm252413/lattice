package com.lattice.latticeorder.exception;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2019-01-16 17:45
 * @UpdateUser: 张家豪
 * @UpdateDate: 2019-01-16 17:45
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
public class OrderUpdateException extends RuntimeException {
    public OrderUpdateException() {
        super("订单信息修正错误");
    }
}
