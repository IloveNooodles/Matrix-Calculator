import Utility.*;
import Aplikasi.RLB;
import Matrix.*;

@SuppressWarnings("all")
public class Main{
  public static void main(String[] args) {
    // Menu.menuLoop();
    Matrix m = new Matrix(3, 3);
    m.createMatrix();
    m.displayMatrix();
    // m = IO.readMatrix("regresi.txt");
    // m.displayMatrix();
    // m = RLB.convertRLBMatrix(m);
    // m.displayMatrix();
  }
}