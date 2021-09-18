import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    menu();
    byte i = sc.nextByte();
    byte j;
    while(i < 1 && i > 6){
      System.out.println("Masukan pilihan yang benar");
    }
    if(i == 3){
      menuDeterminan();
      j = sc.nextByte();
      inputMenu();
    }else if(i == 5){
      menuSPL();
      j = sc.nextByte();
      inputMenu();
      j = sc.nextByte();
    }
    sc.close();
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
    System.out.print("Masukan pilihan: ");
  }
  public static void menuDeterminan() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Elimnasi Gauss");
    System.out.println("2. Metode ekspansi kofaktor");
    System.out.println("3. Metode Sarrus");
    System.out.print("Masukan pilihan: ");
  }
}