package christmas.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorCodeTest {

    @Test
    void getMessage_유효하지않은날짜_에러코드의_메시지를_올바르게_반환한다() {
        // Given
        ErrorCode errorCode = ErrorCode.INVALID_DATE;

        // When
        String result = errorCode.getMessage();

        // Then
        assertEquals("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", result);
    }

    @Test
    void getMessage_NullOrEmptyDate_에러코드의_메시지를_올바르게_반환한다() {
        // Given
        ErrorCode errorCode = ErrorCode.NULL_OR_EMPTY_DATE;

        // When
        String result = errorCode.getMessage();

        // Then
        assertEquals("[ERROR] 날짜는 null이나 공백이 들어갈 수 없습니다.", result);
    }

    @Test
    void getMessage_유효하지않은주문_음료만주문시_에러코드의_메시지를_올바르게_반환한다() {
        // Given
        ErrorCode errorCode = ErrorCode.INVALID_MENU_ONLY_DRINK;

        // When
        String result = errorCode.getMessage();

        // Then
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 음료만 주문 시, 주문할 수 없습니다.", result);
    }

    @Test
    void getMessage_유효하지않은주문_에러코드의_메시지를_올바르게_반환한다() {
        // Given
        ErrorCode errorCode = ErrorCode.INVALID_MENU;

        // When
        String result = errorCode.getMessage();

        // Then
        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", result);
    }

    @Test
    void getMessage_NullOrEmptyMenu_에러코드의_메시지를_올바르게_반환한다() {
        // Given
        ErrorCode errorCode = ErrorCode.NULL_OR_EMPTY_MENU;

        // When
        String result = errorCode.getMessage();

        // Then
        assertEquals("[ERROR] 주문은 null이나 공백이 들어갈 수 없습니다.", result);
    }
}