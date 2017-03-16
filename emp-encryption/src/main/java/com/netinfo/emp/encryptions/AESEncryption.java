package com.netinfo.emp.encryptions;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES256加解密处理
 * <p>
 * Project emp-encryption
 * Package com.netinfo.emp.encryptions
 * <p>
 * Created by Charley on 2017/3/1.
 */
public class AESEncryption {

    //<editor-fold desc="密钥">
    private static final String EMP_KEY256_01 = "yv7tgx7l4(psbq^mpv(*n#jy4!ji#e%m";
    private static final String EMP_KEY256_02 = "i0go97^rsndxx%n1yz8pglchr&m^tb$@";
    private static final String EMP_KEY256_03 = "s@$%5*au)k%c0^75flt0d!o9e1y^kw$0";
    //</editor-fold>

    //<editor-fold desc="向量">
    private static final String EMP_IVEC_01 = "4dgf!ivh)oz%uxz6";
    private static final String EMP_IVEC_02 = "%q#36kfzl5lai%cq";
    //</editor-fold>

    //<editor-fold desc="密钥和向量长度">
    /**
     * 密钥长度
     */
    public static final int LENGTH_KEY = 32;
    /**
     * 向量长度
     */
    public static final int LENGTH_IVEC = 16;
    //</editor-fold>

    //<editor-fold desc="加密">

    /**
     * 使用指定的密钥和向量对数据进行加密
     *
     * @param byteSource 待加密数据
     * @param byteKey    密钥
     * @param byteIV     向量
     * @return 加密结果
     * @throws Exception
     */
    public static byte[] encryptBytes(byte[] byteSource, byte[] byteKey,
                                      byte[] byteIV)
            throws Exception {
        int length = byteSource.length;
        length = ((int) Math.ceil(length / 16.0)) * 16;
        byte[] byteTemp = new byte[length];
        for (int i = 0; i < length; i++) {
            byteTemp[i] = '\0';
        }
        System.arraycopy(byteSource, 0, byteTemp, 0, byteSource.length);
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(byteIV);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding"); // AES算法，CBC模式，无填充
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] byteResult = cipher.doFinal(byteTemp);
        return byteResult;
    }

    /**
     * 根据指定的模式对数据进行加密
     *
     * @param byteSource 待加密数据
     * @param mode       加密模式
     * @return 加密结果
     * @throws Exception
     */
    public static byte[] encryptBytes(byte[] byteSource, int mode)
            throws Exception {
        byte[] byteKey;
        byte[] byteIV;
        int temp = mode / 100;
        temp = temp % 10;
        switch (temp) {
            case 1:
                byteKey = EMP_KEY256_01.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 2:
                byteKey = EMP_KEY256_02.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 3:
                byteKey = EMP_KEY256_03.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 4:
                byteKey = EMP_KEY256_01.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            case 5:
                byteKey = EMP_KEY256_02.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            case 6:
                byteKey = EMP_KEY256_03.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            default:
                throw new IllegalArgumentException("mode invalid.");
        }
        return encryptBytes(byteSource, byteKey, byteIV);
    }

    /**
     * 根据指定的模式对字符串加密
     *
     * @param strSource 待加密的字符串
     * @param mode      加密模式
     * @return 加密结果
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
                break;
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        return strReturn;
    }
    //</editor-fold>

    //<editor-fold desc="解密">

    /**
     * 使用指定的密钥和向量对数据进行解密
     *
     * @param byteSource 待解密数据
     * @param byteKey    密钥
     * @param byteIV     向量
     * @return 解密结果
     * @throws Exception
     */
    public static byte[] decryptBytes(byte[] byteSource, byte[] byteKey,
                                      byte[] byteIV)
            throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(byteIV);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding"); // AES算法，CBC模式，无填充
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] byteResult = cipher.doFinal(byteSource);
        return byteResult;
    }

    /**
     * 根据指定的模式对数据进行解密
     *
     * @param byteSource 待解密数据
     * @param mode       加密模式
     * @return 解密结果
     * @throws Exception
     */
    public static byte[] decryptBytes(byte[] byteSource, int mode)
            throws Exception {
        byte[] byteKey;
        byte[] byteIV;
        int temp = mode / 100;
        temp = temp % 10;
        switch (temp) {
            case 1:
                byteKey = EMP_KEY256_01.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 2:
                byteKey = EMP_KEY256_02.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 3:
                byteKey = EMP_KEY256_03.getBytes("US-ASCII");
                byteIV = EMP_IVEC_01.getBytes("US-ASCII");
                break;
            case 4:
                byteKey = EMP_KEY256_01.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            case 5:
                byteKey = EMP_KEY256_02.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            case 6:
                byteKey = EMP_KEY256_03.getBytes("US-ASCII");
                byteIV = EMP_IVEC_02.getBytes("US-ASCII");
                break;
            default:
                throw new IllegalArgumentException("mode invalid.");
        }
        return decryptBytes(byteSource, byteKey, byteIV);
    }

    /**
     * 根据指定的模式对字符串进行解密
     *
     * @param strSource 待解密字符串
     * @param mode      加密模式
     * @return 解密结果
     * @throws Exception
     */
    public static String decryptString(String strSource, int mode)
            throws Exception {
        byte[] byteSource;
        int temp1 = mode / 10;
        temp1 = temp1 % 10;
        switch (temp1) {
            case 1:
                byteSource = Hex.decodeHex(strSource.toCharArray());
                break;
            case 2:
                byteSource = Base64.decodeBase64(strSource);
                break;
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        byte[] byteResult = decryptBytes(byteSource, mode);
        String strReturn;
        int temp2 = mode % 10;
        switch (temp2) {
            case 1:
                strReturn = new String(byteResult, "US-ASCII");
                break;
            case 2:
                strReturn = new String(byteResult, "UTF-8");
                break;
            case 3:
                strReturn = new String(byteResult, "UTF-16LE");
                break;
            default:
                throw new IllegalArgumentException("mode invalid");
        }
        strReturn = StringTrimEnd(strReturn);
        return strReturn;
    }
    //</editor-fold>

    //<editor-fold desc="相关处理">

    /**
     * 去除字符串结尾处的空字符（\0）
     *
     * @param strSource 源字符串
     * @return 去除结尾空字符后的字符串
     */
    private static String StringTrimEnd(String strSource) {
        int length = strSource.length();
        int temp = length;
        for (int i = length - 1; i >= 0; i--) {
            char c = strSource.charAt(i);
            if ('\0' == c) {
                temp--;
            } else {
                break;
            }
        }
        return strSource.substring(0, temp);
    }
    //</editor-fold>
}
