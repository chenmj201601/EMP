package com.netinfo.emp.core.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.dao.LangInfoTableRepository;
import com.netinfo.emp.core.entity.LangInfo;
import com.netinfo.emp.core.entity.LangInfoTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/14.
 */
@Service
public class LangInfoService {
    @Autowired
    private LangInfoTableRepository langInfoTableRepository;

    public WebReturn query(short langId) {
        WebReturn webReturn = new WebReturn();
        webReturn.setResult(true);
        webReturn.setCode(0);
        webReturn.setMsg("");
        List<LangInfoTable> langInfoTables = langInfoTableRepository.findByC001(langId, new Sort(Sort.Direction.ASC, "c001", "c002"));
        List<LangInfo> langInfos = new ArrayList<>();
        for (LangInfoTable langInfoTable : langInfoTables) {
            LangInfo langInfo = langInfoTable.ofLangInfo();
            langInfos.add(langInfo);
        }
        webReturn.setData(langInfos);
        return webReturn;
    }

    public WebReturn query(short langId, String page) {
        WebReturn webReturn = new WebReturn();
        webReturn.setResult(true);
        webReturn.setCode(0);
        webReturn.setMsg("");
        List<LangInfoTable> langInfoTables = langInfoTableRepository.findByC001AndC007(langId, page, new Sort(Sort.Direction.ASC, "c001", "c002"));
        List<LangInfo> langInfos = new ArrayList<>();
        for (LangInfoTable langInfoTable : langInfoTables) {
            LangInfo langInfo = langInfoTable.ofLangInfo();
            langInfos.add(langInfo);
        }
        webReturn.setData(langInfos);
        return webReturn;
    }
}
