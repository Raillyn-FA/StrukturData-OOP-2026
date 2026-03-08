// Pilar: INHERITANCE (Turunan dari Toppings)
class Chocolate extends Toppings {
    
    public Chocolate() {
        this.namaKue = "Kue Cokelat";
    }

    // Pilar: POLYMORPHISM (Mengubah cara memberi topping)
    @Override
    void beriTopping() {
        System.out.println("Hasil: Menambahkan topping Selai Cokelat dan Choco Chips.");
    }
}
