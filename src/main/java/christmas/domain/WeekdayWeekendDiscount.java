package christmas.domain;

import java.util.List;

public class WeekdayWeekendDiscount {
    private final int visitDate;

    public WeekdayWeekendDiscount(int visitDate) {
        this.visitDate = visitDate;
    }

    public Discount calculateDiscount(List<Order> orders) {
        int totalDiscountAmount = 0;

        // 주말에는 메인 메뉴, 주중에는 디저트 메뉴 할인
        boolean isWeekend = (visitDate + 4) % 7 == 5 || (visitDate + 4) % 7 == 6; // 금요일 또는 토요일
        int discountAmountPerMenu = 2023;

        for (Order order : orders) {
            Menu menu = order.getMenu();
            int menuDiscount = isWeekend ? (menu.getType() == MenuType.MAIN ? discountAmountPerMenu : 0)
                    : (menu.getType() == MenuType.DESSERT ? discountAmountPerMenu : 0);
            totalDiscountAmount += menuDiscount * order.getQuantity();
        }

        if (isWeekend)
            return new Discount("주말 할인", totalDiscountAmount);
        return new Discount("평일 할인", totalDiscountAmount);
    }
}