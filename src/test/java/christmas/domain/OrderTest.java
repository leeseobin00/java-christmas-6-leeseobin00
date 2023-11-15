package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void 주문_메뉴_확인() {
        // Given
        Menu menu = Menu.양송이수프;
        Order order = new Order(menu, 2);

        // When
        Menu orderedMenu = order.getMenu();

        // Then
        assertEquals(menu, orderedMenu, "주문한 메뉴가 정확해야 합니다.");
    }

    @Test
    void 주문_수량_확인() {
        // Given
        int quantity = 3;
        Order order = new Order(Menu.타파스, quantity);

        // When
        int orderedQuantity = order.getQuantity();

        // Then
        assertEquals(quantity, orderedQuantity, "주문한 수량이 정확해야 합니다.");
    }

    @Test
    void 주문_객체_동등성_비교_다른_수량() {
        // Given
        Order order1 = new Order(Menu.티본스테이크, 2);
        Order order2 = new Order(Menu.티본스테이크, 1);

        // When
        boolean areEqual = order1.equals(order2);

        // Then
        assertFalse(areEqual, "주문 객체의 동등성이 정확해야 합니다. (다른 수량)");
    }

    @Test
    void 주문_객체_동등성_비교_다른_메뉴() {
        // Given
        Order order1 = new Order(Menu.아이스크림, 1);
        Order order2 = new Order(Menu.초코케이크, 1);

        // When
        boolean areEqual = order1.equals(order2);

        // Then
        assertFalse(areEqual, "주문 객체의 동등성이 정확해야 합니다. (다른 메뉴)");
    }
}