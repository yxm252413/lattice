package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsProValueMapper;
import com.lattice.latticegoods.entity.GoodsProValue;
import com.lattice.latticegoods.entity.GoodsProValueExample;
import com.lattice.latticegoods.exception.GoodsProValueDeleteException;
import com.lattice.latticegoods.service.GoodsProValueService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:18
 **/
@Service
public class GoodsProValueServiceImpl implements GoodsProValueService {
    
    @Autowired
    private GoodsProValueMapper goodsProValueMapper;
    
    @Override
    public boolean insert(GoodsProValue goodsProValue) {
        int i = goodsProValueMapper.insertSelective(goodsProValue);
        return i > 0;
    }
    
    @Override
    // @CacheEvict(value = "GoodsProValue", key = "#ids")
    @Transactional(rollbackFor = GoodsProValueDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if (goodsProValueMapper.deleteByPrimaryKey(id) < 1) {
                flag = false;
                throw new GoodsProValueDeleteException();
            }
        }
        return flag;
    }
    
    @Override
    // @CacheEvict(value = "GoodsProValue", key = "#goodsProValue.provalueid")
    public boolean update(GoodsProValue goodsProValue) {
        int i = goodsProValueMapper.updateByPrimaryKey(goodsProValue);
        return i > 0;
    }
    
    @Override
    // @Cacheable(value = "GoodsProValue", key = "#id")
    public GoodsProValue get(Integer id) {
        GoodsProValue goodsProValue = goodsProValueMapper.selectByPrimaryKey(id);
        return goodsProValue;
    }
    
    @Override
    // @Cacheable(value = "GoodsProValueServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<GoodsProValue> goodsProValues = goodsProValueMapper.selectByExample(new GoodsProValueExample());
        if (goodsProValues == null) {
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<GoodsProValue> pageInfo = new PageInfo<GoodsProValue>(goodsProValues);
        return LayUiResultDataList.ok(goodsProValues, pageInfo.getTotal());
    }
}
