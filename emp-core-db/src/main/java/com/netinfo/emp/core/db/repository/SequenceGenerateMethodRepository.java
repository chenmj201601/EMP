package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.SequenceGenerateMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/22.
 */
@RepositoryRestResource(path = "seq_gen_method",
        collectionResourceRel = "methods",
        itemResourceRel = "method")
public interface SequenceGenerateMethodRepository extends JpaRepository<SequenceGenerateMethod, Integer> {
}
