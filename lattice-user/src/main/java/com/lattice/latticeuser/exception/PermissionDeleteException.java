package com.lattice.latticeuser.exception;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 12:15
 **/
public class PermissionDeleteException extends RuntimeException {

	public PermissionDeleteException() {
		super("权限删除失败");
	}
}
