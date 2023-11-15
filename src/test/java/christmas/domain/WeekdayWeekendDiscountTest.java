package christmas.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WeekdayWeekendDiscountTest {

    @Test
    void 주말에_메인_메뉴_주문_시_할인_금액_올바른지_확인() {
        // Given
        int visitDate = 1; // 금요일
        WeekdayWeekendDiscount discountCalculator = new WeekdayWeekendDiscount(visitDate);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.티본스테이크, 4)); // 메인 메뉴 주문

        // When
        Discount discount = discountCalculator.calculateDiscount(orders);

        // Then
        assertEquals(4 * 2023, discount.getAmount(), "주말에 메인 메뉴 주문 시 할인 금액이 올바르게 계산되어야 합니다.");
    }

    @Test
    void 주말에_디저트_메뉴_주문_시_할인_금액_0원() {
        // Given
        int visitDate = 1; // 금요일
        WeekdayWeekendDiscount discountCalculator = new WeekdayWeekendDiscount(visitDate);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.초코케이크, 4)); // 디저트 메뉴 주문

        // When
        Discount discount = discountCalculator.calculateDiscount(orders);

        // Then
        assertEquals(0, discount.getAmount(), "주말에 디저트 메뉴 주문 시 할인 금액은 0원이어야 합니다.");
    }

    @Test
    void 평일에_디저트_메뉴_주문_시_할인_금액_올바른지_확인() {
        // Given
        int visitDate = 3; // 수요일
        WeekdayWeekendDiscount discountCalculator = new WeekdayWeekendDiscount(visitDate);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.초코케이크, 2)); // 디저트 메뉴 주문

        // When
        Discount discount = discountCalculator.calculateDiscount(orders);

        // Then
        assertEquals(2 * 2023, discount.getAmount(), "평일에 디저트 메뉴 주문 시 할인 금액이 올바르게 계산되어야 합니다.");
    }

    @Test
    void 평일에_메인_메뉴_주문_시_할인_금액_0원() {
        // Given
        int visitDate = 3; // 수요일
        WeekdayWeekendDiscount discountCalculator = new WeekdayWeekendDiscount(visitDate);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.티본스테이크, 1)); // 메인 메뉴 주문

        // When
        Discount discount = discountCalculator.calculateDiscount(orders);

        // Then
        assertEquals(0, discount.getAmount(), "평일에 메인 메뉴 주문 시 할인 금액은 0원이어야 합니다.");
    }
}