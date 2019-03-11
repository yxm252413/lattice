package com.lattice.latticeuser.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 22:16
 **/
public class UserDeleteException extends RuntimeException {

	public UserDeleteException() {

		super("用户信息删除失败");
	}
}
