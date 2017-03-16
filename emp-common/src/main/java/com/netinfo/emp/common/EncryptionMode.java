package com.netinfo.emp.common;

/**
 * 加密模式
 * <p>
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/2.
 */
public class EncryptionMode {

    //<editor-fold defaultstate="collapsed" desc="Const define of EncryptMode">
    /**
     * 加密模式 加密模式是算法、密钥、向量与编码的组合，由5位数值表示
     * <p>
     * 算法（第1位）
     * 1：AES128 2：AES256 3：SHA256 4：SHA512
     * <p>
     * 密钥和向量（第2位）
     * 1：EMP_KEY256_01+EMP_IVEC_01
     * 2：EMP_KEY256_02+EMP_IVEC_01
     * 3：EMP_KEY256_03+EMP_IVEC_01
     * 4：EMP_KEY256_01+EMP_IVEC_02
     * 5：EMP_KEY256_02+EMP_IVEC_02
     * 6：EMP_KEY256_03+EMP_IVEC_02
     * <p>
     * 密文编码类型（第3位）
     * 1：Hex（十六进制表示） 2：Base64表示
     * <p>
     * 明文编码类型（第4位）
     * 1：ASCII 2：UTF-8 3：Unicode（UTF-16E）
     */
    public static final int AES256_01_HEX_ASCII = 2111;
    public static final int AES256_02_HEX_ASCII = 2211;
    public static final int AES256_03_HEX_ASCII = 2311;
    public static final int AES256_04_HEX_ASCII = 2411;
    public static final int AES256_05_HEX_ASCII = 2511;
    public static final int AES256_06_HEX_ASCII = 2611;

    public static final int AES256_01_BASE64_ASCII = 2121;
    public static final int AES256_02_BASE64_ASCII = 2221;
    public static final int AES256_03_BASE64_ASCII = 2321;
    public static final int AES256_04_BASE64_ASCII = 2421;
    public static final int AES256_05_BASE64_ASCII = 2521;
    public static final int AES256_06_BASE64_ASCII = 2621;

    public static final int AES256_01_HEX_UTF8 = 2112;
    public static final int AES256_02_HEX_UTF8 = 2212;
    public static final int AES256_03_HEX_UTF8 = 2312;
    public static final int AES256_04_HEX_UTF8 = 2412;
    public static final int AES256_05_HEX_UTF8 = 2512;
    public static final int AES256_06_HEX_UTF8 = 2612;

    public static final int AES256_01_BASE64_UTF8 = 2122;
    public static final int AES256_02_BASE64_UTF8 = 2223;
    public static final int AES256_03_BASE64_UTF8 = 2322;
    public static final int AES256_04_BASE64_UTF8 = 2422;
    public static final int AES256_05_BASE64_UTF8 = 2522;
    public static final int AES256_06_BASE64_UTF8 = 2622;

    public static final int AES256_01_HEX_UNICODE = 2113;
    public static final int AES256_02_HEX_UNICODE = 2213;
    public static final int AES256_03_HEX_UNICODE = 2313;
    public static final int AES256_04_HEX_UNICODE = 2413;
    public static final int AES256_05_HEX_UNICODE = 2513;
    public static final int AES256_06_HEX_UNICODE = 2613;

    public static final int AES256_01_BASE64_UNICODE = 2123;
    public static final int AES256_02_BASE64_UNICODE = 2223;
    public static final int AES256_03_BASE64_UNICODE = 2323;
    public static final int AES256_04_BASE64_UNICODE = 2423;
    public static final int AES256_05_BASE64_UNICODE = 2523;
    public static final int AES256_06_BASE64_UNICODE = 2623;


    public static final int SHA256_00_HEX_ASCII = 3011;
    public static final int SHA256_00_BASE64_ASCII = 3021;
    public static final int SHA256_00_HEX_UTF8 = 3012;
    public static final int SHA256_00_BASE64_UTF8 = 3022;
    public static final int SHA256_00_HEX_UNICODE = 3013;
    public static final int SHA256_00_BASE64_UNICODE = 3023;

    public static final int SHA512_00_HEX_ASCII = 4011;
    public static final int SHA512_00_BASE64_ASCII = 4021;
    public static final int SHA512_00_HEX_UTF8 = 4012;
    public static final int SHA512_00_BASE64_UTF8 = 4022;
    public static final int SHA512_00_HEX_UNICODE = 4013;
    public static final int SHA512_00_BASE64_UNICODE = 4023;
    //</editor-fold>

}
