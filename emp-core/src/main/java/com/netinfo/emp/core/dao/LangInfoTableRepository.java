package com.netinfo.emp.core.dao;

import com.netinfo.emp.core.entity.LangInfoTable;
import com.netinfo.emp.core.entity.LangInfoTablePK;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.dao
 * <p>
 * Created by Charley on 2017/3/14.
 */
@Repository
public interface LangInfoTableRepository extends JpaRepository<LangInfoTable, LangInfoTablePK> {
    List<LangInfoTable> findByC001(short c001);

    List<LangInfoTable> findByC001(short c001, Sort sort);

    List<LangInfoTable> findByC001AndC007(short c001, String c007);

    List<LangInfoTable> findByC001AndC007(short c001, String c007, Sort sort);
}
