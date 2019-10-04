package nl.multicode.bsn.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BsnValidator implements ConstraintValidator<BsnConstraint, String>, Elfproef {
    private static final int[] BSN_ONDNR_MULTIPLIERS = {9, 8, 7, 6, 5, 4, 3, 2, -1};
    private static final String VALID_BSN_REGEX = "[0-9]{9}";

    @Override
    public void initialize(BsnConstraint bsn) {
    }

    @Override
    public boolean isValid(String bsn, ConstraintValidatorContext cxt) {
        return bsn != null && isElfproef(bsn);
    }

    @Override
    public boolean isElfproef(String bsn) {
        if (bsn.matches(VALID_BSN_REGEX)) {
            return isElfProef(bsn, BSN_ONDNR_MULTIPLIERS);
        }
        return false;
    }

}