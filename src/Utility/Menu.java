package Utility;

import java.util.Scanner;

public class Menu {
  private static Scanner sc = new Scanner(System.in);

  public static void menuLoop(){
    char Y;
    System.out.println("");
    System.out.print("Apakah ingin melanjutkan? [Y/N]: ");
    Y = sc.next().charAt(0);
    while(Y == 'Y'){
      mainMenu();
    }
    exit();
  }

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
    int i = sc.nextInt();
    switch (i) {
      case 1:
        input();
        i = sc.nextInt();
        break;
      case 2:
        input();
        i = sc.nextInt();
        break;
      case 3:
        input();
        i = sc.nextInt();
        break;
      case 4:
        input();
        i = sc.nextInt();
        break;
      case 5:
        input();
        i = sc.nextInt();
        break;
      case 6:
        input();
        i = sc.nextInt();
        break;
      case 7:
        exit();
      default:
        System.out.println("\nMohon masukan input yang benar!");
        System.out.println("Exiting...");
        break;
    }
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

  public static void inputMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran m x n");
    System.out.print("Masukan m: ");
    System.out.print("Masukan n: ");
    System.out.println("Silahkan masukan setiap element matrix: ");
  }

  public static void inputSqMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran n x n");
    System.out.print("Masukan n: ");
  }

  public static void inputInterpolasi(){
    System.out.println("");
    System.out.println("Akan dibuat interpolasi dengan pasangan sebanyak n buah");
    System.out.print("Masukan n: ");
    System.out.println("Silahkan masukan setiap pasangan: ");
  }

  public static void inputRegresi(){
    System.out.println("");
    System.out.println("Akan dibuat RLB (Regresi Linear Berganda) dengan n buah data dan k variabel");
    System.out.print("Masukan k: ");
    System.out.print("Masukan n: ");
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

  public static void exit(){
    System.out.println("\nTerima kasih telah menggunakan matrix calculator!");
    System.exit(0);
  }

}
