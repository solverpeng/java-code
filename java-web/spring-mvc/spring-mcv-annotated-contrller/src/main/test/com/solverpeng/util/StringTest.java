package com.solverpeng.util;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class StringTest {
    @Test
    public void test() {
        String[] strings = StringUtils.tokenizeToStringArray("1,2,3,4,5", ",");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
