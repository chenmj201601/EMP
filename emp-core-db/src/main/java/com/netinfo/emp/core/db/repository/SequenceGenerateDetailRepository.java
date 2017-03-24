package com.netinfo.emp.core.db.repository;

import com.netinfo.emp.core.db.entity.SequenceGenerateDetail;
import com.netinfo.emp.core.db.entity.SequenceGenerateDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.repository
 * <p>
 * Created by Charley on 2017/3/22.
 */
@RepositoryRestResource(path = "seq_gen_detail",
        collectionResourceRel = "sequences",
        itemResourceRel = "sequence")
public interface SequenceGenerateDetailRepository extends JpaRepository<SequenceGenerateDetail, SequenceGenerateDetailPK> {
    SequenceGenerateDetail findOneBySequenceIdAndIntermediateValue(int sequenceId, int intermediateValue);
}
