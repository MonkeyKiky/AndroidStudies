package com.monkey.phoneguard.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MonkeyKiky on 2015/10/2.
 */
public class MD5Utils {

    /**
     * MD5加密密码
     * @param password 密码
     * @return 32位MD5值
     */
    public static String encode(String password) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");// 获取MD5算法对象
            byte[] digest = instance.digest(password.getBytes());// 对字符串加密,返回字节数组

            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                int i = b & 0xff;// 获取字节的低八位有效值
                String hexString = Integer.toHexString(i);// 将整数转为16进制

                if (hexString.length() < 2) {
                    hexString = "0" + hexString;// 如果是1位的话,补0
                }

                sb.append(hexString);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // 没有该算法时,抛出异常, 不会走到这里
        }

        return "";
    }
}
