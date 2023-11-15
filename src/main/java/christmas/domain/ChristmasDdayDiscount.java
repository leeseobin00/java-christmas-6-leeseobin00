package christmas.domain;

public class ChristmasDdayDiscount {
    private final int visitDate;

    public ChristmasDdayDiscount(int visitDate) {
        this.visitDate = visitDate;
    }

    public Discount calculateDiscount() {
        int discountAmount = 0;

        // 크리스마스 디데이 할인 로직 추가
        if (visitDate >= 1 && visitDate <= 25) {
            discountAmount = 1000 + 100 * (visitDate - 1);
        }

        return new Discount("크리스마스 디데이 할인", discountAmount);
    }
}