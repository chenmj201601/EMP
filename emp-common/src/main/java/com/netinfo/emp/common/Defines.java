package com.netinfo.emp.common;

/**
 * 公共常量定义
 * <p>
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/8.
 */
public final class Defines {

    //<editor-fold defaultstate="collapsed" desc="Return Code 返回码">

    //<editor-fold desc="基本操作结果">
    /**
     * 成功
     */
    public static final int RET_SUCCESS = 0;
    /**
     * 失败
     */
    public static final int RET_FAIL = 1;
    //</editor-fold>

    //<editor-fold desc="一般操作结果">
    /**
     * 参数无效
     */
    public static final int RET_PARAM_INVALID = 101;
    /**
     * 指定的对象不存在
     */
    public static final int RET_NOT_EXIST = 102;
    /**
     * 处理超时
     */
    public static final int RET_TIMEOUT = 103;
    /**
     * 指定的对象为空
     */
    public static final int RET_OBJECT_NULL = 104;
    /**
     * 字符串为空
     */
    public static final int RET_STRING_EMPTY = 105;
    /**
     * 方法未实现
     */
    public static final int RET_NOT_IMPLIMENT = 106;
    /**
     * 对象已经存在
     */
    public static final int RET_ALREADY_EXIST = 107;
    /**
     * 资源正在被占用
     */
    public static final int RET_IN_USE = 108;
    /**
     * 取消操作
     */
    public static final int RET_CANCEL = 109;
    //</editor-fold>

    //<editor-fold desc="网络相关">
    /**
     * 连接成功
     */
    public static final int RET_CONNECT_SUCCESS = 201;
    /**
     * 连接失败
     */
    public static final int RET_CONNECT_FAIL = 202;
    /**
     * 未连接
     */
    public static final int RET_NOT_CONNECTED = 203;
    /**
     * 认证成功
     */
    public static final int RET_AUTH_SUCCESS = 204;
    /**
     * 认证失败
     */
    public static final int RET_AUTH_FAIL = 205;
    /**
     * 未认证
     */
    public static final int RET_NOT_AUTHENTICATED = 206;
    //</editor-fold>

    //<editor-fold desc="文件相关">
    /**
     * 文件不存在
     */
    public static final int RET_FILE_NOT_EXIST = 301;
    /**
     * 配置文件不存在
     */
    public static final int RET_CONFIG_NOT_EXIST = 302;
    /**
     * 配置无效
     */
    public static final int RET_CONFIG_INVALID = 303;
    /**
     * 文件或文件夹路径相同
     */
    public static final int RET_EQUAL_PATH = 304;
    /**
     * 文件已经存在
     */
    public static final int RET_FILE_ALREADY_EXIST = 305;
    /**
     * XML 节点不存在
     */
    public static final int RET_XML_NODE_NOT_EXIST = 321;
    /**
     * XML 元素不存在
     */
    public static final int RET_XML_ELE_NOT_EXIST = 322;
    //</editor-fold>

    //<editor-fold desc="数据库相关">
    /**
     * 数据库访问失败
     */
    public static final int RET_DBACCESS_FAIL = 401;
    /**
     * 记录已经存在
     */
    public static final int RET_DBACCESS_EXIST = 402;
    /**
     * 记录不存在
     */
    public static final int RET_DBACCESS_NOT_EXIST = 403;
    /**
     * 表不存在
     */
    public static final int RET_DBACCESS_TABLE_NOT_EXIST = 404;
    //</editor-fold>

    //<editor-fold desc="验证相关">
    /**
     * 用户不存在
     */
    public static final int RET_CHECK_USER_NOT_EXIST = 501;
    /**
     * 密码错误
     */
    public static final int RET_CHECK_PASSWORD_ERROR = 502;
    /**
     * 用户过期
     */
    public static final int RET_CHECK_EXPIRED = 503;
    /**
     * 用户已经登录
     */
    public static final int RET_CHECK_ALREADY_LOGINED = 504;
    /**
     * 验证失败
     */
    public static final int RET_CHECK_FAIL = 505;
    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Event Code 事件代码">

    //<editor-fold desc="基本事件">
    /**
     * 通用事件
     */
    public static final int EVT_COMMON = 0;
    /**
     * 发生异常
     */
    public static final int EVT_EXCEPTION = 1;
    //</editor-fold>

    //<editor-fold desc="一般事件">
    /**
     * 通知
     */
    public static final int EVT_NOTIFY = 10;
    /**
     * 操作完成
     */
    public static final int EVT_COMPLETED = 11;
    //</editor-fold>

    //<editor-fold desc="网络相关">
    /**
     * 连接成功
     */
    public static final int EVT_NET_CONNECTED = 101;
    /**
     * 失去连接
     */
    public static final int EVT_NET_DISCONNECTED = 102;
    /**
     * 认证成功
     */
    public static final int EVT_NET_AUTHED = 103;
    /**
     * 欢迎,通常连接建立成功,服务端会发送欢迎消息
     */
    public static final int EVT_NET_WELCOME = 104;
    /**
     * 心跳
     */
    public static final int EVT_NET_HEARTBEAT = 106;
    //</editor-fold>

    //<editor-fold desc="页面或控件相关">
    /**
     * 加载完成
     */
    public static final int EVT_PAGE_LOADED = 201;
    /**
     * 卸载完成
     */
    public static final int EVT_PAGE_UNLOADED = 202;
    /**
     * 正在加载
     */
    public static final int EVT_PAGE_LOADING = 203;
    /**
     * 正在卸载
     */
    public static final int EVT_PAGE_UNLOADING = 204;
    /**
     * 正在关闭
     */
    public static final int EVT_PAGE_CLOSING = 205;
    /**
     * 已经关闭
     */
    public static final int EVT_PAGE_CLOSED = 206;
    //</editor-fold>

    //</editor-fold>

    //<editor-fold desc="通用字段名称定义">

    /**
     * 结果，可用于web请求的返回对象中，表示服务端操作是否成功
     */
    public static final String FIELD_RESULT = "result";
    /**
     * 返回码，操作返回值，0 表示成功无错误
     */
    public static final String FIELD_CODE = "code";
    /**
     * 返回消息，如果返回码大于 0 ，msg 是错误的消息内容
     */
    public static final String FIELD_MSG = "msg";
    /**
     * 数据，通常是一个 JSON 串
     */
    public static final String FIELD_DATA = "data";

    /**
     * API 接口编号，在 API 接口表中定义，共 8 位 数字编号
     * 规则：模块编号（2位）+ 控制器编号（4位）+ 方法编号（2位）
     */
    public static final String FIELD_REQUEST_PATH = "request_path";
    /**
     * 登录用户的 Token，用户成功登录后，由登录服务生成，并发给客户端保留
     * 规则：SHA256(user_id + login_timestamp + login_key)
     */
    public static final String FIELD_USER_TOKEN = "user_token";
    /**
     * 请求的校验码 Token，每次请求此 Token 都不一样，
     * 规则 SHA256(api_id+user_token+timestamp+param01+param02...+request_key)
     */
    public static final String FIELD_REQUEST_TOKEN = "request_token";
    /**
     * 时间戳，每个请求都带有一个时间戳参数，可以验证请求是否超时
     */
    public static final String FIELD_TIMESTAMP = "timestamp";

    //</editor-fold>

    //<editor-fold desc="密钥定义">

    /**
     * Web 请求哈希计算中使用的密钥，用于计算 RequestToken
     */
    public static final String REQUEST_KEY = "dnks&h7r@k&6zo8hd1v91*$e858pv6xs";
    /**
     * 用户登录哈希计算中使用的密钥，用于计算 UserToken
     */
    public static final String LOGIN_KEY = "v5&c)4u6k!a5&9ny)xh87#6&j)j(y0@a";

    //</editor-fold>

    //<editor-fold desc="模块定义">

    /**
     * 基础模块，Restful API 服务
     * <p>
     * 用户登录，身份验证
     * <p>
     * 角色权限，机构用户，基本资源处理
     */
    public static final int MODULE_CORE = 11;

    //</editor-fold>

    //<editor-fold desc="超时时间定义">
    /**
     * 请求超时时间，单位：秒，默认 5 分钟
     */
    public static int TIMEOUT_REQUEST = 60 * 5;
    //</editor-fold>

    //<editor-fold desc="资源编号定义">

    /**
     * 租户
     */
    public static final int RESOURCE_TENANT = 101;
    /**
     * 功能操作
     */
    public static final int RESOURCE_OPT = 102;
    /**
     * 角色
     */
    public static final int RESOURCE_ROLE = 103;
    /**
     * 机构部门
     */
    public static final int RESOURCE_ORG = 104;
    /**
     * 用户
     */
    public static final int RESOURCE_USER = 105;

    /**
     * 登录流水
     */
    public static final int RESOURCE_LOGIN = 801;
    /**
     * 操作日志
     */
    public static final int RESOURCE_OPT_LOG = 802;
    /**
     * 系统关键记录
     */
    public static final int RESOURCE_KEY_RECORD = 899;

    //</editor-fold>

}
