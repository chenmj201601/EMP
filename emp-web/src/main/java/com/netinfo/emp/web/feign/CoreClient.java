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
    @RequestMapping(value = "/sids/gen", method = RequestMethod.GET)
    WebReturn sidGen(@RequestParam("user_token") String userToken,
                     @RequestParam("request_token") String requestToken,
                     @RequestParam("timestamp") String timestamp,
                     @RequestParam("resource") String resource,
                     @RequestParam("middle") String middle);

    @RequestMapping(value = "/langs", method = RequestMethod.GET)
    WebReturn langQuery(@RequestParam("user_token") String userToken,
                        @RequestParam("request_token") String requestToken,
                        @RequestParam("timestamp") String timestamp,
                        @RequestParam("lang_id") String langId,
                        @RequestParam("page") String page);

    @RequestMapping(value = "/logins/login", method = RequestMethod.POST)
    WebReturn login(@RequestParam("request_token") String requestToken,
                    @RequestParam("timestamp") String timestamp,
                    @RequestParam("account") String account,
                    @RequestParam("password") String password,
                    @RequestParam("host") String host,
                    @RequestParam("ip") String ip);
}
