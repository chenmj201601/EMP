package com.netinfo.emp.core.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.netinfo.emp.EmpProperties;
import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.utils.WebHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.interceptor
 * <p>
 * Created by Charley on 2017/3/23.
 */
@Component
public class ApiCheckInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(ApiCheckInterceptor.class);

    @Autowired
    private EmpProperties empProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (empProperties == null) {
            return super.preHandle(request, response, handler);
        }
        if (!empProperties.isCheckApi()) {
            return super.preHandle(request, response, handler);
        }
        WebReturn webReturn = new WebReturn();
        //解析出请求参数列表
        Map<String, String[]> params = request.getParameterMap();
        Map<String, String> fixedParams = new HashMap<>();
        Set<String> names = params.keySet();
        for (String name : names) {
            StringBuilder sb = new StringBuilder();
            String[] values = params.get(name);
            if (values != null) {
                for (String value : values) {
                    sb.append(String.format("%s;", value));
                }
            }
            String strValue = sb.toString();
            if (strValue.length() > 0) {
                strValue = strValue.substring(0, strValue.length() - 1);
            }
            logger.info(String.format("name:%s value:%s", name, strValue));
            fixedParams.put(name, strValue);
        }
        String apiId = request.getRequestURI();
        logger.info(String.format("RequestUri:%s", apiId));
        String userToken = fixedParams.get(Defines.FIELD_USER_TOKEN);
        String requestToken = fixedParams.get(Defines.FIELD_REQUEST_TOKEN);
        String timestamp = fixedParams.get(Defines.FIELD_TIMESTAMP);
        //验证请求参数
        if (apiId == null
                || requestToken == null
                || timestamp == null) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_PARAM_INVALID);
            webReturn.setMsg(String.format("Request path or request token or timestamp is null."));
            logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            writeErrorResponse(response, webReturn);
            return false;
        }
        if (userToken == null) {
            userToken = "";
        }
        List<String> requests = new ArrayList<>();
        requests.add(apiId);
        requests.add(userToken);
        requests.add(requestToken);
        requests.add(timestamp);
        fixedParams.remove(Defines.FIELD_REQUEST_PATH);
        fixedParams.remove(Defines.FIELD_USER_TOKEN);
        fixedParams.remove(Defines.FIELD_REQUEST_TOKEN);
        fixedParams.remove(Defines.FIELD_TIMESTAMP);
        webReturn = WebHelper.checkRequestToken(requests, fixedParams);
        if (!webReturn.isResult()) {
            logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            writeErrorResponse(response, webReturn);
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    private void writeErrorResponse(HttpServletResponse response, WebReturn error) throws IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        String str = mapper.writeValueAsString(error);
        PrintWriter writer = response.getWriter();
        writer.print(str);
        writer.flush();
        writer.close();
    }
}
