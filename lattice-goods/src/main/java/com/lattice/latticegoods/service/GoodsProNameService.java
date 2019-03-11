package com.lattice.latticegoods.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsProName;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:16
 **/
public interface GoodsProNameService {
    boolean insert(GoodsProName goodsProName);

    boolean delete(Integer[] ids);

    boolean update(GoodsProName goodsProName);

    GoodsProName get(Integer goodsProNameID);

    LayUiResultDataList list(Integer page, Integer limit);
}
