package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsImgMapper;
import com.lattice.latticegoods.entity.GoodsImg;
import com.lattice.latticegoods.entity.GoodsImgExample;
import com.lattice.latticegoods.exception.GoodsImgDeleteException;
import com.lattice.latticegoods.service.GoodsImgService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:14
 **/
@Service
public class GoodsImgServiceImpl implements GoodsImgService {
    @Autowired
    private GoodsImgMapper goodsImgMapper;

    @Override
    public boolean insert(GoodsImg goodsImg) {
        int i = goodsImgMapper.insertSelective(goodsImg);
        return i > 0;
    }

    @Override
    // @CacheEvict(value = "GoodsImg", key = "#ids", allEntries = true)
    @Transactional(rollbackFor = GoodsImgDeleteException.class,propagation = Propagation.REQUIRED)
    public boolean delete(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            if(goodsImgMapper.deleteByPrimaryKey(id) < 1){
                flag = false;
                throw  new GoodsImgDeleteException();
            }
        }
        return flag;
    }

    @Override
    // @CacheEvict(value = "GoodsImg", key = "#goodsImg.imgid", allEntries = true)
    public boolean update(GoodsImg goodsImg) {
        return goodsImgMapper.updateByPrimaryKeySelective(goodsImg) > 0;
    }

    @Override
    // @Cacheable(value = "GoodsImg", key = "#id")
    public GoodsImg get(Integer id) {
        return goodsImgMapper.selectByPrimaryKey(id);
    }

    @Override
    // @Cacheable(value = "GoodsImgServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<GoodsImg> goodsImgs = goodsImgMapper.selectByExample(new GoodsImgExample());
        if(goodsImgs == null){
            return LayUiResultDataList.fail("未查询到数据");
        }
        PageInfo<GoodsImg> pageInfo = new PageInfo<GoodsImg>(goodsImgs);
        return LayUiResultDataList.ok(goodsImgs,pageInfo.getTotal());
    }
}
