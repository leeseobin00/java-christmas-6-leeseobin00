package christmas.validator;

import christmas.domain.Menu;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.exception.ErrorCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuValidator {
    private static final int MAX_QUANTITY = 20;

    public static List<Order> validateMenu(String input) {
        validateNullOrEmpty(input);

        String[] menuInputs = input.split(",");
        List<Order> orders = new ArrayList<>();
        Set<Menu> uniqueMenus = new HashSet<>();

        validateOrder(menuInputs, orders, uniqueMenus);
        validateTotalQuantity(orders);
        validateDrinkOnly(orders);

        return orders;
    }

    private static void validateOrder(String[] menuInputs, List<Order> orders, Set<Menu> uniqueMenus) {
        for (String menuInput : menuInputs) {
            try {
                Order order = validateAndCreateOrder(menuInput.trim(), uniqueMenus);
                orders.add(order);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
            }
        }
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_MENU.getMessage());
        }
    }

    private static Order validateAndCreateOrder(String menuInput, Set<Menu> uniqueMenus) {
        String[] parts = menuInput.split("-");
        validateMenuFormat(parts);

        Menu menu = getMenu(parts[0], uniqueMenus);
        validateMenuExistence(menu);

        int quantity = validateQuantityType(parts[1]);

        return new Order(menu, quantity);
    }

    private static Menu getMenu(String menuName, Set<Menu> uniqueMenus) {
        Menu menu = Menu.valueOf(menuName);

        if (!uniqueMenus.add(menu)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }

        return menu;
    }

    private static void validateMenuFormat(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static void validateMenuExistence(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static int validateQuantityType(String quantityInput) {
        try {
            int quantity = Integer.parseInt(quantityInput);
            validateQuantityRange(quantity);
            return quantity;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static void validateQuantityRange(int quantity) {
        if (quantity < 1 || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static void validateTotalQuantity(List<Order> orders) {
        int totalQuantity = orders.stream().mapToInt(Order::getQuantity).sum();
        if (totalQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage());
        }
    }

    private static void validateDrinkOnly(List<Order> orders) {
        long drinkCount = orders.stream()
                .filter(order -> order.getMenu().getType() == MenuType.DRINK)
                .count();

        if (drinkCount > 0 && drinkCount == orders.size()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU_ONLY_DRINK.getMessage());
        }
    }
}