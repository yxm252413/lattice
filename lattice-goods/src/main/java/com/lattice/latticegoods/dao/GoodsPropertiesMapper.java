package com.lattice.latticegoods.dao;

import com.lattice.latticegoods.entity.GoodsProperties;
import com.lattice.latticegoods.entity.GoodsPropertiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPropertiesMapper {
    int countByExample(GoodsPropertiesExample example);

    int deleteByExample(GoodsPropertiesExample example);

    int deleteByPrimaryKey(Integer proid);

    int insert(GoodsProperties record);

    int insertSelective(GoodsProperties record);

    List<GoodsProperties> selectByExample(GoodsPropertiesExample example);

    GoodsProperties selectByPrimaryKey(Integer proid);

    int updateByExampleSelective(@Param("record") GoodsProperties record, @Param("example") GoodsPropertiesExample example);

    int updateByExample(@Param("record") GoodsProperties record, @Param("example") GoodsPropertiesExample example);

    int updateByPrimaryKeySelective(GoodsProperties record);

    int updateByPrimaryKey(GoodsProperties record);
}