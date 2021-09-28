package Utility;

import java.io.File;
import java.util.Scanner;
import Matrix.*;
import Aplikasi.*;

public class Menu {
  private Scanner sc = new Scanner(System.in);

  private Matrix m;

  public Menu() {
    m = new Matrix(100, 100);
  }

  public void menuLoop(){
    char Y;
    do {
      mainMenu();
      System.out.println("");
      System.out.print("Apakah ingin melanjutkan? [Y/N]: ");
      Y = sc.next().charAt(0);
    } while (Y == 'Y');
    exit();
  }

  public void mainMenu() {

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
            InterpolasiKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
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
            RegresiKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
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
            DeterminanKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
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
            InverseKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
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
            SPLKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
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
            inputTranspose();
            TransposeKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 7:
        exit();
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public void input() {
    System.out.println("");
    System.out.println("###### Pilih jenis input ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public void output() {
    System.out.println("");
    System.out.println("###### Pilih jenis output ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public void inputMatrix(){
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

  public void inputSqMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran n x n");
    System.out.print("Masukan n: "); 
    int n = sc.nextInt();

    m.setRow(n);
    m.setCol(n);

    System.out.println("Silahkan masukan setiap element matrix: ");
    m.createMatrix();
  }

  public void inputInterpolasi(){
    System.out.println("");
    System.out.println("Akan dibuat interpolasi dengan pasangan sebanyak n buah");
    System.out.print("Masukan n: ");
    int n = sc.nextInt();
    System.out.println("Silahkan masukan setiap pasangan: ");

    m = Interpolasi.masukkanInterpolasi(n);
  }

  public void inputRegresi(){
    System.out.println("");
    System.out.println("Akan dibuat RLB (Regresi Linear Berganda) dengan n buah persamaan dengan k peubah");
    System.out.print("Masukan n:");
    int n = sc.nextInt();
    System.out.print("Masukan k: ");
    int k = sc.nextInt();
    System.out.println("Silahkan masukkan data:");

    m = RLB.inputRLB(n, k);
  }

  public void inputTranspose() {
    System.out.println("");
    System.out.println("Akan dibuat transpose matriks n x n");
    System.out.print("Masukan n: ");
    int n = sc.nextInt();

    m.setRow(n);
    m.setCol(n);

    System.out.println("Silahkan masukan setiap element matrix: ");
    m.createMatrix();
  }

  public void SPLKeyboard(){
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Eliminasi Gauss-Jordan");
    System.out.println("3. Metode Matriks Balikan");
    System.out.println("4. Kaidah Cramer");
    System.out.print("Masukan pilihan: ");
    int i = sc.nextInt();

    switch (i) {
      case 1:
        SistemPersamaanLinear.SPLGauss(m);
        break;
      case 2:
        SistemPersamaanLinear.SPLGaussJordan(m);
        break;
      case 3:
        SistemPersamaanLinear.SPLinverse(m);
        break;
      case 4:
        Crammer.crammer(m);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public void DeterminanKeyboard() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Ekspansi Kofaktor");
    System.out.println("3. Metode Sarrus");
    System.out.print("Masukan pilihan: ");
    int i = sc.nextInt();

    switch (i) {
      case 1:
        Determinan.displayOBE(m);
        break;
      case 2:
        Determinan.displayEkspansiKofaktor(m);
        break;
      case 3:
        Determinan.displaySarrus(m); 
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public void InverseKeyboard() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss-Jordan");
    System.out.println("2. Metode Adjoint");
    System.out.print("Masukan pilihan: ");
    int i = sc.nextInt();

    switch (i) {
      case 1:
        Inverse.displayGaussJordan(m);
        break;
      case 2:
        Inverse.displayInverseAdjoint(m);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public void TransposeKeyboard() {
    System.out.println("");
    System.out.println("Transpose dari matriks tersbeut adalah: ");
    Operation.transpose(m).displayMatrix();
  }

  public void InterpolasiKeyboard() {
    System.out.println("");
    System.out.println("Hasil interpolasi data tersebut adalah: ");
    Interpolasi.keluarkanInterpolasi(m);
  }

  public void RegresiKeyboard() {
    System.out.println("");
    System.out.print("Masukkan jumlah titik data yang ingin dipredikasi: ");
    int x = sc.nextInt();

    RLB.outputRLB(m, x);
  }

  public void io(){
    System.out.println("Pilih file yang akan dibaca!");
    IO.printListDir();

    File[] listFiles = IO.getListDir();

    System.out.print("Masukan pilihan: ");

    int q = sc.nextInt();

    m = IO.readMatrix(listFiles[q - 1].getName());
  }

  public void exit(){
    System.out.println("\nTerima kasih telah menggunakan matrix calculator!");
    sc.close();
    System.exit(0);
  }
}
