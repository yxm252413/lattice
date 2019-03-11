package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsMapper;
import com.lattice.latticegoods.dto.GoodsDto;
import com.lattice.latticegoods.entity.Goods;
import com.lattice.latticegoods.entity.GoodsExample;
import com.lattice.latticegoods.exception.GoodsDeleteException;
import com.lattice.latticegoods.exception.GoodsUpdateException;
import com.lattice.latticegoods.service.GoodsService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:12
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    
    @Override
    public boolean insert(Goods goods) {
        int i = goodsMapper.insertSelective(goods);
        return i > 0;
    }
    
    @Override
//    @CacheEvict(value = "Goods", key = "#ids")
    @Transactional(rollbackFor = GoodsDeleteException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if (goodsMapper.deleteByPrimaryKey(id) < 1) {
                flag = false;
                throw new GoodsDeleteException();
            }
        }
        return flag;
    }
    
    @Override
//    @CacheEvict(value = "Goods", key = "#goods.goodsid")
    public boolean update(Goods goods) {
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        return i > 0;
    }
    
    @Override
    // @CacheEvict(value = "Goods", key = "#ids")
    @Transactional(rollbackFor = GoodsUpdateException.class, propagation = Propagation.REQUIRED)
    public boolean updateSatus(byte status, Integer[] ids) {
        for (Integer id : ids) {
            int i = goodsMapper.updateStatus(status, id);
            if (i < 1) {
                throw new GoodsUpdateException();
            }
        }
        return true;
    }
    
    @Override
//    @Cacheable(value = "GoodsDto", key = "#goodsID")
    public GoodsDto getAll(Integer goodsID) {
        return goodsMapper.getAll(goodsID);
    }
    
    @Override
//    @Cacheable(value = "GoodsServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.selectByExample(new GoodsExample());
        if (goods == null) {
            return LayUiResultDataList.error();
        }
        PageInfo pageInfo = new PageInfo(goods);
        return LayUiResultDataList.ok(goods, pageInfo.getTotal());
    }
    
    @Override
//    @Cacheable(value = "Goods", key = "#id")
    public Goods get(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
