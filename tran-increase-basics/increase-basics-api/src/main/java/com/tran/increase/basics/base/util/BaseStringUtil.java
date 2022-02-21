package com.tran.increase.basics.base.util;

import org.springframework.stereotype.Component;

/**
 * String 工具类
 * @author luxiangqian
 * 2022/2/18
 */
@Component
public class BaseStringUtil {

    /**
     * 字符串是否为 NULL
     * @param str
     * @return
     */
    public static boolean isNotBlank(CharSequence str){
        return !isBlank(str);
    }


    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for(int i = 0; i < length; ++i) {
                if (!BaseCharUtil.isBlankChar(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }




}
