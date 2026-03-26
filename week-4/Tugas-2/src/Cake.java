import java.util.*;

class Cake {
    private String name;
    private double basePrice;
    private List<Topping> toppings = new ArrayList<>();

    public Cake(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public void addTopping(Topping t) {
        toppings.add(t);
    }

    public double calculatePrice() {
        double total = basePrice;
        for (Topping t : toppings) {
            total += t.getPrice();
        }
        return total;
    }

    public void showCake() {
        System.out.println("Cake: " + name);
        for (Topping t : toppings) {
            System.out.println("- " + t.name);
        }
        System.out.println("Price: Rp" + calculatePrice());
    }
}