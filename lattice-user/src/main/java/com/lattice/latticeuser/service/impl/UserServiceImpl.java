package com.lattice.latticeuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dao.UserMapper;
import com.lattice.latticeuser.dto.UserDTO;
import com.lattice.latticeuser.entity.User;
import com.lattice.latticeuser.entity.UserExample;
import com.lattice.latticeuser.exception.UserDeleteException;
import com.lattice.latticeuser.service.UserService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 01:08
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<User> users = userMapper.selectByExample(new UserExample());
        if (users == null) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return LayUiResultDataList.ok(users, pageInfo.getTotal());
    }
    
    @Override
    public boolean insert(User user) {
        int i = userMapper.insertSelective(user);
        return i > 0;
    }
    
    @Override
    @Transactional(rollbackFor = UserDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if (userMapper.delete(id) < 1) {
                flag = false;
                throw new UserDeleteException();
            }
        }
        return flag;
        
    }
    
    @Override
    public boolean update(User user) {
        int i = userMapper.updateByExampleSelective(user, new UserExample());
        return i > 0;
    }
    
    @Override
    public User getUserByOpenid(String openid) {
        UserExample example = new UserExample();
        example.createCriteria().andOpenidEqualTo(openid);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return new User();
    }

    @Override
    public User getUserByUserid(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        return user;
    }
    
	@Override
    @Cacheable(value = "UserDTO", keyGenerator = "keyGenerator")
    public UserDTO getAll(String openid) {
        return userMapper.getAll(openid);
    }
}
