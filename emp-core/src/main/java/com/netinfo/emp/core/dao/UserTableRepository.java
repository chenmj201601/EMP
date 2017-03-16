package com.netinfo.emp.core.dao;

import com.netinfo.emp.core.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.dao
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Long> {
}
