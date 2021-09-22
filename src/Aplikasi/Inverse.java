package Aplikasi;

import Matrix.Matrix;
import Matrix.Operation;

public class Inverse {
    public static Matrix matrikskofaktor(Matrix a){
        Matrix b = new Matrix(a.getRow(), a.getCol());
        for(int i = 0; i < a.getRow(); i++){
          for(int j = 0; j < a.getCol(); j++){
            b.setElmt(i, j, Determinan.kofaktor(a, i, j));
          }
        }
        return b;
      }
    
    public static Matrix adjoint(Matrix a){
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = matrikskofaktor(a);
        b = Operation.transpose(b);
        return b;
      }

    public static Matrix inverseAdjoint(Matrix a){
      double det = Determinan.ekspansiKofaktor(a);
      if (det==0){
        return null;
      }
      else{
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = adjoint(a);
        for (int i=0;i<a.getRow();i++){
            Operation.rowTimesK(b, 1/det, i);
        }
        return b;
      }
    } 
}
