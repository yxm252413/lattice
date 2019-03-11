package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-12-24 15:06
 **/
public class GoodsCateUpdateException extends RuntimeException {
    public GoodsCateUpdateException() {
        super("商品分类更新失败");
    }
}
