>**Nama**   : Rayhan Fadhilah Allayn\
>**NRP**    : 5027251126\
>**Kelas**  : Struktur Data dan OOP (B)

# 4 Pillars of OOP
Dalam Pemrograman Berbasi Objek(OOP) terdapat 4 pilar utama yang menjadi pondasi bagaimana kode disusun agar lebih rapih, effisien, dan mudah dikelola

Berikut adalah penjelasan dari keempat pilar:

## 1. Encapsulation (Enkapsuli)
Encapsulation adalah konsep membungkus data dan metode dalam satu class serta membatasi akses langsung ke data untuk melindungi dan menyembunyikan proses di dalamnya.

Kita membungkus data "harga" agar tidak bisa diubah sembarangan menjadi minus atau nol oleh pihak luar.
```java
class DataKue {
    private double harga; // Data disembunyikan

    // Getter untuk melihat harga
    public double getHarga() {
        return harga;
    }

    // Setter untuk mengubah harga dengan validasi (Keamanan)
    public void setHarga(double hargaBaru) {
        if (hargaBaru > 0) {
            this.harga = hargaBaru;
        } else {
            System.out.println("Harga kue tidak valid!");
        }
    }
}
```
## 2. Abstraction (Abstraksi)
Abstraction adalah konsep menyembunyikan detail implementasi yang rumit dan hanya menampilkan fungsi penting dari suatu objek kepada pengguna.

Kita membuat konsep umum bahwa setiap kue harus bisa "dihias", tapi cara menghiasnya berbeda-beda tergantung jenis kuenya.
```java
abstract class ResepKue {
    // Pengguna hanya perlu tahu kue harus dihias, detailnya urusan koki
    abstract void beriTopping();
    
    void panggang() {
        System.out.println("Kue sedang dipanggang di oven...");
    }
}
```
## 3. Inheritance (Pewarisan)
Inheritance adalah konsep pewarisan dimana sebuah class dapat mewarisi atribut dan metode dari class lain sehingga mengurangi penulisan kode yang berulang.

Kelas "Chocolate" dan "Cheese" mewarisi kemampuan dasar dari "Toppings". Kita tidak perlu menulis ulang fungsi "panggang()".
```java
// Pilar: INHERITANCE (Turunan dari Toppings)
class Chocolate extends Toppings {

    public Chocolate() {
        this.namaKue = "Kue Cokelat";
    }
    // Pilar: POLYMORPHISM
    @Override
    void beriTopping() {
        System.out.println("asil: Menambahkan topping Selai Cokelat dan Choco Chips.");
    }
}
// Pilar: INHERITANCE
class Cheese extends ResepKue {

    public Chees() {
        this.namaKue = "Kue Keju";
    }
    // Pillar: POLYMORPHISM
    @Override
    void beriTopping() {
        System.out.println("Hasil: Menambahkan topping Keju Parut dan Cream Cheese.");
    }
}
```

## 4. Polymorphism (Polimorfisme)
Polymorphism adalah kemampuan suatu method atau objek untuk memiliki banyak bentuk sehingga dapat berperilaku berbeda pada class yang berbeda.

Satu perintah beriTopping() bisa menghasilkan hasil yang berbeda tergantung objek kue mana yang dipanggil.
```java
public class Main {
    public static void main(String[] args) {
        // Encapsulation
        DataKue info = new DataKue();
        info.setHarga(15000);
        System.out.println("Harga Kue: Rp" + info.getHarga());
        System.out.println("-----------------------------------");

        // Eksekusi Polymorphim
        Toppings kue1 = new Chocolate();
        Toppings kue2 = new Cheese();

        kue1.panggang();
        kue1.beriTopping(); // Output: Chocolate

        System.out.println();

        kue2.panggang();
        kue2.beriTopping(); // Output: Cheese
    }
}
```
