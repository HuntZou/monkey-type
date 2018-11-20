package com.hunt.monkeytype.pi;

import org.junit.Test;

public class CalcPiTest {

    @Test
    public void mainCalc() {
        for (int d = 1; d < 100; d++) {
            System.out.println(CalcPi.getNthUnicode(d));
        }
    }

    @Test
    public void t2() {
        String cnStr = "\ufeff\u4e2d\u56fd\u4eba";
        System.out.println(cnStr);
    }
}