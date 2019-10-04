package nl.multicode.bsn.validation;

import java.util.concurrent.atomic.AtomicInteger;

public interface Elfproef {

    boolean isElfproef(String nummer);

    default boolean isElfProef(String bsn, int[] multipliers) {
        int[] digits = getDigits(bsn);
        final int uitkomst = 0;
        AtomicInteger sum = new AtomicInteger(0);
        for (int i = 0; i < multipliers.length; i++) {
            sum.addAndGet(digits[i] * multipliers[i]);
        }
        return sum.get() % 11 == uitkomst;
    }

    default int[] getDigits(String number) {
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.toCharArray()[i]);
        }
        return digits;
    }
}