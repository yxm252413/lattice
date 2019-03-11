package com.lattice.latticegoods.utils;

import com.lattice.latticecommon.utils.BaseCheckUtil;
import com.lattice.latticegoods.entity.*;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-24 21:57
 **/
public class CheckUtil extends BaseCheckUtil {
    public static boolean checkGoodsCate(GoodsCate goodsCate) {
        /**
         * @Description: 如果含有title status father ord则通过验证返回true
         * @Param: [goodsCate]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        if (checkString(goodsCate.getTitle()) && checkByte(goodsCate.getStatus())
            && checkInteger(goodsCate.getFather(), goodsCate.getOrd())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoodsCate(GoodsCate goodsCate) {
        /**
         * @Description: 验证要修正的goodsCate有没有id
         * @Param: [goodsCate]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        if (checkInteger(goodsCate.getCateid())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean checkGoods(Goods goods) {
        /**
         * @Description:判断goods对象是否有必有的属性 如果都有则为true否则为false
         * @Param: [goods]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        
        if (checkString(goods.getDescription(), goods.getImg(), goods.getKeywords(), goods.getProNo(), goods.getTitle())
            && checkInteger(goods.getCateid(), goods.getPv()) && checkLong(goods.getCost(), goods.getPrice())
            && checkByte(goods.getStatus())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoods(Goods goods) {
        /**
         * @Description:判断goods是否有id
         * @Param: [goods]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        if (goods.getGoodsid() != null) {
            return true;
        }
        return false;
    }
    
    public static boolean checkGoodsImg(GoodsImg goodsImg) {
        if (checkString(goodsImg.getImg()) && checkByte(goodsImg.getStatus()) && checkInteger(goodsImg.getGoodsid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoodsImg(GoodsImg goodsImg) {
        if (checkInteger(goodsImg.getImgid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkGoodsProName(GoodsProName goodsProName) {
        if (checkString(goodsProName.getTitle()) && checkByte(goodsProName.getStatus())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoodsProName(GoodsProName goodsProName) {
        if (checkInteger(goodsProName.getPronameid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkGoodsPropereties(GoodsProperties goodsProperties) {
        if (checkInteger(goodsProperties.getPronameid(), goodsProperties.getSkuid(), goodsProperties.getProvalueid())
            && checkByte(goodsProperties.getStatus())) {
            return true;
        }
        return false;
    }
    
    public static boolean chekUpdateGoodsProperties(GoodsProperties goodsProperties) {
        if (checkInteger(goodsProperties.getProid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkGoodsProValue(GoodsProValue goodsProValue) {
        if (checkString(goodsProValue.getValue()) && checkByte(goodsProValue.getStatus())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoodsProValue(GoodsProValue goodsProValue) {
        if (checkInteger(goodsProValue.getProvalueid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkGoodsSku(GoodsSku goodsSku) {
        if (checkInteger(goodsSku.getGoodsid(), goodsSku.getStock(), goodsSku.getWeight())
            && checkLong(goodsSku.getCost(), goodsSku.getPrice()) && checkByte(goodsSku.getStatus())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateGoodsSku(GoodsSku goodsSku) {
        if (checkInteger(goodsSku.getSkuid())) {
            return true;
        }
        return false;
        
    }
    
}
