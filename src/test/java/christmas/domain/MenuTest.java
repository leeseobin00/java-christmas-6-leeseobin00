package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    void 메뉴_이름_확인() {
        // Given
        Menu menu = Menu.양송이수프;

        // When
        String name = menu.getName();

        // Then
        assertEquals("양송이수프", name, "메뉴의 이름이 일치해야 합니다.");
    }

    @Test
    void 메뉴_가격_확인() {
        // Given
        Menu menu = Menu.양송이수프;

        // When
        int price = menu.getPrice();

        // Then
        assertEquals(6000, price, "메뉴의 가격이 일치해야 합니다.");
    }

    @Test
    void 메뉴_타입_확인() {
        // Given
        Menu menu = Menu.양송이수프;

        // When
        MenuType type = menu.getType();

        // Then
        assertEquals(MenuType.APPETIZER, type, "메뉴의 타입이 일치해야 합니다.");
    }
}