import Matrix.*;
import Utility.*;
import Aplikasi.*;
import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Matrix a = IO.readAugmentMatrix("1spl_a.txt");
    Matrix ans = SistemPersamaanLinear.SPLGaussJordan(a);
  }
}