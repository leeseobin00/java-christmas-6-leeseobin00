package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTypeTest {

    @Test
    void 메뉴_타입_APPETIZER_확인() {
        // Given
        MenuType menuType = MenuType.APPETIZER;

        // When
        String typeName = menuType.name();

        // Then
        assertEquals("APPETIZER", typeName, "메뉴 타입이 APPETIZER이어야 합니다.");
    }

    @Test
    void 메뉴_타입_MAIN_확인() {
        // Given
        MenuType menuType = MenuType.MAIN;

        // When
        String typeName = menuType.name();

        // Then
        assertEquals("MAIN", typeName, "메뉴 타입이 MAIN이어야 합니다.");
    }

    @Test
    void 메뉴_타입_DESSERT_확인() {
        // Given
        MenuType menuType = MenuType.DESSERT;

        // When
        String typeName = menuType.name();

        // Then
        assertEquals("DESSERT", typeName, "메뉴 타입이 DESSERT이어야 합니다.");
    }

    @Test
    void 메뉴_타입_DRINK_확인() {
        // Given
        MenuType menuType = MenuType.DRINK;

        // When
        String typeName = menuType.name();

        // Then
        assertEquals("DRINK", typeName, "메뉴 타입이 DRINK이어야 합니다.");
    }
}