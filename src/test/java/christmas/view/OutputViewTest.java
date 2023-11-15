package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final OutputView outputView = new OutputView();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printStartMessage_시작_메시지를_출력한다() {
        // When
        outputView.printStartMessage();

        // Then
        String expectedOutput = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printRequestDate_날짜_요청_메시지를_출력한다() {
        // When
        outputView.printRequestDate();

        // Then
        String expectedOutput = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printRequestMenu_메뉴_요청_메시지를_출력한다() {
        // When
        outputView.printRequestMenu();

        // Then
        String expectedOutput = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printMenu_주문_메뉴를_출력한다() {
        // Given
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.양송이수프, 2));
        orders.add(new Order(Menu.타파스, 1));

        // When
        outputView.printMenu(orders);

        // Then
        String expectedOutput = "\n<주문 메뉴>\n양송이수프 2개\n타파스 1개\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printTotalPrice_할인_전_총_주문_금액을_출력한다() {
        // When
        outputView.printTotalPrice(50000);

        // Then
        String expectedOutput = "\n<할인 전 총주문 금액>\n50,000원\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printGiftMenu_증정_메뉴를_출력한다() {
        // Given
        Menu giftMenu = Menu.샴페인;

        // When
        outputView.printGiftMenu(giftMenu);

        // Then
        String expectedOutput = "\n<증정 메뉴>\n샴페인 1개\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printGiftMenu_증정_메뉴가_없는_경우_없음을_출력한다() {
        // Given
        Menu giftMenu = null;

        // When
        outputView.printGiftMenu(giftMenu);

        // Then
        String expectedOutput = "\n<증정 메뉴>\n없음\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printDiscounts_할인_내역을_출력한다() {
        // Given
        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount("크리스마스 할인", 5000));
        discounts.add(new Discount("특별 할인", 2000));

        // When
        outputView.printDiscounts(discounts, null);

        // Then
        String expectedOutput = "\n<혜택 내역>\n크리스마스 할인: -5,000원\n특별 할인: -2,000원\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printDiscounts_할인_내역이_없는_경우_없음을_출력한다() {
        // Given
        List<Discount> discounts = new ArrayList<>();

        // When
        outputView.printDiscounts(discounts, null);

        // Then
        String expectedOutput = "\n<혜택 내역>\n없음\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printDiscounts_증정_메뉴가_없는_경우_출력하지_않는다() {
        // Given
        Menu giftMenu = null;

        // When
        outputView.printDiscounts(new ArrayList<>(), giftMenu);

        // Then
        String expectedOutput = "\n<혜택 내역>\n없음\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printTotalBenefitAmount_총혜택_금액을_출력한다() {
        // When
        outputView.printTotalBenefitAmount(30000);

        // Then
        String expectedOutput = "\n<총혜택 금액>\n-30,000원\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printTotalBenefitAmount_총혜택_금액이_0인_경우_0을_출력한다() {
        // When
        outputView.printTotalBenefitAmount(0);

        // Then
        String expectedOutput = "\n<총혜택 금액>\n0원\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printAfterDiscountTotal_할인_후_예상_결제_금액을_출력한다() {
        // When
        outputView.printAfterDiscountTotal(45000);

        // Then
        String expectedOutput = "\n<할인 후 예상 결제 금액>\n45,000원\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printBadge_이벤트_배지를_출력한다() {
        // Given
        Badge badge = Badge.STAR;

        // When
        outputView.printBadge(badge);

        // Then
        String expectedOutput = "\n<12월 이벤트 배지>\n별\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printBadge_이벤트_배지가_없는_경우_없음을_출력한다() {
        // Given
        Badge badge = null;

        // When
        outputView.printBadge(badge);

        // Then
        String expectedOutput = "\n<12월 이벤트 배지>\n없음\n";
        assertEquals(expectedOutput, getOutput());
    }

    @Test
    void printErrorMessage_에러_메시지를_출력한다() {
        // Given
        String errorMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

        // When
        outputView.printErrorMessage(errorMessage);

        // Then
        String expectedOutput = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n";
        assertEquals(expectedOutput, getOutput());
    }

    private String getOutput() {
        return outputStream.toString();
    }
}