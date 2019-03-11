package com.lattice.latticeuser.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 14:48
 **/
public class RoleDeleteException extends RuntimeException {
	public RoleDeleteException() {
		super("Role删除失败");
	}
}
