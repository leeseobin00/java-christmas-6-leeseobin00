package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.List;

public class OutputView {
    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printRequestDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printRequestMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printMenu(List<Order> orders) {
        System.out.println("\n<주문 메뉴>");
        for (Order order : orders) {
            System.out.println(order.getMenu().getName() + " " + order.getQuantity() + "개");
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", totalPrice));
    }

    public void printGiftMenu(Menu giftMenu) {
        System.out.println("\n<증정 메뉴>");
        if (giftMenu != null)
            System.out.println(giftMenu.getName() + " 1개");
        else if (giftMenu == null)
            System.out.println("없음");
    }

    public void printDiscounts(List<Discount> discounts, Menu giftMenu) {
        System.out.println("\n<혜택 내역>");
        if (discounts.isEmpty()) {
            System.out.println("없음");
        } else if (!discounts.isEmpty()) {
            for (Discount discount : discounts) {
                System.out.println(discount.getType() + ": -" + String.format("%,d원", discount.getAmount()));
            }
        }

        if (giftMenu != null) {
            System.out.println(giftMenu.getName() + ": -" + String.format("%,d원", giftMenu.getPrice()));
        }
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println("\n<총혜택 금액>");
        if (totalBenefitAmount != 0)
            System.out.println(String.format("-%,d원", totalBenefitAmount));
        else if (totalBenefitAmount == 0)
            System.out.println("0원");
    }

    public void printAfterDiscountTotal(int afterDiscountTotal) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", afterDiscountTotal));
    }

    public void printBadge(Badge badge) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badge != null ? badge.getName() : "없음");
    }

    public void printEventPlanner(int visitDate) {
        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}