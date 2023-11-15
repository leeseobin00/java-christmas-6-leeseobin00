package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GiftEventTest {

    @Test
    void 증정_이벤트_캐리커처_초과() {
        // Given
        int totalPrice = 130000;
        GiftEvent giftEvent = new GiftEvent(totalPrice);

        // When
        Menu giftMenu = giftEvent.calculateGift();

        // Then
        assertEquals(Menu.샴페인, giftMenu, "총 주문 금액이 120,000원 이상이면 샴페인을 증정받아야 합니다.");
    }

    @Test
    void 증정_이벤트_미달() {
        // Given
        int totalPrice = 110000;
        GiftEvent giftEvent = new GiftEvent(totalPrice);

        // When
        Menu giftMenu = giftEvent.calculateGift();

        // Then
        assertNull(giftMenu, "총 주문 금액이 120,000원 미만이면 증정받을 메뉴가 없어야 합니다.");
    }
}