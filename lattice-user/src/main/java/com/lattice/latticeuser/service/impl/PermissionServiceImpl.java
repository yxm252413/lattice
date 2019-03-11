package com.lattice.latticeuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dao.PermissionMapper;
import com.lattice.latticeuser.entity.Permission;
import com.lattice.latticeuser.entity.PermissionExample;
import com.lattice.latticeuser.exception.PermissionDeleteException;
import com.lattice.latticeuser.service.PermissionService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 11:34
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    
    @Override
    public boolean insert(Permission permission) {
        int i = permissionMapper.insert(permission);
        return i > 0;
    }
    
    @Override
    @Transactional(rollbackFor = PermissionDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            int i = permissionMapper.deleteByPrimaryKey(id);
            if (i < 1) {
                flag = false;
                throw new PermissionDeleteException();
            }
        }
        return flag;
    }
    
    @Override
    public boolean update(Permission permission) {
        int i = permissionMapper.updateByPrimaryKey(permission);
        return i > 0;
    }
    
    @Override
    public Permission get(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Permission> permissions = permissionMapper.selectByExample(new PermissionExample());
        if (permissions == null) {
            LayUiResultDataList.fail("未查找到数据");
        }
        PageInfo pageInfo = new PageInfo<Permission>(permissions);
        return LayUiResultDataList.ok(permissions, pageInfo.getTotal());
    }
}
