package com.lattice.latticegoods.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProValue;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:18
 **/
public interface GoodsProValueService {
    boolean insert(GoodsProValue goodsProValue);

    boolean delete(Integer[] ids);

    boolean update(GoodsProValue goodsProValue);

    GoodsProValue get(Integer id);

    LayUiResultDataList list(Integer page, Integer limit);
}
