package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BadgeCalculatorTest {

    @Test
    void 배지_계산기_배지_부여_없음_테스트() {
        // Given
        int totalBenefitAmount = 0;
        BadgeCalculator badgeCalculator = new BadgeCalculator(totalBenefitAmount);

        // When
        Badge badge = badgeCalculator.calculateBadge();

        // Then
        assertNull(badge, "총 혜택 금액이 0인 경우 배지가 부여되지 않아야 합니다.");
    }

    @Test
    void 배지_계산기_스타_배지_부여_테스트() {
        // Given
        int totalBenefitAmount = 5000;
        BadgeCalculator badgeCalculator = new BadgeCalculator(totalBenefitAmount);

        // When
        Badge badge = badgeCalculator.calculateBadge();

        // Then
        assertEquals(Badge.STAR, badge, "총 혜택 금액이 5000 이상인 경우 '별' 배지가 부여되어야 합니다.");
    }

    @Test
    void 배지_계산기_트리_배지_부여_테스트() {
        // Given
        int totalBenefitAmount = 10000;
        BadgeCalculator badgeCalculator = new BadgeCalculator(totalBenefitAmount);

        // When
        Badge badge = badgeCalculator.calculateBadge();

        // Then
        assertEquals(Badge.TREE, badge, "총 혜택 금액이 10000 이상인 경우 '트리' 배지가 부여되어야 합니다.");
    }

    @Test
    void 배지_계산기_산타_배지_부여_테스트() {
        // Given
        int totalBenefitAmount = 20000;
        BadgeCalculator badgeCalculator = new BadgeCalculator(totalBenefitAmount);

        // When
        Badge badge = badgeCalculator.calculateBadge();

        // Then
        assertEquals(Badge.SANTA, badge, "총 혜택 금액이 20000 이상인 경우 '산타' 배지가 부여되어야 합니다.");
    }
}