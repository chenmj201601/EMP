package com.netinfo.emp.core.dao;

import com.netinfo.emp.core.entity.SID;
import com.netinfo.emp.core.entity.SIDPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.dao
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Repository
public interface SIDRepository extends JpaRepository<SID, SIDPK> {
    SID findOneByResourceAndMiddle(int resource, int middle);
}
