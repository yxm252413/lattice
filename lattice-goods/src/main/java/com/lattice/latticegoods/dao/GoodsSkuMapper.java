package com.lattice.latticegoods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lattice.latticegoods.entity.GoodsSku;
import com.lattice.latticegoods.entity.GoodsSkuExample;

public interface GoodsSkuMapper {
    int countByExample(GoodsSkuExample example);

    int deleteByExample(GoodsSkuExample example);

    int deleteByPrimaryKey(Integer skuid);

    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    List<GoodsSku> selectByExample(GoodsSkuExample example);

    GoodsSku selectByPrimaryKey(Integer skuid);

    int updateByExampleSelective(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByExample(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);
    
    int updateStatus(@Param("status") byte status, @Param("skuid") Integer skuid);
}