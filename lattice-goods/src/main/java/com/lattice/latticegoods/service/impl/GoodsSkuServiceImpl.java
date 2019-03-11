package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lattice.latticegoods.dao.GoodsSkuMapper;
import com.lattice.latticegoods.entity.GoodsSku;
import com.lattice.latticegoods.entity.GoodsSkuExample;
import com.lattice.latticegoods.exception.GoodsSkuDeleteException;
import com.lattice.latticegoods.exception.GoodsUpdateException;
import com.lattice.latticegoods.service.GoodsSkuService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:23
 **/
@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Override
    public boolean insert(GoodsSku goodsSku) {
        int i = goodsSkuMapper.insertSelective(goodsSku);
        return i > 0;
    }

    @Override
    // @CacheEvict(value = "GoodsSku", key = "#ids")
    @Transactional(rollbackFor = GoodsSkuDeleteException.class,propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if(goodsSkuMapper.deleteByPrimaryKey(id) < 1){
                flag = false;
                throw new GoodsSkuDeleteException();
            }
        }
        return flag;
    }

    @Override
    // @CacheEvict(value = "GoodsSku", key = "#goodsSku.skuid")
    public boolean update(GoodsSku goodsSku) {
        int i = goodsSkuMapper.updateByPrimaryKeySelective(goodsSku);
        return i > 0;
    }
    
    @Override
    // @CacheEvict(value = "goodsSku", key = "#ids")
    @Transactional(rollbackFor = GoodsUpdateException.class, propagation = Propagation.REQUIRED)
    public boolean updateSatus(byte status, Integer[] ids) {
        for (Integer id : ids) {
            int i = goodsSkuMapper.updateStatus(status, id);
            if (i < 1) {
                throw new GoodsUpdateException();
            }
        }
        return true;
    }
    
    @Override
    // @Cacheable(value = "GoodsSkuServiceImpl", key = "#goodsSkuID")
    public GoodsSku get(Integer goodsSkuID) {
        GoodsSku goodsSku = goodsSkuMapper.selectByPrimaryKey(goodsSkuID);
        return goodsSku;
    }

    @Override
    // @Cacheable(value = "GoodsSkuServiceImpl", keyGenerator = "keyGenerator")
    public List<GoodsSku> listByGoodsID(Integer goodsid) {
        GoodsSkuExample goodsSkuExample = new GoodsSkuExample();
        goodsSkuExample.createCriteria().andGoodsidEqualTo(goodsid);
        return goodsSkuMapper.selectByExample(goodsSkuExample);
    }
}
