package com.netinfo.emp.core.service;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.core.dao.UserTableRepository;
import com.netinfo.emp.core.entity.User;
import com.netinfo.emp.core.entity.UserTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserTableRepository userTableRepository;
    @Autowired
    private SIDService sidService;

    public User findByAccount(String account) throws Exception {
        List<UserTable> userTables = userTableRepository.findAll();
        for (UserTable userTable : userTables) {
            User user = userTable.ofUser();
            if (user.getAccount().toLowerCase().equals(account.toLowerCase())) {
                return user;
            }
        }
        return null;
    }

    public User add(String account, String fullname, String password) throws Exception {
        User user = findByAccount(account);
        if (user != null) {
            log.error(String.format("Account already exist %s", account));
            return null;
        }
        String strId = sidService.gen(Defines.RESOURCE_USER, "");
        if ("".equals(strId)) {
            log.error(String.format("Gen id fail."));
            return null;
        }
        Long id = Long.parseLong(strId);
        UserTable userTable = userTableRepository.findOne(id);
        if (userTable != null) {
            log.error(String.format("Id already exist %d", id));
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        user = new User();
        user.setId(id);
        user.setType((short) 0);
        user.setMaster(0L);
        user.setAccount(account);
        user.setFullname(fullname);
        user.setOriginalPassword(password);
        user.setOrgId(0L);
        user.setSourceType("U");
        user.setLock("N");
        user.setLockTime(format.parse("19000101000000"));
        user.setActive("1");
        user.setDelete("0");
        user.setEnableFrom(format.parse("19000101000000"));
        user.setEnableTo(format.parse("21991231235959"));
        user.setCreator(1050000000000000001L);
        Date now = new Date();
        user.setCreateTime(now);
        userTable = UserTable.fromUser(user);
        userTableRepository.save(userTable);
        log.info(String.format("Add user successful Id:%d;Account:%s;FullName:%s;Password:%s", id, account, fullname, password));
        return user;
    }
}
