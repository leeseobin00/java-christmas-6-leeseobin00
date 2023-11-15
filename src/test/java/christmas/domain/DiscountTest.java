package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

    @Test
    void 할인_객체_생성_테스트() {
        // Given
        String discountType = "테스트 할인";
        int discountAmount = 5000;

        // When
        Discount discount = new Discount(discountType, discountAmount);

        // Then
        assertEquals(discountType, discount.getType(), "할인 타입이 올바르게 설정되어야 합니다.");
        assertEquals(discountAmount, discount.getAmount(), "할인 금액이 올바르게 설정되어야 합니다.");
    }
}