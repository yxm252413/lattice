package com.lattice.latticeuser.utils;

import com.lattice.latticeuser.entity.Log;
import com.lattice.latticeuser.entity.Permission;
import com.lattice.latticeuser.entity.Role;
import com.lattice.latticeuser.entity.User;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-17 21:37
 **/
public class CheckUtil {

	public static boolean checkUser(User user){
        /**
         * @Description: 校验传入的User对象是否含有openid和name
         * @Param: [user]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/11/18
         */
        
        return false;
	}

	public static boolean checkPermission(Permission permission){
        /**
         * @Description: 校验传入对象是否正确
         * @Param: [permission]
         * @return: boolean
         * @Author: 张家豪
         * @Date: 2018/11/18
         */
        if (checkString(permission.getPermissionname(), permission.getStatus())
            && checkInteger(permission.getRoleid())) {
            return true;
        }
        return false;
	}

	public static boolean checkRole(Role role) {
        if (checkString(role.getRolename(), role.getStatus())) {
            return true;
        }
        return false;
	}
    
    public static boolean checkLog(Log log) {
        if (checkString(log.getIp(), log.getStatus()) && checkInteger(log.getUserid())) {
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
    
    public static boolean checkUpdateLog(Log log) {
        if (checkInteger(log.getLogid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdatePermission(Permission permission) {
        if (checkInteger(permission.getPermissionid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateRole(Role role) {
        if (checkInteger(role.getRoleid())) {
            return true;
        }
        return false;
    }
    
    public static boolean checkUpdateUser(User user) {
        if (checkString(user.getOpenid()) || checkInteger(user.getUserid())) {
            return true;
        }
        return false;
    }
}
