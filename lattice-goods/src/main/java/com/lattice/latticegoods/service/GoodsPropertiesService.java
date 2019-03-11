package com.lattice.latticegoods.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProperties;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:20
 **/
public interface GoodsPropertiesService {
    boolean insert(GoodsProperties goodsProperties);

    boolean delete(Integer[] ids);

    boolean update(GoodsProperties goodsProperties);

    GoodsProperties get(Integer goodsPropertiesID);

    LayUiResultDataList list(Integer page, Integer limit);
}
