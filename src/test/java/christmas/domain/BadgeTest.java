package christmas.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @Test
    void 배지_이름_반환_테스트() {
        // Given
        Badge starBadge = Badge.STAR;
        Badge treeBadge = Badge.TREE;
        Badge santaBadge = Badge.SANTA;

        // When
        String starName = starBadge.getName();
        String treeName = treeBadge.getName();
        String santaName = santaBadge.getName();

        // Then
        assertEquals("별", starName, "별 배지의 이름은 '별'이어야 합니다.");
        assertEquals("트리", treeName, "트리 배지의 이름은 '트리'이어야 합니다.");
        assertEquals("산타", santaName, "산타 배지의 이름은 '산타'이어야 합니다.");
    }
}