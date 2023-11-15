package christmas.domain;

public class GiftEvent {
    private final int totalPrice;

    public GiftEvent(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Menu calculateGift() {
        // 증정 이벤트 계산 로직 구현
        if (totalPrice >= 120000) {
            return Menu.샴페인;
        }
        return null;
    }
}