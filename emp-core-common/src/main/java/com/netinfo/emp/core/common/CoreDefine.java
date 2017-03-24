package com.netinfo.emp.core.common;

/**
 * Project emp-core-common
 * Package com.netinfo.emp.core.common
 * <p>
 * Created by Charley on 2017/3/24.
 */
public class CoreDefine {

    //<editor-fold desc="字段名称定义">

    public static final String FIELD_SEQ_ID = "sequence_id";
    public static final String FIELD_INTR_VALUE = "intermediate_value";
    public static final String FIELD_ACCOUNT = "account";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_HOST = "host";
    public static final String FIELD_IP = "ip";
    public static final String FIELD_LANG_ID = "lang_id";
    public static final String FIELD_PAGE_NAME = "page_name";

    //</editor-fold>

    //<editor-fold desc="路径名称定义">

    public static final String PATH_SEQUENCES = "sequences";
    public static final String PATH_GEN = "gen";
    public static final String PATH_LOGINS = "logins";
    public static final String PATH_LOGIN = "login";
    public static final String PATH_LANGUAGES = "languages";

    //</editor-fold>

    //<editor-fold desc="登录返回码">

    /**
     * 用户不存在
     */
    public static final int RET_USER_NOT_EXIST = 1001;
    /**
     * 密码错误
     */
    public static final int RET_PASSWORD_ERROR = 1002;
    /**
     * 用户已经登录
     */
    public static final int RET_ALREADY_LOGINED = 1003;
    /**
     * 生成流水号失败
     */
    public static final int RET_GEN_ID_FAIL = 1004;

    //</editor-fold>
}
