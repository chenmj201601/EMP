package com.netinfo.emp.encryptions;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * SHA加密，包括 256 位 和 512 位 哈希算法
 * <p>
 * Project emp-encryption
 * Package com.netinfo.emp.encryptions
 * <p>
 * Created by Charley on 2017/3/2.
 */
public class SHAEncryption {
    /**
     * 加密字符串
     *
     * @param strSource 待加密字符串
     * @param mode      加密模式
     * @return      加密结果
     * @throws Exception
     */
    public static String encryptString(String strSource, int mode)
            throws Exception {
        byte[] byteSource;
        int temp1 = mode % 10;
        switch (temp1) {
            case 1:
                byteSource = strSource.getBytes("US-ASCII");
                break;
            case 2:
                byteSource = strSource.getBytes("UTF-8");
                break;
            case 3:
                byteSource = strSource.getBytes("UTF-16LE");
                break;
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        byte[] byteResult = encryptBytes(byteSource, mode);
        int temp2 = mode / 10;
        temp2 = temp2 % 10;
        String strReturn;
        switch (temp2) {
            case 1:
                strReturn = Hex.encodeHexString(byteResult);
                strReturn = strReturn.toUpperCase();
                break;
            case 2:
                strReturn = Base64.encodeBase64String(byteResult);
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        return strReturn;
    }

    /**
     * 加密字节数组
     *
     * @param byteSource 待加密数据
     * @param mode       加密模式
     * @return      加密结果
     * @throws Exception
     */
    public static byte[] encryptBytes(byte[] byteSource, int mode)
            throws Exception {
        int temp = mode / 1000;
        MessageDigest sha;
        switch (temp) {
            case 3:
                sha = MessageDigest.getInstance("SHA-256");
                break;
            case 4:
                sha = MessageDigest.getInstance("SHA-512");
                break;
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        byte[] data = sha.digest(byteSource);
        return data;
    }
}
