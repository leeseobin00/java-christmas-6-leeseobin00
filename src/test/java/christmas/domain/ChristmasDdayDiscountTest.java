package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasDdayDiscountTest {

    @Test
    void 크리스마스_디데이_할인_적용_테스트() {
        // Given
        int visitDate = 5; // 임의의 날짜 (12월 5일)
        ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount(visitDate);

        // When
        Discount discount = christmasDdayDiscount.calculateDiscount();

        // Then
        int expectedDiscountAmount = 1000 + 100 * (visitDate - 1);
        assertEquals(expectedDiscountAmount, discount.getAmount(), "크리스마스 디데이에 할인이 올바르게 계산되어야 합니다.");
        assertEquals("크리스마스 디데이 할인", discount.getType(), "할인 타입은 '크리스마스 디데이 할인'이어야 합니다.");
    }

    @Test
    void 크리스마스_디데이_할인_미적용_테스트() {
        // Given
        int visitDate = 27; // 임의의 날짜 (12월 27일)
        ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount(visitDate);

        // When
        Discount discount = christmasDdayDiscount.calculateDiscount();

        // Then
        assertEquals(0, discount.getAmount(), "크리스마스 디데이가 아닌 경우 할인이 0이어야 합니다.");
        assertEquals("크리스마스 디데이 할인", discount.getType(), "할인 타입은 '크리스마스 디데이 할인'이어야 합니다.");
    }
}