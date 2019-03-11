package com.lattice.latticegoods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lattice.latticegoods.dto.GoodsDto;
import com.lattice.latticegoods.entity.Goods;
import com.lattice.latticegoods.entity.GoodsExample;

public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    GoodsDto getAll(Integer goodsID);
    
    int updateStatus(@Param("status") byte status, @Param("goodsid") Integer goodsid);
}