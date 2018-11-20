package com.hunt.monkeytype.pi;

import java.math.BigDecimal;

public class CalcPi {
    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final BigDecimal TWO = new BigDecimal(2);
    private static final BigDecimal FOUR = new BigDecimal(4);
    private static final BigDecimal FIVE = new BigDecimal(5);
    private static final BigDecimal SIX = new BigDecimal(6);
    private static final BigDecimal EIGHT = new BigDecimal(8);
    private static final BigDecimal SIXTEEN = new BigDecimal(16);

    /**
     * NOTE: k start at 1,that`s means if k=1,it calc the first decimal(like 2) for PI(16)
     */
    public static String getNthUnicode(int k) {
        StringBuilder result = new StringBuilder("\\u");
        for (int i = 4 * (k - 1); i < 4 * (k - 1) + 4; i++) {
            result.append(getNthOfPiHex(i));
        }
        return result.toString();
    }


    public static String getNthOfPiHex(int n) {
        String hexString = Integer.toHexString(getNthOfPi(n));
        return hexString;
    }

    public static int getNthOfPi(int n) {
        return calc16dPI(n).multiply(SIXTEEN).intValue();
    }

    private static BigDecimal calc16dPI(int d) {
        return FOUR.multiply(calc16dSj(d, 1)).add(BigDecimal.valueOf(3)).subtract(TWO.multiply(calc16dSj(d, 4)).divideAndRemainder(ONE)[1]).subtract(calc16dSj(d, 5).divideAndRemainder(ONE)[1]).subtract(calc16dSj(d, 6).divideAndRemainder(ONE)[1]).divideAndRemainder(ONE)[1];
    }

    private static BigDecimal calc16dSj(int d, int j) {
        int ACCURACY = d + 10;
        BigDecimal part1 = BigDecimal.ZERO;
        BigDecimal part2 = BigDecimal.ZERO;
        for (int k = 0; k <= d; k++) {
            part1 = part1.add(SIXTEEN.pow(d - k).divideAndRemainder(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j)))[1].divide(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j)), ACCURACY, BigDecimal.ROUND_HALF_UP));
        }

        for (int k = d + 1; k < ACCURACY; k++) {
            part2 = part2.add(ONE.divide(SIXTEEN.pow(k - d).multiply(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j))), ACCURACY, BigDecimal.ROUND_HALF_UP));
        }

        return part1.add(part2);
    }
}
