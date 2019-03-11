package com.lattice.latticeorder.utils;

import com.lattice.latticeorder.entity.Order;
import com.lattice.latticeorder.entity.OrderItem;
import com.lattice.latticeorder.entity.OrderShipping;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-23 20:27
 **/
public class CheckUtil {
	public static boolean checkOrder(Order order) {
        if (checkString(order.getBuyermessage(),
            order.getPayment(),
            order.getPaymentType(),
            order.getPostFree(),
            order.getShippingcode(),
            order.getShippingname()) && checkInteger(order.getOrderid(), order.getStatus(), order.getUserid())) {
            return true;
        }
        
        return false;
	}

	public static boolean checkUpdateOrder(Order order) {
        if (checkInteger(order.getOrderid())) {
            return true;
        }
        return false;
	}

	public static boolean checkOrderItem(OrderItem orderItem) {
        if (checkString(orderItem.getPicpath(), orderItem.getTitle()) && checkInteger(orderItem
            .getGoodsid(), orderItem.getNum(), orderItem.getOrderid(), orderItem.getPrice(), orderItem.getTotalfee())) {
            return true;
        }
        return false;
	}

	public static boolean checkOrderShipping(OrderShipping orderShipping) {
        if (checkString(orderShipping.getReceiveraddress(),
            orderShipping.getReceivercity(),
            orderShipping.getReceiverdistrict(),
            orderShipping.getReceivername(),
            orderShipping.getReceiverphone(),
            orderShipping.getReceiverstate(),
            orderShipping.getReceiverzip()) && checkInteger(orderShipping.getOrderid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkString(String... strings) {
        /**
         * @Description: check String是否为null 和 "" 都不为返回true否则返回false
         * @Param: [strings]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        for (String string : strings) {
            if (string == null || "".equals(string)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkInteger(Integer... integers) {
        /**
         * @Description: 判断Integer是否为null 不为null返回true否则返回false
         * @Param: [integers]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        for (Integer integer : integers) {
            if (integer == null) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkLong(Long... longs) {
        /**
         * @Description: 判断你是否为null
         * @Param: [longs]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/12/24
         */
        for (Long aLong : longs) {
            if (aLong == null) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkByte(Byte... bytes) {
        for (Byte aByte : bytes) {
            if (aByte == null) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkUpdateOrderItem(OrderItem orderItem) {
        if (checkInteger(orderItem.getOrderitemid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateOrderShipping(OrderShipping orderShipping) {
        if (checkInteger(orderShipping.getOrdershippingid())) {
            return true;
        }
        return false;
    }
}
