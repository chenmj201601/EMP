package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.SupportLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/24.
 */
@RepositoryRestResource(path = "lang_types", collectionResourceRel = "lang_types",
        itemResourceRel = "lang_type")
public interface SupportLanguageRepository extends JpaRepository<SupportLanguage, Integer> {
}
