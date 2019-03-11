package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsPropertiesMapper;
import com.lattice.latticegoods.entity.GoodsProperties;
import com.lattice.latticegoods.entity.GoodsPropertiesExample;
import com.lattice.latticegoods.exception.GoodsPropertiesDeleteException;
import com.lattice.latticegoods.service.GoodsPropertiesService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:21
 **/
@Service
public class GoodsPropertiesServiceImpl implements GoodsPropertiesService {
    @Autowired
    private GoodsPropertiesMapper goodsPropertiesMapper;

    @Override
    public boolean insert(GoodsProperties goodsProperties) {
        int i = goodsPropertiesMapper.insertSelective(goodsProperties);
        return i > 0;
    }

    @Override
    // @CacheEvict(value = "GoodsProperties", key = "#ids")
    @Transactional(rollbackFor = GoodsPropertiesDeleteException.class,propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if(goodsPropertiesMapper.deleteByPrimaryKey(id) < 1){
                flag = false;
                throw new GoodsPropertiesDeleteException();
            }
        }
        return flag;
    }

    @Override
    // @CacheEvict(value = "GoodsProperties", key = "#goodsProperties.proid")
    public boolean update(GoodsProperties goodsProperties) {
        int i = goodsPropertiesMapper.updateByPrimaryKeySelective(goodsProperties);
        return i > 0;
    }

    @Override
    // @Cacheable(value = "GoodsProperties", key = "#goodsPropertiesID")
    public GoodsProperties get(Integer goodsPropertiesID) {
        GoodsProperties goodsProperties = goodsPropertiesMapper.selectByPrimaryKey(goodsPropertiesID);
        return goodsProperties;
    }

    @Override
    // @Cacheable(value = "GoodsPropertiesServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<GoodsProperties> goodsProperties = goodsPropertiesMapper.selectByExample(new GoodsPropertiesExample());
        if(goodsProperties == null){
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<GoodsProperties> pageInfo = new PageInfo<GoodsProperties>(goodsProperties);
        return LayUiResultDataList.ok(goodsProperties,pageInfo.getTotal());
    }
}
