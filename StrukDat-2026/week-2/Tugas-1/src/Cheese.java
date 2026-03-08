// Pilar: INHERITANCE
class Cheese extends Toppings {

    public Cheese() {
        this.namaKue = "Kue Keju";
    }

    // Pilar: POLYMORPHISM
    @Override
    void beriTopping() {
        System.out.println("Hasil: Menambahkan topping Keju Parut dan Cream Cheese.");
    }
}
