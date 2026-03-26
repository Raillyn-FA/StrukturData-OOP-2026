public class Main {
    public static void main(String[] args) {
        Order order = new Order(1);

        Cake cake1 = new Cake("Chocolate Cake", 30000);
        cake1.addTopping(new Cheese());
        cake1.addTopping(new Oreo());

        Cake cake2 = new Cake("Vanilla Cake", 25000);
        cake2.addTopping(new Chocolate());

        order.addCake(cake1);
        order.addCake(cake2);

        order.showOrder();
    }
}