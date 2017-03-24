package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.LanguageBody;
import com.netinfo.emp.core.db.entity.LanguageBodyPK;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/24.
 */
@RepositoryRestResource(path = "lang_infos",
        collectionResourceRel = "lang_infos",
        itemResourceRel = "lang_info")
public interface LanguageBodyRepository extends JpaRepository<LanguageBody, LanguageBodyPK> {
    List<LanguageBody> findByLanguageId(short langId, Sort sort);

    List<LanguageBody> findByLanguageIdAndModuleNumber(short langId, short moduleNumber,Sort sort);

    List<LanguageBody> findByLanguageIdAndInPage(short langId, String pageName,Sort sort);
}
