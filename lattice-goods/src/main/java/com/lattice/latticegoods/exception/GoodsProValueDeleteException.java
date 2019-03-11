package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:25
 **/
public class GoodsProValueDeleteException extends RuntimeException {
    public GoodsProValueDeleteException() {
        super("商品配置属性值删除失败");
    }
}
