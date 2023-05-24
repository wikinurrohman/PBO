# Java OOP CLI App : Humanitarian Aid
Java adalah bahasa pemrograman yang memiliki tujuan umum, berbasis class, berorientasi objek, dengan bekerja pada sistem operasi yang berbeda seperti Windows, Mac, dan Linux.

Menurut **freeCodecamp** ada empat prinsip utama paradigma OOP yang dikenal sebagai pilar Pemrograman Berorientasi Objek. Empat prinsip utama yaitu:

1. Encapsulation
2. Inheritance
3. Abstraction
4. Polymorphism

**Humanitarian Aid** adalah simulasi program untuk memberikan bantuan kepada pihak yang membutuhkan. Program memungkinkan untuk menjelajahi proyek-proyek yang tersedia, melihat detail proyek, dan melakukan donasi. Tujuannya adalah sebagai pemenuhan tugas mata kuliah, memberikan pemahaman dalam pengembangan perangkat lunak serta wawasan isu kemanusiaan.

## Class Diagrams
Aplikasi ini memiliki class-class dan relasi seperti berikut.

![](https://gitlab.com/if-praktikum-s4/if-pbo-aka-oop/java-oop-app/-/raw/main/img/aset/class-app-drawio.png)
## Demonstration
Penggunaan Aplikasi dan penjelasan code : [via YouTube](url)

# Use Case


| No.  | Pertanyaan Analisis Kasus                                                                                 | Status         |
|------|--------------------------------------------------------------------------------------------|----------------|
| 1    | Bagaimana sistem mengelola penambahan proyek baru?                                         | Done           |
| 2    | Apakah sistem memiliki fitur validasi untuk memastikan donasi minimal yang ditentukan?       | Done           |
| 3    | Bagaimana sistem memproses donasi yang masuk ke proyek yang sedang berlangsung?             | Done           |
| 4    | Apakah sistem memiliki fitur untuk melihat total donasi yang terkumpul untuk setiap proyek? | Done           |
| 5    | Bagaimana sistem mengelola proyek yang telah selesai?                                      | Done           |
| 6    | Bagaimana sistem menampilkan daftar proyek yang tersedia untuk didonasikan?                 | Done           |
| 7    | Apakah sistem memiliki fitur pencarian proyek berdasarkan kategori tertentu?               | Not considered           |
| 8    | Bagaimana sistem memastikan status donasi akan berakhir ketika kebutuhan proyek tercapai?         | Done           |
| 9    | Apakah sistem memiliki fitur untuk menampilkan detail proyek, seperti alamat dan nama penerima manfaat? | Done |
| 10   | Bagaimana sistem membedakan proyek-proyek dalam kategori yang berbeda?                      | Not considered           |
| 11   | Bagaimana sistem menangani proyek-proyek yang tidak aktif atau sudah ditutup?               | Done           |
| 12   | Bagaimana sistem melacak jumlah donasi dari setiap pengguna?                                | Not considered          |
| 13   | Apakah sistem memiliki fitur untuk menghapus proyek yang tidak relevan?                     | Not considered |
| 14   | Bagaimana sistem memastikan donasi yang diberikan oleh pengguna tercatat dengan akurat?     | Done           |
| 15   | Bagaimana sistem memastikan kerahasiaan informasi pengguna yang sensitif?                   | Not considered          |
| 16   | Apakah sistem memiliki fitur untuk menyimpan dan menampilkan perkembangan proyek?           | Done |
| 17   | Bagaimana sistem menampilkan kategori proyek yang tersedia kepada pengguna?                 | Done           |
| 18   | Apakah sistem memiliki fitur untuk mengurutkan proyek berdasarkan status atau tingkat kepentingan? | Not considered |
| 19   | Bagaimana sistem menampilkan proyek yang sedang berlangsung dan yang telah berakhir?         | Done           |
| 20   | Apakah sistem memiliki fitur untuk memperbarui informasi proyek yang sudah ada?             | Not considered |

## Source Code
Dapat dilihat melalui link berikut
1. [Main](https://gitlab.com/if-praktikum-s4/if-pbo-aka-oop/java-oop-app/-/blob/main/java/Main.java)
2. [AidProject](https://gitlab.com/if-praktikum-s4/if-pbo-aka-oop/java-oop-app/-/tree/main/java/humanity) dan subclass

Berikut penjelasan dari implementasi beberapa konsep OOP antara lain enkapsulasi, package, inheritance, dan polimorfisme

### 1. Encapsulation

Implementasi seperti pada `humanity/AidProject.java`
```java
private static int idCounter = 1;
    private int id;
    private String projectName;
    private String beneficiary;
    private String address;
    private int needAid;
    private int collectedDonation;
    private boolean completed;

```
Dan class-class turunan, salah satunya `humanity/EducationAidProject.java`
```java
    private String targetGrade;
```
Lalu kita perlu mengisiasi method `Getter` dan `Setter` memungkinkan penggunaan method untuk mengakses dan memanipulasi data.
### 2. Package
Penggunaan package memungkinkan pengelompokkan class-class yang terkait. Hal ini membantu dalam mengorganisir kode, dan menghindari konflik nama class yang sama. 

Implementasi terdapat pada `humanity/AidProject.java` dan class-class turunannya
```java
    package humanity;
```
Dalam `Main.java` kita melakukan import agar mengakses class-class yang terdapat pada directory yang berbeda
```java
    import humanity.*;
```
### 3. Inheritance
Class `AidProject` merupakan superclass yang menjadi landasan untuk subclass-subclass nya sehingga mewarisi atribut dan method dari superclass, antara lain
- MedicalAidProject
- EducationAidProject
- BiosphereAidProject
- AnimalAidProject
- DifabelAidProject

Setiap subclass memiliki konstruktor khusus untuk memanggil konstruktor superclass menggunakan kata kunci `super();`
```java
    public EducationAidProject(String projectName, String beneficiary, String address, int needAid, String targetGrade) {
            super(projectName, beneficiary, address, needAid); //konstruktor
            this.targetGrade = targetGrade;
        }

```
### 4. Polymorphism
`../humanity/AidProject.java`
```java
    public abstract void displayProjectInfo();
```
Override di dalam semua kelas turunannya, salah satunya `../humanity/BiosphereAidProject.java` memiliki bagian code
```java
 @Override
    public void displayProjectInfo() {
        System.out.println("Kategori            : Lingkungan");
        System.out.println("Detail              : " + getBiosphereType());
    }
```
Dilakukan pemanggilan di `Main.java` pada method `showProjectDetails();` 
```java
    private static void showProjectDetails() {
        // . . .
        project.displayProjectInfo();
        // . . .
     }
```

