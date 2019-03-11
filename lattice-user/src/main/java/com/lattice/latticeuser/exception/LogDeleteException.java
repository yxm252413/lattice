package com.lattice.latticeuser.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 10:23
 **/
public class LogDeleteException extends RuntimeException {

	public LogDeleteException() {
		super("用户log删除失败");
	}
}
