package com.solverpeng.gc;

import java.util.ArrayList;
import java.util.List;

public class CMSTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 60000000; i++) {
            strings.add("test cms");
        }

        try {
            Thread.sleep(1000000000);
            Thread.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
