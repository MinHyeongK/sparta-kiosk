package challenge.kiosk;

import java.util.HashMap;

public class Basket {
    private final HashMap<String, Integer> basketItems = new HashMap<>();

    protected HashMap<String, Integer> getBasketItems() {
        return basketItems;
    }

    protected void addItem(String itemName) {
        basketItems.put(itemName, basketItems.getOrDefault(itemName, 0) + 1);
    }

    protected void printItems(){
        for (String itemName: basketItems.keySet()){
            int quantity = basketItems.get(itemName);
            System.out.println("출력 구현 중...");
        }
    }
}
