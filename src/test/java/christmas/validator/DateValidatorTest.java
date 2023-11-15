package christmas.validator;

import christmas.exception.ErrorCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest {

    @Test
    void 날짜_문자열이_숫자가_아닌_경우_에러_발생() {
        // Given
        String invalidDateString = "abc";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.validateDate(invalidDateString);
        });
        assertEquals(ErrorCode.INVALID_DATE.getMessage(), exception.getMessage(), "숫자가 아닌 문자열이 입력되면 에러가 발생해야 합니다.");
    }

    @Test
    void 날짜_문자열이_숫자가_1에서_31_사이가_아닌_경우_에러_발생() {
        // Given
        String outOfRangeDateString = "0";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.validateDate(outOfRangeDateString);
        });
        assertEquals(ErrorCode.INVALID_DATE.getMessage(), exception.getMessage(), "1에서 31 사이의 숫자가 아니면 에러가 발생해야 합니다.");
    }

    @Test
    void 날짜_문자열이_숫자가_1에서_31_사이인지_확인() {
        // Given
        String validDateString = "15";

        // When
        int result = DateValidator.validateDate(validDateString);

        // Then
        assertEquals(15, result, "1에서 31 사이의 숫자가 입력되면 해당 숫자를 반환해야 합니다.");
    }

    @Test
    void 날짜_문자열이_Null_또는_빈_문자열인_경우_에러_발생() {
        // Given
        String nullOrEmptyDateString = null;

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DateValidator.validateDate(nullOrEmptyDateString);
        });
        assertEquals(ErrorCode.NULL_OR_EMPTY_DATE.getMessage(), exception.getMessage(), "Null 또는 빈 문자열이면 에러가 발생해야 합니다.");
    }
}