package com.netinfo.emp.core.service;

import com.netinfo.emp.core.dao.SIDRepository;
import com.netinfo.emp.core.entity.SID;
import com.netinfo.emp.core.entity.SIDDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Service
public class SIDService {
    private static final Logger log = LoggerFactory.getLogger(SIDService.class);

    @Autowired
    private SIDRepository sidRepository;
    @Autowired
    private SIDDefineService sidDefineService;

    /**
     * 获取所有流水号定义规则
     *
     * @return 规则列表
     */
    public List<SID> all() {
        return sidRepository.findAll(new Sort(Sort.Direction.ASC, "resource", "middle", "current"));
    }

    /**
     * 生成流水号
     *
     * @param resource 资源编号
     * @param middle   中间变量
     * @return 流水号（19位）
     * @throws ParseException
     */
    public String gen(int resource, String middle) throws ParseException {
        if (resource < 100 || resource > 999) {
            log.error(String.format("Resource invalid. %d", resource));
            return "";
        }
        SIDDefine sidDefine = sidDefineService.findOne(resource);
        if (sidDefine == null) {
            log.error(String.format("SIDDefine not exist. %d", resource));
            return "";
        }
        int type = sidDefine.getType();
        int intMiddle;
        LocalDateTime local = LocalDateTime.now();
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyMMdd00");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyMMddHH");
        switch (type) {
            case 100:
                intMiddle = Integer.parseInt("17010100");
                break;
            case 101:
                intMiddle = Integer.parseInt(local.format(formatter1));
                break;
            case 102:
                intMiddle = Integer.parseInt(local.format(formatter2));
                break;
            case 201:
                intMiddle = Integer.parseInt(utc.format(formatter1));
                break;
            case 202:
                intMiddle = Integer.parseInt(utc.format(formatter2));
                break;
            case 301:
                intMiddle = Integer.parseInt(middle);
                break;
            case 302:
                intMiddle = Integer.parseInt(middle);
                break;
            default:
                log.error(String.format("SIDDefine type invalid. %d", type));
                return "";
        }
        SID sid = sidRepository.findOneByResourceAndMiddle(resource, intMiddle);
        Long current = 1L;
        Date lastTime = new Date();
        if (sid == null) {
            sid = new SID();
            sid.setResource(resource);
            sid.setMiddle(intMiddle);
            sid.setCurrent(current);
            sid.setLastTime(lastTime);
        } else {
            current = sid.getCurrent();
            current++;
            sid.setCurrent(current);
            sid.setLastTime(lastTime);
        }
        sidRepository.save(sid);
        String strId = String.format("%03d%08d%08d", resource, intMiddle, current);
        log.info(String.format("Generate ID %s", strId));
        return strId;
    }
}
