package com.lattice.latticeuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticeuser.dao.LogMapper;
import com.lattice.latticeuser.entity.Log;
import com.lattice.latticeuser.entity.LogExample;
import com.lattice.latticeuser.exception.LogDeleteException;
import com.lattice.latticeuser.service.LogService;

/**
 * @program: lattice
 * @description: 实现了LogService的功能
 * @author: 张家豪
 * @create: 2018-11-18 10:13
 **/
@Service
public class LogServiceImpl implements LogService {
    
    @Autowired
    private LogMapper logMapper;
    
    @Override
    public boolean insert(Log log) {
        int i = logMapper.insert(log);
        return i > 0;
    }
    
    @Override
    @Transactional(rollbackFor = LogDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if (logMapper.delete(id) < 1) {
                flag = false;
                throw new LogDeleteException();
            }
        }
        return flag;
    }
    
    @Override
    public boolean update(Log log) {
        int i = logMapper.updateByPrimaryKey(log);
        return i > 0;
    }
    
    @Override
    public Log select(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public LayUiResultDataList selectList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Log> logs = logMapper.selectByExample(new LogExample());
        if (logs == null) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<Log> pageInfo = new PageInfo<Log>(logs);
        
        return LayUiResultDataList.ok(logs, pageInfo.getTotal());
    }
}
