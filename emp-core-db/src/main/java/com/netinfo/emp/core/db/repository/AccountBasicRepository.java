package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.AccountBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/23.
 */
@RepositoryRestResource(path = "users",
        collectionResourceRel = "users",
        itemResourceRel = "user")
public interface AccountBasicRepository extends JpaRepository<AccountBasic, Long> {
    AccountBasic findOneByLoginCode(String loginCode);
}
