package com.netinfo.emp.demos;

import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.encryptions.AESEncryption;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        String str = "abc";
        System.out.println(AESEncryption.encryptString(str, EncryptionMode.AES256_01_BASE64_ASCII));
    }
}
