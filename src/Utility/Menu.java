package Utility;

public class Menu {

  public static void mainMenu() {
    System.out.println("");
    System.out.println("SELAMAT DATANG DI MATRIX CALCULATOR");
    System.out.println("###### MENU ######");
    System.out.println("1. Interpolasi polinom");
    System.out.println("2. Regresi linear berganda");
    System.out.println("3. Menghitung determinan matrix");
    System.out.println("4. Menghitung matriks balikan");
    System.out.println("5. Menyelesaikan SPL");
    System.out.println("6. Menghitung transpose matriks");
    System.out.println("7. Keluar");
    System.out.print("Masukan pilihan: ");
  }

  public static void input() {
    System.out.println("");
    System.out.println("###### Pilih jenis input ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void output() {
    System.out.println("");
    System.out.println("###### Pilih jenis output ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void SPL(){
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Elimnasi Gauss");
    System.out.println("2. Metode Elimnasi Gauss-Jordan");
    System.out.println("3. Metode Matriks Balikan");
    System.out.println("4. Kaidah Cramer");
    System.out.println("5. Keluar");
    System.out.print("Masukan pilihan: ");
  }
  public static void Determinan() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Ekspansi Kofaktor");
    System.out.println("3. Metode Sarrus");
    System.out.println("4. Keluar");
    System.out.print("Masukan pilihan: ");
  }

  public static void io(){
    System.out.println("Pilih file yang akan dibaca");
    IO.printListDir();
  }

}
