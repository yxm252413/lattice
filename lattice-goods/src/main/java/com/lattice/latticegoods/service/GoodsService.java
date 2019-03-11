package com.lattice.latticegoods.service;

import com.lattice.latticecommon.result.LayUiResultDataList;
import com.lattice.latticegoods.dto.GoodsDto;
import com.lattice.latticegoods.entity.Goods;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:11
 **/
public interface GoodsService {
    boolean insert(Goods goods);

    boolean delete(Integer[] ids);

    boolean update(Goods goods);

    LayUiResultDataList list(Integer page, Integer limit);

    Goods get(Integer id);

    GoodsDto getAll(Integer goodsID);
    
    boolean updateSatus(byte b, Integer[] ids);
}
