package com.lattice.latticegoods.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.entity.GoodsImg;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:13
 **/
public interface GoodsImgService {
    boolean insert(GoodsImg goodsImg);

    boolean delete(Integer[] ids);

    boolean update(GoodsImg goodsImg);

    GoodsImg get(Integer id);

    LayUiResultDataList list(Integer page, Integer limit);
}
