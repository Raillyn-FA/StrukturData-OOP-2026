import java.util.*;

class Order {
    private int id;
    private List<Cake> cakes = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public void addCake(Cake c) {
        cakes.add(c);
    }

    public double calculateTotal() {
        double total = 0;
        for (Cake c : cakes) {
            total += c.calculatePrice();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("Order #" + id);
        for (Cake c : cakes) {
            c.showCake();
            System.out.println();
        }
        System.out.println("TOTAL: Rp" + calculateTotal());
    }
}