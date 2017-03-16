package com.netinfo.emp.core.common;

/**
 * API 接口定义
 * <p>
 * Project emp-core-common
 * Package com.netinfo.emp.core.common
 * <p>
 * Created by Charley on 2017/3/11.
 */
public class ApiDefine {

    //<editor-fold desc="控制器编号定义">

    /**
     * 系统流水号
     */
    public static final Integer CTL_SID = 1001;
    /**
     * 登录
     */
    public static final Integer CTL_LOGIN = 1002;
    /**
     * 语言包
     */
    public static final Integer CTL_LANG_INFO = 1003;

    //</editor-fold>

    //<editor-fold desc="方法编号定义">

    /**
     * 获取所有流水号定义规则
     */
    public static final Integer FN_SID_ALL = 1;
    /**
     * 生成流水号
     */
    public static final Integer FN_SID_GEN = 2;

    /**
     * 登录
     */
    public static final Integer FN_LOGIN_LOGIN = 1;

    /**
     * 获取语言列表
     */
    public static final Integer FN_LANG_INFO_QUERY = 1;

    //</editor-fold>

    //<editor-fold desc="字段名称定义">

    public static final String FIELD_RESOURCE = "resource";
    public static final String FIELD_MIDDLE = "middle";
    public static final String FIELD_ACCOUNT = "account";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_HOST = "host";
    public static final String FIELD_IP = "ip";
    public static final String FIELD_LANG_ID = "lang_id";
    public static final String FIELD_PAGE = "page";

    //</editor-fold>

    //<editor-fold desc="路径名称定义">

    public static final String PATH_SIDS = "sids";
    public static final String PATH_GEN = "gen";
    public static final String PATH_LOGINS = "logins";
    public static final String PATH_LOGIN = "login";
    public static final String PATH_LANGS = "langs";

    //</editor-fold>

    //<editor-fold desc="登录返回码">

    /**
     * 用户不存在
     */
    public static final Integer RET_USER_NOT_EXIST = 1001;
    /**
     * 密码错误
     */
    public static final Integer RET_PASSWORD_ERROR = 1002;
    /**
     * 用户已经登录
     */
    public static final Integer RET_ALREADY_LOGINED = 1003;
    /**
     * 生成流水号失败
     */
    public static final Integer RET_GEN_ID_FAIL = 1004;

    //</editor-fold>
}
