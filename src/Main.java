import Utility.*;
import Aplikasi.RLB;
import Matrix.*;

public class Main{
  public static void main(String[] args) {
    // Menu.menuLoop();
    Matrix m = new Matrix();
    m = IO.readMatrix("7.txt");
    // m = RLB.convertRLBMatrix(m);
    // m.displayMatrix();
    RLB.keluarkanRLB(m);
    RLB.outputRLB(m, 3);
    // m = IO.readMatrix("regresi.txt");
    // m.displayMatrix();
    // m = RLB.convertRLBMatrix(m);
    // m.displayMatrix();
  }
}