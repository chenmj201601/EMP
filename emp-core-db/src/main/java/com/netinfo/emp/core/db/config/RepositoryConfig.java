package com.netinfo.emp.core.db.config;

import com.netinfo.emp.core.db.entity.AccountBasic;
import com.netinfo.emp.core.db.entity.SequenceGenerateDetail;
import com.netinfo.emp.core.db.entity.SequenceGenerateMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.config
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(SequenceGenerateMethod.class);
        config.exposeIdsFor(SequenceGenerateDetail.class);
        config.exposeIdsFor(AccountBasic.class);
    }
}
