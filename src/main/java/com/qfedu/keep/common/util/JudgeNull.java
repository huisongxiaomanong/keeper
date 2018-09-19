package com.qfedu.keep.common.util;

import java.util.Objects;

public class JudgeNull {
    public static boolean isNull(Object... name) {
        boolean result = false;
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
            if (Objects.equals(name[i], null) || (Objects.equals(name[i], ""))){
                result = true;
                break;
            }
        }
        return result;
    }
}
