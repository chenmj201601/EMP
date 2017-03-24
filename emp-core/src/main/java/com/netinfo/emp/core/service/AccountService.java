package com.netinfo.emp.core.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.entity.Account;
import com.netinfo.emp.core.feign.CoreDbClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/24.
 */
@Service
public class AccountService {
    private static Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private CoreDbClient coreDbClient;

    public Account queryAccount(String account) {
        WebReturn webReturn = coreDbClient.accountBasicQueryAccount(account);
        if (!webReturn.isResult()) {
            logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            return null;
        }
        Map<String, Object> data = (Map<String, Object>) webReturn.getData();
        if (data == null) {
            logger.error(String.format("Fail. WebReturn data is null."));
            return null;
        }
        return Account.fromT(data);
    }
}
