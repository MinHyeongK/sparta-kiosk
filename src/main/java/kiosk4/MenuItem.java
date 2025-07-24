package kiosk4;

public class MenuItem {
    public String name;
    public double price;
    private String description;

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
