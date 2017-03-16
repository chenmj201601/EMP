package com.netinfo.emp.web.controller;

import com.netinfo.emp.web.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.controller
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    private static String VIEW_INDEX = "index";

    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public String hello(Model model) {
        indexService.addCount();
        Integer count = indexService.getCount();
        model.addAttribute("count", count);
        return VIEW_INDEX;
    }

    @RequestMapping("/gen")
    @ResponseBody
    public String genUserID() throws Exception {
        return indexService.genUserId();
    }
}
