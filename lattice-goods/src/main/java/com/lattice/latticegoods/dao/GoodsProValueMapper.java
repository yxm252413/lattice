package com.lattice.latticegoods.dao;

import com.lattice.latticegoods.entity.GoodsProValue;
import com.lattice.latticegoods.entity.GoodsProValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsProValueMapper {
    int countByExample(GoodsProValueExample example);

    int deleteByExample(GoodsProValueExample example);

    int deleteByPrimaryKey(Integer provalueid);

    int insert(GoodsProValue record);

    int insertSelective(GoodsProValue record);

    List<GoodsProValue> selectByExample(GoodsProValueExample example);

    GoodsProValue selectByPrimaryKey(Integer provalueid);

    int updateByExampleSelective(@Param("record") GoodsProValue record, @Param("example") GoodsProValueExample example);

    int updateByExample(@Param("record") GoodsProValue record, @Param("example") GoodsProValueExample example);

    int updateByPrimaryKeySelective(GoodsProValue record);

    int updateByPrimaryKey(GoodsProValue record);
}