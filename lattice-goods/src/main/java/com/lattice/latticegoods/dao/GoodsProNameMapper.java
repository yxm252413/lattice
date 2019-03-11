package com.lattice.latticegoods.dao;

import com.lattice.latticegoods.entity.GoodsProName;
import com.lattice.latticegoods.entity.GoodsProNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsProNameMapper {
    int countByExample(GoodsProNameExample example);

    int deleteByExample(GoodsProNameExample example);

    int deleteByPrimaryKey(Integer pronameid);

    int insert(GoodsProName record);

    int insertSelective(GoodsProName record);

    List<GoodsProName> selectByExample(GoodsProNameExample example);

    GoodsProName selectByPrimaryKey(Integer pronameid);

    int updateByExampleSelective(@Param("record") GoodsProName record, @Param("example") GoodsProNameExample example);

    int updateByExample(@Param("record") GoodsProName record, @Param("example") GoodsProNameExample example);

    int updateByPrimaryKeySelective(GoodsProName record);

    int updateByPrimaryKey(GoodsProName record);
}