package com.netinfo.emp;

import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.service.LoginService;
import com.netinfo.emp.encryptions.AESEncryption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Project emp-core
 * Package com.netinfo.emp
 * <p>
 * Created by Charley on 2017/3/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLogin() throws Exception {
        String account = "charley";
        String password = AESEncryption.encryptString("123456", EncryptionMode.AES256_01_HEX_UNICODE);
        String host = "testmachine";
        String ip = "172.16.10.71";
        WebReturn webReturn = loginService.login(account, password, host, ip);
        if (!webReturn.isResult()) {
            System.out.println(String.format("Login fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
        }
        //Assert.assertEquals(webReturn.isResult(), true);
    }
}
