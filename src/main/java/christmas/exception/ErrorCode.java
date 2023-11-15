package christmas.exception;

public enum ErrorCode {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NULL_OR_EMPTY_DATE("날짜는 null이나 공백이 들어갈 수 없습니다."),
    INVALID_MENU_ONLY_DRINK("유효하지 않은 주문입니다. 음료만 주문 시, 주문할 수 없습니다."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NULL_OR_EMPTY_MENU("주문은 null이나 공백이 들어갈 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}