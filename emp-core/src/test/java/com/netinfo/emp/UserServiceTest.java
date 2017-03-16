package com.netinfo.emp;

import com.netinfo.emp.core.entity.User;
import com.netinfo.emp.core.service.UserService;
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
 * Created by Charley on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd() throws Exception {
        String account = "charley";
        String fullname = "Charley Chen";
        String password = "123";
        User user = userService.add(account, fullname, password);
        if (user != null) {
            String strId = user.getId().toString();
            System.out.println(String.format("UserId:%s", strId));
        }
        //Assert.assertNotNull(user);
    }
}
