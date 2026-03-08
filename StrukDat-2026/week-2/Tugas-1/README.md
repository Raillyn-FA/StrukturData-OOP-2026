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
class Kue {
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

Kelas "Donat" dan "Cupcake" mewarisi kemampuan dasar dari "ResepKue". Kita tidak perlu menulis ulang fungsi "panggang()".
```java
class Donat extends ResepKue {
    @Override
    void beriTopping() {
        System.out.println("Menambahkan topping: Meises Cokelat");
    }
}

class Cupcake extends ResepKue {
    @Override
    void beriTopping() {
        System.out.println("Menambahkan topping: Buttercream Strawberry");
    }
}
```

## 4. Polymorphism (Polimorfisme)
Polymorphism adalah kemampuan suatu method atau objek untuk memiliki banyak bentuk sehingga dapat berperilaku berbeda pada class yang berbeda.

Satu perintah beriTopping() bisa menghasilkan hasil yang berbeda tergantung objek kue mana yang dipanggil.
```java
public class TokoKue {
    public static void main(String[] args) {
        // Encapsulation
        Kue k = new Kue();
        k.setHarga(15000);
        System.out.println("Harga Kue: Rp" + k.getHarga());

        // Polymorphism: Satu tipe (ResepKue), banyak bentuk (Donat/Cupcake)
        ResepKue kue1 = new Donat();
        ResepKue kue2 = new Cupcake();

        System.out.println("\n--- Proses Produksi ---");
        kue1.panggang();
        kue1.beriTopping(); // Output: Meises Cokelat

        kue2.panggang();
        kue2.beriTopping(); // Output: Buttercream Strawberry
    }
}
```