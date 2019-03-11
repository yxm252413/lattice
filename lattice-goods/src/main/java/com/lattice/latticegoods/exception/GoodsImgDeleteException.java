package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:24
 **/
public class GoodsImgDeleteException extends RuntimeException {
    public GoodsImgDeleteException() {
        super("商品图片删除失败");
    }
}
