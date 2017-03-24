package com.netinfo.emp.web.feign;

import com.netinfo.emp.common.WebReturn;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.feign
 * <p>
 * Created by Charley on 2017/3/10.
 */
@FeignClient("EMP-CORE")
public interface CoreClient {
    @RequestMapping(value = "/sequences/gen", method = RequestMethod.GET)
    WebReturn sidGen(@RequestParam(value = "user_token",required = false,defaultValue = "") String userToken,
                     @RequestParam(value = "request_token",required = false,defaultValue = "") String requestToken,
                     @RequestParam(value = "timestamp",required = false,defaultValue = "") String timestamp,
                     @RequestParam(value = "sequence_id") String sequenceId,
                     @RequestParam(value = "intermediate_value") String intermediateValue);

    /* @RequestMapping(value = "/languages", method = RequestMethod.GET)
     WebReturn langQuery(@RequestParam("user_token") String userToken,
                         @RequestParam("request_token") String requestToken,
                         @RequestParam("timestamp") String timestamp,
                         @RequestParam("lang_id") String langId,
                         @RequestParam(value = "module_number", required = false, defaultValue = "-1") String moduleNumber,
                         @RequestParam(value = "page_name", required = false, defaultValue = "") String pageName);*/
    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    WebReturn langQuery(@RequestParam(value = "user_token",required = false,defaultValue = "") String userToken,
                        @RequestParam(value = "request_token",required = false,defaultValue = "") String requestToken,
                        @RequestParam(value = "timestamp",required = false,defaultValue = "") String timestamp,
                        @RequestParam("lang_id") String langId);

    @RequestMapping(value = "/logins", method = RequestMethod.POST)
    WebReturn login(@RequestParam(value = "request_token",required = false,defaultValue = "") String requestToken,
                    @RequestParam(value = "timestamp",required = false,defaultValue = "") String timestamp,
                    @RequestParam("account") String account,
                    @RequestParam("password") String password,
                    @RequestParam(value = "host", required = false, defaultValue = "") String host,
                    @RequestParam(value = "address", required = false, defaultValue = "") String ip);
}
