package com.zzh.utils;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author Aurora
 * @Date 2021/1/10 13:05
 * @Version 1.0
 * md5加密
 */
public class MD5Utils {

    public static String md5Digest(String source, Integer salt) {
        char[] ca = source.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            ca[i] = (char) (ca[i] + salt);
        }
        String target = new String(ca);
        String md5 = DigestUtils.md5Hex(target);
        //System.out.println(md5);//
        return md5;
    }
}
