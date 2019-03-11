package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:27
 **/
public class GoodsSkuDeleteException extends RuntimeException{
    public GoodsSkuDeleteException() {
        super("商品Sku删除失败");
    }
}
