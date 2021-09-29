import Aplikasi.Crammer;
import Aplikasi.Interpolasi;
import Matrix.Matrix;
import Utility.*;
import Aplikasi.RLB;
import Matrix.*;

public class Main{
  public static void main(String[] args) {
    Matrix m = IO.readMatrix("6_b.txt");
    m.displayMatrix();
    Matrix c = new Matrix();
    Matrix ans = new Matrix();
    ans = Interpolasi.MatrixToMatrixInterpolasi(m);
    // ans.displayMatrix();

    // ans = Crammer.matrixCrammer(ans);
    // ans.displayMatrix();
    Interpolasi.keluarkanInterpolasiCrammer(ans);
    System.out.println("\n");
    // Interpolasi.outputInterpolasi(ans, 5.806);
    // c = Interpolasi.keluarkanInterpolasi(m);
    
  }
}