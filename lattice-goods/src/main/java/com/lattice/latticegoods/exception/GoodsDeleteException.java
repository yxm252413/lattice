package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:24
 **/
public class GoodsDeleteException extends RuntimeException {
    public GoodsDeleteException() {
        super("商品删除失败");
    }
}
