package com.lattice.latticegoods.dto;

import java.io.Serializable;
import java.util.Date;

import com.lattice.latticegoods.entity.GoodsProName;
import com.lattice.latticegoods.entity.GoodsProValue;

import lombok.Data;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-12-02 11:21
 **/
@Data
public class GoodsProDto implements Serializable {
    private Integer proid;
    
    private Integer goodsid;
    
    private GoodsProName goodsProName;
    
    private GoodsProValue goodsProValue;
    
    private Byte status;
    
    private Date created;
    
    private Date updated;
}
