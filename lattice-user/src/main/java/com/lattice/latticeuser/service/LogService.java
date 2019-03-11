package com.lattice.latticeuser.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.entity.Log;

/**
 * @program: lattice
 * @description: 日志的Service的相关操作
 * @author: 张家豪
 * @create: 2018-11-18 10:12
 **/
public interface LogService {
    /**
     * 通过日志对象添加日志
     * 
     * @param log
     * @return 是否添加成功 boolean
     */
    boolean insert(Log log);

    /**
     * 通过日志的id的集合删除日志
     * 
     * @param ids
     * @return 是否删除成功 boolean
     */
	boolean delete(Integer[] ids);

    /**
     * 通过日志对象的id进行更新日志
     * 
     * @param log
     * @return 是否更新成功 boolean
     */
    boolean update(Log log);

    /**
     * 通过日志id查询日志
     * 
     * @param id
     * @return
     */
	Log select(Integer id);

    /**
     * 获取日志的集合 通过当前页和每页数据条数
     * 
     * @param page
     * @param limit
     * @return
     */
	LayUiResultDataList selectList(Integer page, Integer limit);
}
