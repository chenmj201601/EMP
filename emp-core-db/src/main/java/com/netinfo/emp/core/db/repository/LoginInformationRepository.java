package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.LoginInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/23.
 */
@RepositoryRestResource(path = "logins",
        collectionResourceRel = "logins",
        itemResourceRel = "login")
public interface LoginInformationRepository extends JpaRepository<LoginInformation, Long> {
    List<LoginInformation> findByAccountId(Long accountId);
}
