package com.netinfo.emp.encryptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Project emp-encryption
 * Package com.netinfo.emp.encryptions
 * <p>
 * Created by Charley on 2017/3/1.
 */
public class AESEncryptionTest {
    @Test
    public void testEncryptString() throws Exception {
        int mode = 2113;    //EncryptionMode.AES256_01_HEX_UNICODE
        String strSource = "陈明建1234abcd";
        String strTarget = AESEncryption.encryptString(strSource, mode);
        System.out.println(strTarget);
        strTarget = AESEncryption.decryptString(strTarget, mode);
        System.out.println(strTarget);
        Assert.assertEquals(strSource, strTarget);
    }
}
