import Matrix.*;
import Utility.*;
import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    File[] dir = IO.getListDir();
    Scanner sc = new Scanner(System.in);
    Menu.io();
    System.out.print("Masukan Pilihan: ");
    int i = sc.nextInt();
    Matrix m = IO.readMatrix(dir[i-1].getName());
    m.displayMatrix();
    IO.writeFile("garegaming", m);
    sc.close();
  }
}