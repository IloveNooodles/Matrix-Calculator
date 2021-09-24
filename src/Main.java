import Matrix.*;
import Utility.*;
import Aplikasi.*;
import java.io.*;
import java.util.Scanner;
import Aplikasi.RLB;

public class Main{
  public static void main(String[] args) {
    // Matrix a = IO.readAugmentMatrix("1spl_a.txt");
    // Matrix ans = SistemPersamaanLinear.SPLGaussJordan(a);
    //NOTE tentuin ini logicnya mau di main nya apa di menu nya aja biar literally pendek gitu di sininya oke makasih
    //Menu.mainMenu();

    Matrix m = new Matrix(4, 7);
    m.createMatrix();
    //RLB.convertRLBMatrix(m).displayMatrix();
    Matrix n = new Matrix(4,7);
    n = SistemPersamaanLinear.SPLGaussJordan(m);
    n.displayMatrix();
  }
}