package com.netinfo.emp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project emp-core-db
 * Package com.netinfo.emp
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Component
@ConfigurationProperties("emp")
public class EmpProperties {
    private boolean checkApi = true;

    public boolean isCheckApi() {
        return checkApi;
    }

    public void setCheckApi(boolean checkApi) {
        this.checkApi = checkApi;
    }
}
