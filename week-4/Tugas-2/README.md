# Sistem Kostumisasi Pesanan Pada Sebuah Toko Kue
- Nama  : Rayhan Fadhilah Allayn
- NRP   : 5027251126
- Kelas : Struktur Data & OOP (B)

## Deskripsi
Sistem ini dibuat untuk membantu toko kue dalam mengelola pesanan kue yang memiliki berbagai variasi *topping*. Dalam sistem ini pelangggan dapat memilih jenis kue, menambahkan lebih dari satu *topping*, dan Sistem akan menghitung total harganya secara otomatis. Tujuan dari sistem ini adalah memberikan kemudahan dalam pemesanan dan perhitungan harga.

## Class Diagram
<img width="3386" height="4610" alt="Cake Order Pricing Framework-2026-03-26-060315" src="https://github.com/user-attachments/assets/8923a644-1340-4793-a451-0882d20b8f9c" />

> ## Kode Program Java
Berikut adalah sources code yang digunakan dalam sistem ini.
### Cake.java
```java
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
```
### Topping.java
```java
abstract class Topping {
    protected String name;
    public abstract double getPrice();
}
```
### Cheese.java
```java
class Cheese extends Topping {
    public Cheese() {
        name = "Cheese";
    }
    public double getPrice() {
        return 5000;
    }
}
```
### Chocolate.java
```java
class Chocolate extends Topping {
    public Chocolate() {
        name = "Chocolate";
    }
    public double getPrice() {
        return 6000;
    }
}
```
### Oreo.java
```java
class Oreo extends Topping {
    public Oreo() {
        name = "Oreo";
    }
    public double getPrice() {
        return 7000;
    }
}
```
### Order.java
```java
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
```
### Main.java
```java
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
```
Note: Pastikan semua file dalam satu folder yang sama.

## Screenshot Output
<img width="1047" height="322" alt="image" src="https://github.com/user-attachments/assets/900ae665-0a43-4b3c-889c-9584f9e8dc78" />

## Penjelasan prinsip-prinsip OOP apa saja yang diterapkan

### 1. Encapsulation
Data penting seperti `name`, `basePrice`, dan `toppings` disimpan dalam atribut `private` pada class `Cake`, serta `cakes` pada class `Order`.

Akses terhadap data dilakukan melalui method seperti:
* `addTopping()`
* `calculatePrice()`
* `calculateTotal()`

Hal ini bertujuan untuk menjaga keamanan data dan mencegah akses langsung dari luar class.
### 2. Abstraction
Class `Topping` dibuat sebagai **abstract class** yang merepresentasikan konsep umum topping.

Implementasi detail dari method `getPrice()` diturunkan ke subclass seperti:
* `Cheese`
* `Oreo`
* `Chocolate`
### 3. Inheritance
Program menggunakan konsep pewarisan (inheritance), dimana:
* `Cheese` mewarisi `Topping`
* `Oreo` mewarisi `Topping`
* `Chocolate` mewarisi `Topping`
Dengan inheritance, atribut dan method umum tidak perlu ditulis ulang di setiap class.
### 4. Polymorphism
Method `getPrice()` pada class `Topping` diimplementasikan secara berbeda pada setiap subclass.
Contoh:
* `Cheese` → Rp5000
* `Oreo` → Rp7000
* `Chocolate` → Rp6000

Polymorphism terjadi saat method dipanggil dalam loop:
```java
for (Topping t : toppings) {
    total += t.getPrice();
}
```
Meskipun menggunakan satu method yang sama (`getPrice()`), hasil yang diperoleh berbeda tergantung jenis objek topping.

## Penjelasan keunikan yang membedakan dengan individu lain
Program ini memiliki keunikan pada sistem custom kue berbasis topping dinamis, dimana:
* Satu kue dapat memiliki lebih dari satu topping.
* Setiap topping memiliki perhitungan harga berbeda.
* Struktur program dibuat modular.
