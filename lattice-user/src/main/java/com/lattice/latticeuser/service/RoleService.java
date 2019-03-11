package com.lattice.latticeuser.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Role;

/**
 * @program: lattice
 * @description: 角色Service的相关操作
 * @author: 张家豪
 * @create: 2018-11-18 14:32
 **/
public interface RoleService {
    /**
     * 通过角色对象进行添加
     * 
     * @param role
     * @return 角色信息是否添加成功
     */
    boolean insert(Role role);

    /**
     * 通过角色信息的id进行删除角色信息
     * 
     * @param ids
     * @return 是否删除成功
     */
	boolean delete(Integer[] ids);

    /**
     * 通过角色对象的id进行更新角色信息
     * 
     * @param role
     * @return 是否更新成功
     */
    boolean update(Role role);

    /**
     * 通过角色信息的id进行获取角色信息
     * 
     * @param id
     * @return
     */
	Role get(Integer id);

    /**
     * 通过当前页和每页个数进行获取列表
     *
     * @param page
     * @param limit
     * @return
     */
	LayUiResultDataList list(Integer page, Integer limit);
}
