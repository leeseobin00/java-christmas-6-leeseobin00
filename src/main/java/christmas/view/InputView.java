package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.validator.DateValidator;
import christmas.validator.MenuValidator;

import java.util.List;

public class InputView {
    public int readDate() {
        String input = Console.readLine();
        return DateValidator.validateDate(input);
    }

    public List<Order> readOrders() {
        String input = Console.readLine();
        return MenuValidator.validateMenu(input);
    }
}