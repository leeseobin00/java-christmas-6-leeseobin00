package christmas.validator;

import christmas.exception.ErrorCode;

public class DateValidator {
    public static final int MIN_RANDOM_BOUND = 1;
    public static final int MAX_RANDOM_BOUND = 31;

    public static int validateDate(String input) {
        validateNullOrEmpty(input);

        int number = validateNumberType(input);
        validateNumberRange(number);

        return number;
    }

    private static void validateNullOrEmpty(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_DATE.getMessage());
        }
    }

    private static int validateNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_RANDOM_BOUND || number > MAX_RANDOM_BOUND) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE.getMessage());
        }
    }
}