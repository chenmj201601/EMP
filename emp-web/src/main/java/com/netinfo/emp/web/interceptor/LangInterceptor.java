package com.netinfo.emp.web.interceptor;

import com.netinfo.emp.web.WebDefine;
import com.netinfo.emp.web.service.LangService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.interceptor
 * <p>
 * Created by Charley on 2017/3/15.
 */
@Component
public class LangInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LangService langService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null){
            modelAndView.addObject(WebDefine.FIELD_LANGS, langService.getLangs(request));
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
