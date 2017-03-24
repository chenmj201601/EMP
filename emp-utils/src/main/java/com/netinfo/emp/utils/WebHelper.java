package com.netinfo.emp.utils;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.encryptions.SHAEncryption;

import java.util.*;

/**
 * Web 请求帮助类，可以验证请求是否有效
 * <p>
 * Project emp-utils
 * Package com.netinfo.emp.utils
 * <p>
 * Created by Charley on 2017/3/10.
 */
public class WebHelper {

    /**
     * 验证请求是否有效
     *
     * @param listRequest 请求信息列表，api_id, user_token, request_token, timestamp
     * @param listParam   参数列表
     * @return WebReturn 其中 Result 指示是否验证通过
     * @throws Exception 加解密异常
     */
    public static WebReturn checkRequestToken(List<String> listRequest,
                                              Map<String, String> listParam) throws Exception {
        WebReturn webReturn = new WebReturn();
        webReturn.setResult(true);
        webReturn.setCode(0);
        webReturn.setMsg("");
        StringBuilder sbMsg = new StringBuilder();      //调试使用
        if (listRequest.size() < 4) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_PARAM_INVALID);
            webReturn.setMsg(String.format("RequestInfo count invalid."));
            return webReturn;
        }
        String apiId = listRequest.get(0);
        String userToken = listRequest.get(1);
        String requestToken = listRequest.get(2);
        String timestamp = listRequest.get(3);
        sbMsg.append(apiId + ";");
        sbMsg.append(userToken + ";");
        sbMsg.append(requestToken + ";");
        sbMsg.append(timestamp + ";");

        //<editor-fold desc="判断请求是否超时，默认超过5分钟视为超时">
        long longTimestamp = Long.parseLong(timestamp);
        long now = System.currentTimeMillis();
        if ((now - longTimestamp) > 1000 * Defines.TIMEOUT_REQUEST) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_TIMEOUT);
            webReturn.setMsg(String.format("Request timeout"));
            //webReturn.setMsg(String.format("Request timeout %s", sbMsg.toString()));
            return webReturn;
        }
        //</editor-fold>

        //<editor-fold desc="验证 RequestToken 是否有效，与RequestToken的生成流程一样，生成RequestToken，然后与传入的RequestToken比较">
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s=%s", Defines.FIELD_REQUEST_PATH, apiId));
        sb.append(String.format("%s=%s", Defines.FIELD_USER_TOKEN, userToken));
        sb.append(String.format("%s=%s", Defines.FIELD_TIMESTAMP, timestamp));
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(listParam.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (String key : listParam.keySet()) {
            sb.append(String.format("%s=%s", key, listParam.get(key)));
        }
        sb.append(Defines.REQUEST_KEY);
        String strSource = sb.toString();
        sbMsg.append(strSource + ";");
        String _requestToken = SHAEncryption.encryptString(strSource, EncryptionMode.SHA256_00_HEX_ASCII);
        sbMsg.append(_requestToken + ";");
        if (!requestToken.equals(_requestToken)) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_CHECK_FAIL);
            webReturn.setMsg(String.format("Request token invalid"));
            //webReturn.setMsg(String.format("Request timeout %s", sbMsg.toString()));
            return webReturn;
        }
        //</editor-fold>

        //webReturn.setMsg(String.format("%s", sbMsg.toString()));
        return webReturn;
    }

    /**
     * 生成 RequestToken
     *
     * @param apiId     API 编号
     * @param userToken UserToken
     * @param timestamp Timestamp
     * @param listParam 参数列表
     * @return RequestToken
     * @throws Exception 加解密异常
     */
    public static String genRequestToken(String apiId, String userToken, String timestamp,
                                         Map<String, String> listParam) throws Exception {
        /**
         * RequestToken 生成流程如下：
         * 1、将 api_id user_token timestamp 以键值对的形式拼成一个字符串 str1；
         * 2、将参数列表按参数名排序
         * 3、将参数列表以键值对的形式拼成一个字符串str2；
         * 4、将 str1 和 str2 拼接得到 str3
         * 5、将 str3 和 REQUEST_KEY 拼接得到 str4
         * 6、对 str4 做 SHA512 加密得到 RequestToken
         */
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s=%s", Defines.FIELD_REQUEST_PATH, apiId));
        sb.append(String.format("%s=%s", Defines.FIELD_USER_TOKEN, userToken));
        sb.append(String.format("%s=%s", Defines.FIELD_TIMESTAMP, timestamp));
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(listParam.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (String key : listParam.keySet()) {
            sb.append(String.format("%s=%s", key, listParam.get(key)));
        }
        sb.append(Defines.REQUEST_KEY);
        String requestToken = SHAEncryption.encryptString(sb.toString(), EncryptionMode.SHA256_00_HEX_ASCII);
        return requestToken;
    }
}
