package com.netinfo.emp.encryptions;

import org.junit.Test;

/**
 * Project emp-encryption
 * Package com.netinfo.emp.encryptions
 * <p>
 * Created by Charley on 2017/3/2.
 */
public class SHAEncryptionTest {
    @Test
    public void testEncryptString() throws Exception {
        int mode = 4013;    //EncryptionMode.SHA512_00_HEX_UNICODE
        String strSource = "abc";
        System.out.println(strSource);
        String strTarget = SHAEncryption.encryptString(strSource, mode);
        System.out.println(strTarget);
    }
}
