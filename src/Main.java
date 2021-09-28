import java.io.File;
import Aplikasi.RLB;
import Matrix.*;
import Utility.*;

public class Main{
  public static void main(String[] args) {
    // Menu.menuLoop();
    Matrix a = new Matrix();
    a = IO.readMatrix("1spl_a.txt");
    a.displayMatrix();
    Operation.rowReduction(a, 1, 2, 0);
    a.displayMatrix();
  }
}