// Pilar: ENCAPSULATION (Mengatur akses data harga)
class DataKue {
    private double harga; // Disembunyikan

    public double getHarga() {
        return harga;
    }

    public void setHarga(double hargaBaru) {
        if (hargaBaru > 0) {
            this.harga = hargaBaru;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Eksekusi Encapsulation
        DataKue info = new DataKue();
        info.setHarga(25000);
        System.out.println("Harga per porsi: Rp" + info.getHarga());
        System.out.println("-----------------------------------");

        // Eksekusi Polymorphism
        Toppings kue1 = new Chocolate();
        Toppings kue2 = new Cheese();

        kue1.panggang();
        kue1.beriTopping();

        System.out.println();

        kue2.panggang();
        kue2.beriTopping();
    }
}
