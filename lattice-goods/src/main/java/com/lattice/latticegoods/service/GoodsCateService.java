package com.lattice.latticegoods.service;

import java.util.List;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsCate;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 00:00
 **/
public interface GoodsCateService {
    LayUiResultDataList list(Integer page, Integer limit);
    
    List<GoodsCate> list();
    
    boolean insert(GoodsCate goodsCate);
    
    boolean delete(Integer[] ids);
    
    boolean update(GoodsCate goodsCate);
    
    GoodsCate get(Integer goodsCateID);
    
    boolean updateSatus(byte b, Integer[] ids);
}
