import java.util.Scanner;
import Matrix.*;

public class Main{
  public static void main(String[] args) {
    Matrix a = new Matrix(3, 3);
    // Matrix b = new Matrix(2, 2);
    a.createMatrix();
    // b.createIdentityMatrix();
    // System.out.println(a.isIdentity());
    // System.out.println(b.isIdentity());
    Operation.rowReduction(a, 0, 1);
    Operation.rowReduction(a, 0, 2);
    a.displayMatrix();
    Operation.rowReduction(a, 1, 2);
    Operation.rowTimesK(a, 1/a.getElmt(0, 0), 0);
    Operation.rowTimesK(a, 1/a.getElmt(1, 1), 1);
    Operation.rowTimesK(a, 1/a.getElmt(2, 2), 2);
    // Operation.rowReduction(a, 1, 2);
    a.displayMatrix();
  }

  public static void menu() {
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

  public static void inputMenu() {
    System.out.println("");
    System.out.println("###### Pilih jenis input ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void outputMenu() {
    System.out.println("");
    System.out.println("###### Pilih jenis output ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void menuSPL() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Elimnasi Gauss");
    System.out.println("2. Metode Elimnasi Gauss-Jordan");
    System.out.println("3. Metode Matriks Balikan");
    System.out.println("4. Kaidah Cramer");
    System.out.println("5. Keluar");
    System.out.print("Masukan pilihan: ");
  }
  public static void menuDeterminan() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Elimnasi Gauss");
    System.out.println("2. Metode ekspansi kofaktor");
    System.out.println("3. Metode Sarrus");
    System.out.println("4. Keluar");
    System.out.print("Masukan pilihan: ");
  }
}