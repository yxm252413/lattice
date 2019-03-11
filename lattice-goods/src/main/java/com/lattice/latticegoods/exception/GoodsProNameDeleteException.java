package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:25
 **/
public class GoodsProNameDeleteException extends RuntimeException {
    public GoodsProNameDeleteException() {
        super("商品配置名称删除失败");
    }
}
