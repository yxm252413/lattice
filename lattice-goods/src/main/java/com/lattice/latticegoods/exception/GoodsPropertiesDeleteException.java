package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:26
 **/
public class GoodsPropertiesDeleteException extends RuntimeException {
    public GoodsPropertiesDeleteException() {
        super("商品配置删除失败");
    }
}
