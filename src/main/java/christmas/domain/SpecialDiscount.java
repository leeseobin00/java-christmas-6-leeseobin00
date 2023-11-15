package christmas.domain;

public class SpecialDiscount {
    private final int visitDate;

    public SpecialDiscount(int visitDate) {
        this.visitDate = visitDate;
    }

    public Discount calculateDiscount() {
        // 이벤트 달력에 별이 있는지 확인
        boolean hasStar = hasSpecialEvent(visitDate);

        // 별이 있는 경우 1,000원 할인, 없는 경우 할인 없음
        int discountAmount = hasStar ? 1000 : 0;

        return new Discount("특별 할인", discountAmount);
    }

    boolean hasSpecialEvent(int visitDate) {
        int[] specialEventDates = {3, 10, 17, 24, 25, 31};
        for (int specialDate : specialEventDates) {
            if (visitDate == specialDate) {
                return true;
            }
        }
        return false;
    }
}