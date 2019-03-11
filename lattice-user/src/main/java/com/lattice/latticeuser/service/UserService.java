package com.lattice.latticeuser.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dto.UserDTO;
import com.lattice.latticeuser.entity.User;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:07
 **/
public interface UserService {
	LayUiResultDataList list(Integer page, Integer limit);

    boolean insert(User user);

	boolean delete(Integer[] ids);

    boolean update(User user);

	User getUserByOpenid(String openid);

	UserDTO getAll(String openid);
    
    User getUserByUserid(Integer userid);
}
