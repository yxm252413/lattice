package com.lattice.latticecommon.utils;

/**
 * @Description: ${description}
 * @Author: 张家豪
 * @CreateDate: 2018-12-30 17:40
 * @UpdateUser: 张家豪
 * @UpdateDate: 2018-12-30 17:40
 * @UpdateRemark: 未修改
 * @Version: 1.0
 */
public class BaseCheckUtil {
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
}
