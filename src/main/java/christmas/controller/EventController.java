package christmas.controller;

import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runEventPlanner() {
        try {
            outputView.printStartMessage();
            int visitDate = readVisitDate();
            List<Order> orders = readOrders();

            EventPlannerController eventPlanner = createEventPlanner(visitDate, orders);

            printEventDetails(eventPlanner);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private int readVisitDate() {
        while (true) {
            try {
                outputView.printRequestDate();
                return inputView.readDate();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Order> readOrders() {
        while (true) {
            try {
                outputView.printRequestMenu();
                return inputView.readOrders();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private EventPlannerController createEventPlanner(int visitDate, List<Order> orders) {
        return new EventPlannerController(visitDate, orders);
    }

    private void printEventDetails(EventPlannerController eventPlanner) {
        outputView.printEventPlanner(eventPlanner.getVisitDate());
        outputView.printMenu(eventPlanner.getOrders());
        outputView.printTotalPrice(eventPlanner.getTotalPrice());
        outputView.printGiftMenu(eventPlanner.getGiftMenu());
        outputView.printDiscounts(eventPlanner.getDiscounts(), eventPlanner.getGiftMenu());
        outputView.printTotalBenefitAmount(eventPlanner.getTotalBenefitAmount());
        outputView.printAfterDiscountTotal(eventPlanner.getAfterDiscountTotal());
        outputView.printBadge(eventPlanner.getBadge());
    }
}