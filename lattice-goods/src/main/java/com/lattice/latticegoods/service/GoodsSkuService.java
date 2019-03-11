package com.lattice.latticegoods.service;

import java.util.List;

import com.lattice.latticegoods.entity.GoodsSku;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 23:22
 **/
public interface GoodsSkuService {
    boolean insert(GoodsSku goodsSku);

    boolean delete(Integer[] ids);

    boolean update(GoodsSku goodsSku);

    GoodsSku get(Integer goodsSkuID);
    
    boolean updateSatus(byte b, Integer[] ids);
    
    List<GoodsSku> listByGoodsID(Integer goodsid);
}
