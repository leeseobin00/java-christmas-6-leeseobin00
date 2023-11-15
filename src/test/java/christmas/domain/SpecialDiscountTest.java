package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialDiscountTest {

    @Test
    void 특별_할인_없는_날짜_할인_금액_0원() {
        // Given
        int visitDateWithoutSpecialEvent = 5;
        SpecialDiscount specialDiscount = new SpecialDiscount(visitDateWithoutSpecialEvent);

        // When
        Discount discount = specialDiscount.calculateDiscount();

        // Then
        assertEquals(0, discount.getAmount(), "특별 할인이 없는 경우 할인 금액은 0원이어야 합니다.");
    }

    @Test
    void 특별_할인_있는_날짜_할인_금액_1_000원() {
        // Given
        int visitDateWithSpecialEvent = 3;
        SpecialDiscount specialDiscount = new SpecialDiscount(visitDateWithSpecialEvent);

        // When
        Discount discount = specialDiscount.calculateDiscount();

        // Then
        assertEquals(1000, discount.getAmount(), "특별 할인이 있는 경우 할인 금액은 1,000원이어야 합니다.");
    }

    @Test
    void 특별_할인_날짜_목록_확인() {
        // Given
        SpecialDiscount specialDiscount = new SpecialDiscount(1); // 임의의 날짜

        // When
        boolean hasSpecialEvent = specialDiscount.hasSpecialEvent(3)
                && specialDiscount.hasSpecialEvent(10)
                && specialDiscount.hasSpecialEvent(17)
                && specialDiscount.hasSpecialEvent(24)
                && specialDiscount.hasSpecialEvent(25)
                && specialDiscount.hasSpecialEvent(31);

        // Then
        assertTrue(hasSpecialEvent, "특별 할인 날짜 목록이 정확해야 합니다.");
    }
}