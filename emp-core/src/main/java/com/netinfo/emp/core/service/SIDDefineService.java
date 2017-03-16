package com.netinfo.emp.core.service;

import com.netinfo.emp.core.dao.SIDDefineRepository;
import com.netinfo.emp.core.entity.SIDDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Service
public class SIDDefineService {
    @Autowired
    private SIDDefineRepository sidDefineRepository;

    public List<SIDDefine> all() {
        return sidDefineRepository.findAll();
    }

    public SIDDefine findOne(int resource) {
        return sidDefineRepository.findOne(resource);
    }
}
