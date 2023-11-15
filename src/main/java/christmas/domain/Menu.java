package christmas.domain;

public enum Menu {
    양송이수프("양송이수프", 6000, MenuType.APPETIZER),
    타파스("타파스", 5500, MenuType.APPETIZER),
    시저샐러드("시저샐러드", 8000, MenuType.APPETIZER),
    티본스테이크("티본스테이크", 55000, MenuType.MAIN),
    바비큐립("바비큐립", 54000, MenuType.MAIN),
    해산물파스타("해산물파스타", 35000, MenuType.MAIN),
    크리스마스파스타("크리스마스파스타", 25000, MenuType.MAIN),
    초코케이크("초코케이크", 15000, MenuType.DESSERT),
    아이스크림("아이스크림", 5000, MenuType.DESSERT),
    제로콜라("제로콜라", 3000, MenuType.DRINK),
    레드와인("레드와인", 60000, MenuType.DRINK),
    샴페인("샴페인", 25000, MenuType.DRINK);

    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }
}