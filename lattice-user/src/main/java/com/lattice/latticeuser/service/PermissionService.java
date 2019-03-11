package com.lattice.latticeuser.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Permission;

/**
 * @program: lattice
 * @description: 权限的Service的相关操作
 * @author: 张家豪
 * @create: 2018-11-18 11:34
 **/
public interface PermissionService {
    /**
     * 通过权限对象添加权限信息
     * 
     * @param permission
     * @return 是否添加成功
     */
    boolean insert(Permission permission);

    /**
     * 通过权限信息的id进行删除
     * 
     * @param ids
     * @return 是否删除成功
     */
	boolean delete(Integer[] ids);

    /**
     * 通过权限对象的id进行更新
     * 
     * @param permission
     * @return 更新是否成功
     */
    boolean update(Permission permission);

    /**
     * 通过权限id获取权限的相关信息
     * 
     * @param id
     * @return 权限的相关信息
     */
	Permission get(Integer id);

    /**
     * 通过当前页和每页个数进行获取列表
     * 
     * @param page
     * @param limit
     * @return
     */
	LayUiResultDataList list(Integer page, Integer limit);
}
