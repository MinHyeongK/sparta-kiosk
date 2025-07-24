package challenge.kiosk;

public class MenuItem {
    //키오스크 시작 후엔 필드 수정이 없으므로 final로 정의
    private final String name;
    private final double price;
    private final String description;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    protected MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-18s | W %-6.2f | %s", name, price, description);
    }
}
