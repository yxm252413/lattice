package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-12-24 15:42
 **/
public class GoodsUpdateException extends RuntimeException {
    public GoodsUpdateException() {
        super("商品更新失败");
    }
}
