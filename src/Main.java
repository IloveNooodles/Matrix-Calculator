import Aplikasi.Interpolasi;
import Matrix.Matrix;
import Utility.*;

public class Main{
  public static void main(String[] args) {
    Matrix m = new Matrix(7, 8);
    Matrix c = new Matrix (7,1);
    m = Interpolasi.masukkanInterpolasi(7);
    //c = Interpolasi.keluarkanInterpolasi(m);
    Interpolasi.outputInterpolasi(m,3); 
  }
}