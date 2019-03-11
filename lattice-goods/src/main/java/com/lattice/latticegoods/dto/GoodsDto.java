package com.lattice.latticegoods.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.lattice.latticegoods.entity.GoodsCate;
import com.lattice.latticegoods.entity.GoodsImg;
import com.lattice.latticegoods.entity.GoodsSku;

import lombok.Data;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-12-02 10:39
 **/
@Data
public class GoodsDto implements Serializable {
    private static final long serialVersionUID = -7319195115185820499L;
    private Integer goodsid;
    
    private GoodsCate goodsCate;
    
    private String title;
    
    private String proNo;
    
    private String keywords;
    
    private String description;
    
    private String img;
    
    private Long price;
    
    private Long cost;
    
    private Integer pv;
    
    private Byte status;
    
    private Date created;
    
    private Date updated;
    
    private Set<GoodsImg> goodsImgs;
    
    private Set<GoodsSku> goodsSkus;
}
