package christmas.controller;

import christmas.domain.*;

import java.util.ArrayList;
import java.util.List;

public class EventPlannerController {
    private final int visitDate;
    private final List<Order> orders;

    private int totalPrice;
    private List<Discount> discounts;
    private Menu giftMenu;
    private Badge badge;

    public EventPlannerController(int visitDate, List<Order> orders) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.totalPrice = calculateTotalPrice();
        this.discounts = new ArrayList<>();
        calculateBenefits();
    }

    public int getVisitDate() {
        return visitDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public Menu getGiftMenu() {
        return giftMenu;
    }

    public Badge getBadge() {
        return badge;
    }

    public int getTotalBenefitAmount() {
        return discounts.stream().mapToInt(Discount::getAmount).sum() + (giftMenu != null ? giftMenu.getPrice() : 0);
    }

    public int getAfterDiscountTotal() {
        return totalPrice - discounts.stream().mapToInt(Discount::getAmount).sum();
    }

    private int calculateTotalPrice() {
        return orders.stream().mapToInt(order -> order.getMenu().getPrice() * order.getQuantity()).sum();
    }

    public void calculateBenefits() {
        calculateTotalPrice();

        // 총주문 금액이 10,000원 이상인 경우에만 할인 계산 및 이벤트 적용
        if (totalPrice >= 10000) {
            calculateDiscounts();
            calculateGiftMenu();
            calculateBadge();
        }
    }

    private void calculateDiscounts() {
        // 크리스마스 디데이 할인
        ChristmasDdayDiscount christmasDdayDiscount = new ChristmasDdayDiscount(visitDate);
        discounts.add(christmasDdayDiscount.calculateDiscount());

        // 평일/주말 할인
        WeekdayWeekendDiscount weekdayWeekendDiscount = new WeekdayWeekendDiscount(visitDate);
        discounts.add(weekdayWeekendDiscount.calculateDiscount(orders));

        // 특별 할인
        SpecialDiscount specialDiscount = new SpecialDiscount(visitDate);
        discounts.add(specialDiscount.calculateDiscount());

        // 증정 이벤트
        GiftEvent giftEvent = new GiftEvent(totalPrice);
        giftMenu = giftEvent.calculateGift();
    }

    private void calculateBadge() {
        // 배지 계산 로직 추가
        BadgeCalculator badgeCalculator = new BadgeCalculator(calculateTotalPrice());
        badge = badgeCalculator.calculateBadge();
    }

    private void calculateGiftMenu() {
        GiftEvent giftEvent = new GiftEvent(totalPrice);
        giftMenu = giftEvent.calculateGift();
    }
}