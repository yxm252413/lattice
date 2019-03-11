package com.lattice.latticegoods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lattice.latticegoods.entity.GoodsCate;
import com.lattice.latticegoods.entity.GoodsCateExample;

public interface GoodsCateMapper {
    int countByExample(GoodsCateExample example);

    int deleteByExample(GoodsCateExample example);

    int deleteByPrimaryKey(Integer cateid);

    int insert(GoodsCate record);

    int insertSelective(GoodsCate record);

    List<GoodsCate> selectByExample(GoodsCateExample example);

    GoodsCate selectByPrimaryKey(Integer cateid);

    int updateByExampleSelective(@Param("record") GoodsCate record, @Param("example") GoodsCateExample example);

    int updateByExample(@Param("record") GoodsCate record, @Param("example") GoodsCateExample example);

    int updateByPrimaryKeySelective(GoodsCate record);

    int updateByPrimaryKey(GoodsCate record);

    /**
     * 通过cateid来进行更新状态status
     * 
     * @param cateid
     * @param status
     * @return 影响的条数
     */
    int updateStatus(@Param("cateid") Integer cateid, byte status);
}