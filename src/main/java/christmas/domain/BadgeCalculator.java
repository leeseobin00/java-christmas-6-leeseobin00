package christmas.domain;

public class BadgeCalculator {
    private final int totalBenefitAmount;

    public BadgeCalculator(int totalBenefitAmount) {
        this.totalBenefitAmount = totalBenefitAmount;
    }

    public Badge calculateBadge() {
        if (totalBenefitAmount >= 20000) {
            return Badge.SANTA;
        } else if (totalBenefitAmount >= 10000) {
            return Badge.TREE;
        } else if (totalBenefitAmount >= 5000) {
            return Badge.STAR;
        }
        return null; // 배지 부여 없음
    }
}