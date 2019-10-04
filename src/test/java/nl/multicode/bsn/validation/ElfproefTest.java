package nl.multicode.bsn.validation;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ElfproefTest {
    private Elfproef elfProef;

    @Test
    public void multipliers() {
        elfProef = createElfproefImpl(new int[]{1, 2});
        assertTrue(elfProef.isElfproef("15"));
        assertFalse(elfProef.isElfproef("16"));
    }

    private Elfproef createElfproefImpl(int[] multipliers) {
        return new Elfproef() {
            @Override
            public boolean isElfproef(String nummer) {
                return isElfProef(nummer, multipliers);
            }
        };
    }
}
