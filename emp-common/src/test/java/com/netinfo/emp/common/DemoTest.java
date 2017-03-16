package com.netinfo.emp.common;

import org.junit.Test;

import java.util.Random;

/**
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/10.
 */
public class DemoTest {
    @Test
    public void testDemo() {
        String strChar = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            int index = random.nextInt(strChar.length());
            sb.append(strChar.charAt(index));
        }
        System.out.println(sb.toString());
    }
}
