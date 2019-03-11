package com.lattice.latticeuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dao.RoleMapper;
import com.lattice.latticeuser.entity.Role;
import com.lattice.latticeuser.entity.RoleExample;
import com.lattice.latticeuser.exception.RoleDeleteException;
import com.lattice.latticeuser.service.RoleService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 14:32
 **/
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;


	@Override
    public boolean insert(Role role) {
		int i = roleMapper.insertSelective(role);
        return i > 0;
	}

	@Override
	@Transactional(rollbackFor = RoleDeleteException.class,propagation = Propagation.REQUIRED)
	public boolean delete(Integer[] ids) {
		boolean flag = false;

		try {
			for (Integer id : ids) {
				if(roleMapper.delete(id) > 0){
					flag = false;
					throw new RoleDeleteException();
				}
			}
			flag = true;
		} finally {
			return flag;
		}
	}

	@Override
    public boolean update(Role role) {
        int i = roleMapper.updateByExampleSelective(role, new RoleExample());
        return i > 0;
	}

	@Override
	public Role get(Integer id) {
		Role role = roleMapper.selectByPrimaryKey(id);

		return role;
	}

	@Override
	public LayUiResultDataList list(Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		List<Role> roles = roleMapper.selectByExample(new RoleExample());
		if(roles == null){
            return LayUiResultDataList.fail("未查询到数据");
		}
        PageInfo<Role> pageInfo = new PageInfo<Role>(roles);
		return LayUiResultDataList.ok(roles,pageInfo.getTotal());
	}
}
