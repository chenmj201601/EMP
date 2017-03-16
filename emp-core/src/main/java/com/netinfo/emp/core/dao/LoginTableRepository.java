package com.netinfo.emp.core.dao;

import com.netinfo.emp.core.entity.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.dao
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Repository
public interface LoginTableRepository extends JpaRepository<LoginTable, Long> {
    List<LoginTable> findByC004(long userId);
}
