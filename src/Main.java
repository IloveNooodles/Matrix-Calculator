import java.io.File;

import Aplikasi.RLB;
import Matrix.*;
import Utility.*;

public class Main{
  public static void main(String[] args) {
    // Menu.menuLoop();
    Matrix a = new Matrix();
    a = IO.readMatrix("regresi.txt");
    System.out.println(Operation.sumCol(a, 0));
    a = RLB.convertRLBMatrix(a);
    a.displayMatrix();
  }
}