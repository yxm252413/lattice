package com.lattice.latticegoods.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 22:06
 **/
public class GoodsCateDeleteException extends RuntimeException {
	public GoodsCateDeleteException() {
		super("商品分类删除失败");
	}
}
