package com.netinfo.emp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 下划线命名与驼峰命名转换
 * <p>
 * Project emp-utils
 * Package com.netinfo.emp.utils
 * <p>
 * Created by Charley on 2017/3/22.
 */
public class StringUtil {
    public static final char UNDERLINE = '_';

    /**
     * 驼峰命名方式转换成下划线命名
     *
     * @param param 驼峰命名
     * @return 下划线命名
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线命名转换成驼峰命名
     *
     * @param param 下划线命名
     * @return 驼峰命名
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }
}
