package com.tran.increase.basics.base.util;

import org.springframework.stereotype.Component;

/**
 * @author luxiangqian
 * 2022/2/18
 */
@Component
public class BaseCharUtil {

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == 65279 || c == 8234 || c == 0;
    }

}
