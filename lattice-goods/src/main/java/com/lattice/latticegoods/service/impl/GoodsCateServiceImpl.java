package com.lattice.latticegoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dao.GoodsCateMapper;
import com.lattice.latticegoods.entity.GoodsCate;
import com.lattice.latticegoods.entity.GoodsCateExample;
import com.lattice.latticegoods.exception.GoodsCateDeleteException;
import com.lattice.latticegoods.exception.GoodsCateUpdateException;
import com.lattice.latticegoods.service.GoodsCateService;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 00:00
 **/
@Service
public class GoodsCateServiceImpl implements GoodsCateService {
	@Autowired
	private GoodsCateMapper goodsCateMapper;

    @Override
    public boolean insert(GoodsCate goodsCate) {
        int i = goodsCateMapper.insertSelective(goodsCate);
        return i > 0;
    }

	@Override
    // @CacheEvict(value = "GoodsCate", key = "#ids", allEntries = true)
	@Transactional(rollbackFor = GoodsCateDeleteException.class,propagation = Propagation.REQUIRED)
	public boolean delete(Integer[] ids) {
		for (Integer id : ids) {
			if(goodsCateMapper.deleteByPrimaryKey(id) < 1){
				throw new GoodsCateDeleteException();
			}
		}
        return true;
	}

	@Override
    // @CacheEvict(value = "GoodsCate", key = "#goodsCate.cateid", allEntries = true)
    public boolean update(GoodsCate goodsCate) {
		int i = goodsCateMapper.updateByPrimaryKeySelective(goodsCate);
        return i > 0;
    }
    
    @Override
    // @CacheEvict(value = "GoodsCate", key = "#ids", allEntries = true)
    @Transactional(rollbackFor = GoodsCateUpdateException.class, propagation = Propagation.REQUIRED)
    public boolean updateSatus(byte status, Integer[] ids) {
        for (Integer id : ids) {
            int i = goodsCateMapper.updateStatus(id, status);
            if (i < 1) {
                throw new GoodsCateUpdateException();
            }
        }
        return true;
    }
    
    @Override
    // @Cacheable(value = "GoodsCate", key = "#ids")
    public GoodsCate get(Integer goodsCateID) {
        return goodsCateMapper.selectByPrimaryKey(goodsCateID);
    }
    
    @Override
    // @Cacheable(value = "GoodsCateServiceImpl", keyGenerator = "keyGenerator")
    public LayUiResultDataList list(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<GoodsCate> goodsCates = goodsCateMapper.selectByExample(new GoodsCateExample());
        if (goodsCates == null) {
            return LayUiResultDataList.fail("数据为空");
        }
        PageInfo<GoodsCate> pageInfo = new PageInfo<GoodsCate>(goodsCates);
        return LayUiResultDataList.ok(goodsCates, pageInfo.getTotal());
	}
    
    @Override
    // @Cacheable(value = "GoodsCateServiceImpl", keyGenerator = "keyGenerator")
    public List<GoodsCate> list() {
        return goodsCateMapper.selectByExample(new GoodsCateExample());
    }
}
