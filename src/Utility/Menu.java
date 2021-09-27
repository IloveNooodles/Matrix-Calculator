package Utility;

import java.io.File;
import java.util.Scanner;
import Matrix.*;
import Aplikasi.*;

public class Menu {
  private static Scanner sc = new Scanner(System.in);

  private static Matrix m;

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
    m = new Matrix();

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
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputInterpolasi();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
        break;
      case 2:
        input();
        i = sc.nextInt();
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputRegresi();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
        break;
      case 3:
        input();
        i = sc.nextInt();
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputSqMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
        break;
      case 4:
        input();
        i = sc.nextInt();
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputSqMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
        break;
      case 5:
        input();
        i = sc.nextInt();
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
        break;
      case 6:
        input();
        i = sc.nextInt();
        switch (i) {
          case 1:
            io();
            break;
          case 2:
            inputMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            System.out.println("Exiting...");
            break;
        }
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
    int jumlahBaris = sc.nextInt();
    System.out.print("Masukan n: ");
    int jumlahKolom = sc.nextInt();

    m.setRow(jumlahBaris);
    m.setCol(jumlahKolom);

    System.out.println("Silahkan masukan setiap element matrix: ");
    m.createMatrix();
  }

  public static void inputSqMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran n x n!");
    System.out.print("Masukan n: "); 
    int n = sc.nextInt();

    m.setRow(n);
    m.setCol(n);

    System.out.println("Silahkan masukan matriks setiap element matrix: ");
    m.createMatrix();
  }

  public static void inputInterpolasi(){
    System.out.println("");
    System.out.println("Akan dibuat interpolasi dengan pasangan sebanyak n buah");
    System.out.print("Masukan n: ");
    int n = sc.nextInt();
    System.out.println("Silahkan masukan setiap pasangan: ");

    m = Interpolasi.masukkanInterpolasi(n);
  }

  public static void inputRegresi(){
    System.out.println("");
    System.out.println("Akan dibuat RLB (Regresi Linear Berganda) dengan k peubah");
    System.out.print("Masukan k: ");
    int k = sc.nextInt();
    System.out.println("Silahkan masukkan data:");

    m = RLB.inputRLB(k);
  }

  public static void SPL(){
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Eliminasi Gauss-Jordan");
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
    System.out.println("Pilih file yang akan dibaca!");
    IO.printListDir();

    File[] listFiles = IO.getListDir();

    System.out.print("Masukan pilihan: ");

    int q = sc.nextInt();

    m = IO.readMatrix(listFiles[q - 1].getName());
  }

  public static void exit(){
    System.out.println("\nTerima kasih telah menggunakan matrix calculator!");
    sc.close();
    System.exit(0);
  }
}
