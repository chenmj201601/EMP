package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.AccountBasic;
import com.netinfo.emp.core.db.repository.AccountBasicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.controller
 * <p>
 * Created by Charley on 2017/3/23.
 */
@RestController
@RequestMapping("/accounts")
public class AccountBasicController {
    private static Logger logger = LoggerFactory.getLogger(AccountBasicController.class);

    @Autowired
    private AccountBasicRepository accountBasicRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<AccountBasic> users = accountBasicRepository.findAll(new Sort(Sort.Direction.ASC, "loginCode"));
        int count = users.size();
        webReturn.setMsg(String.format("%d", count));
        webReturn.setData(users);
        return webReturn;
    }

    @RequestMapping(value = "/account/{account}", method = RequestMethod.GET)
    public WebReturn queryLoginCode(@PathVariable("account") String loginCode) {
        logger.info(String.format("Account:%s", loginCode));
        WebReturn webReturn = new WebReturn();
        AccountBasic user = accountBasicRepository.findOneByLoginCode(loginCode);
        webReturn.setData(user);
        return webReturn;
    }
}
