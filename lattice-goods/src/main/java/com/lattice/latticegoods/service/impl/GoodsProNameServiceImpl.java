package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsProNameMapper;
import com.lattice.latticegoods.entity.GoodsProName;
import com.lattice.latticegoods.entity.GoodsProNameExample;
import com.lattice.latticegoods.exception.GoodsProNameDeleteException;
import com.lattice.latticegoods.service.GoodsProNameService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:16
 **/
@Service
public class GoodsProNameServiceImpl implements GoodsProNameService {
    @Autowired
    private GoodsProNameMapper goodsProNameMapper;

    @Override
    
    public boolean insert(GoodsProName goodsProName) {
        int i = goodsProNameMapper.insertSelective(goodsProName);
        return i > 0;
    }

    @Override
    // @CacheEvict(value = "GoodsProName", key = "#ids", allEntries = true)
    @Transactional(rollbackFor = GoodsProNameDeleteException.class,propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if(goodsProNameMapper.deleteByPrimaryKey(id) < 1){
                flag = false;
                throw new GoodsProNameDeleteException();
            }

        }
        return flag;
    }

    @Override
    // @CacheEvict(value = "GoodsProName", key = "#goodsProName.pronameid", allEntries = true)
    public boolean update(GoodsProName goodsProName) {
        int i = goodsProNameMapper.updateByPrimaryKeySelective(goodsProName);
        return i > 0;
    }

    @Override
    // @Cacheable(value = "GoodsProName", key = "#goodsProNameID")
    public GoodsProName get(Integer goodsProNameID) {
        return goodsProNameMapper.selectByPrimaryKey(goodsProNameID);
    }

    @Override
    // @Cacheable(value = "GoodsProNameServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<GoodsProName> goodsProNames = goodsProNameMapper.selectByExample(new GoodsProNameExample());
        if(goodsProNames == null){
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<GoodsProName> pageInfo = new PageInfo<GoodsProName>(goodsProNames);
        return LayUiResultDataList.ok(goodsProNames,pageInfo.getTotal());
    }
}
