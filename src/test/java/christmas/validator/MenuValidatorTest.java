package christmas.validator;

import christmas.domain.Order;
import christmas.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuValidatorTest {

    @Test
    void 주문_문자열이_Null_또는_빈_문자열인_경우_에러_발생() {
        // Given
        String nullOrEmptyOrderString = null;

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(nullOrEmptyOrderString);
        });
        assertEquals(ErrorCode.NULL_OR_EMPTY_MENU.getMessage(), exception.getMessage(), "Null 또는 빈 문자열이면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_형식이_올바르지_않은_경우_에러_발생() {
        // Given
        String invalidOrderString = "잘못된주문";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(invalidOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU.getMessage(), exception.getMessage(), "주문 형식이 올바르지 않으면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_메뉴가_존재하지_않는_경우_에러_발생() {
        // Given
        String nonExistentMenuOrderString = "존재하지않는메뉴-3";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(nonExistentMenuOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU.getMessage(), exception.getMessage(), "존재하지 않는 메뉴가 주문되면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_수량이_숫자가_아닌_경우_에러_발생() {
        // Given
        String invalidQuantityOrderString = "양송이수프-abc";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(invalidQuantityOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU.getMessage(), exception.getMessage(), "주문 수량이 숫자가 아니면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_수량이_1에서_20_사이가_아닌_경우_에러_발생() {
        // Given
        String outOfRangeQuantityOrderString = "양송이수프-21";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(outOfRangeQuantityOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU.getMessage(), exception.getMessage(), "주문 수량이 1에서 20 사이가 아니면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_수량의_총합이_20을_넘는_경우_에러_발생() {
        // Given
        String excessiveQuantityOrderString = "양송이수프-10, 타파스-11";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(excessiveQuantityOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU.getMessage(), exception.getMessage(), "주문 수량의 총합이 20을 넘으면 에러가 발생해야 합니다.");
    }

    @Test
    void 음료만_주문한_경우_에러_발생() {
        // Given
        String drinkOnlyOrderString = "제로콜라-3, 레드와인-2";

        // When, Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MenuValidator.validateMenu(drinkOnlyOrderString);
        });
        assertEquals(ErrorCode.INVALID_MENU_ONLY_DRINK.getMessage(), exception.getMessage(), "음료만 주문하면 에러가 발생해야 합니다.");
    }

    @Test
    void 주문_형식이_올바른_경우_주문_목록_리턴() {
        // Given
        String validOrderString = "양송이수프-2, 타파스-1, 티본스테이크-3";

        // When
        List<Order> result = MenuValidator.validateMenu(validOrderString);

        // Then
        assertEquals(3, result.size(), "올바른 주문 형식이면 주문 목록이 반환되어야 합니다.");
    }
}