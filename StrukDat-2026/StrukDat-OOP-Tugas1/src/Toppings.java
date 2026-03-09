// Pilar: ABSTRACTION
// Membuat kontrak umum bahwa setiap kue harus bisa diberi topping
abstract class Toppings {
    String namaKue;

    abstract void beriTopping();

    void panggang() {
        System.out.println(namaKue + " sedang dipanggang...");
    }
}