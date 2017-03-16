package com.netinfo.emp;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.utils.WebHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project emp-utils
 * Package com.netinfo.emp
 * <p>
 * Created by Charley on 2017/3/10.
 */
public class WebHelperTest {
    @Test
    public void testRequestToken() throws Exception {
        int module = Defines.MODULE_CORE;
        int controller = 1001;
        int sub = 1;
        String apiId = String.format("%02d%04d%02d", module, controller, sub);
        String userToken = "abc";
        Long timestamp = System.currentTimeMillis();
        String strTimestamp = timestamp.toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("param_01", "aaa");
        map.put("param_02", "bbb");
        String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, map);
        System.out.println(requestToken);
        List<String> listRequest = new ArrayList<String>();
        listRequest.add(apiId);
        listRequest.add(userToken);
        listRequest.add(requestToken);
        listRequest.add(strTimestamp);
        WebReturn webReturn = WebHelper.checkRequestToken(listRequest, map);
        if (!webReturn.isResult()) {
            System.out.println(String.format("Check fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
        }
        Assert.assertEquals(webReturn.isResult(), true);
    }
}
