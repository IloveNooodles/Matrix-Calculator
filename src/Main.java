<<<<<<< HEAD
=======
import java.io.File;
import Aplikasi.RLB;
import Matrix.*;
>>>>>>> 8551149325e00c2f97c420572942d5128cd3e816
import Utility.*;

public class Main{
  public static void main(String[] args) {
<<<<<<< HEAD
    Menu.menuLoop();
=======
    // Menu.menuLoop();
    Matrix a = new Matrix();
    a = IO.readMatrix("1spl_a.txt");
    a.displayMatrix();
    Operation.rowReduction(a, 1, 2, 0);
    a.displayMatrix();
>>>>>>> 8551149325e00c2f97c420572942d5128cd3e816
  }
}