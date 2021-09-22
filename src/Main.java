import Matrix.*;
import Utility.*;
import Aplikasi.*;
import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Matrix a = new Matrix(4, 4);
    Matrix b = new Matrix(4, 1);
    a.createMatrix();
    b.createMatrix();
    Crammer.crammer(a, b);
  }
}