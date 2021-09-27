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

    public static void displayInverseAdjoint(Matrix m) {
      Matrix n = inverseAdjoint(m);
      if (n == null) {
        System.out.println("Matriks tidak mempunyai balikan");
      } else {
        System.out.println("Balikan dari matriks tersebut adalah: ");
        n.displayMatrix();
      }
    }

    public static Matrix eliminasiGaussJordan(Matrix a) {
      /* KAMUS */
      Matrix mAug, I, mHasil;
      int i, j, idxMax;

      /* ALGORITMA */

      mAug = new Matrix();
      I = new Matrix(a.getRow(), a.getCol());
      mHasil = new Matrix(a.getRow(), a.getCol());

      I.createIdentityMatrix();
      mAug = mAug.copyMatrix(Operation.augmentedMatrix(a, I));

      for (j = 0; j < a.getCol(); j++) {

        idxMax = j;

        for (i = j + 1; i < a.getRow(); i++) {
          idxMax = Math.abs(mAug.getElmt(i, j)) > Math.abs(mAug.getElmt(idxMax, j)) ? i : idxMax;
        }

        if (Math.abs(mAug.getElmt(idxMax, j)) == 0) {
          return null;
        }

        Operation.swapRow(mAug, idxMax, j);

        for (i = 0; i < a.getRow(); i++) {
          if (i == j) {
            continue;
          }
          Operation.rowReduction(mAug, j, i, j);
        }

        Operation.rowTimesK(mAug, 1 / mAug.getElmt(j, j), j);

      }

      for (i = 0; i < a.getRow(); i++) {
        for (j = 0; j < a.getCol(); j++) {
          mHasil.setElmt(i, j, mAug.getElmt(i, j + a.getCol()));
        }
      }

      return mHasil;
    }

    public static void displayGaussJordan(Matrix m) {
      Matrix n = eliminasiGaussJordan(m);
      if (n == null) {
        System.out.println("Matriks tidak mempunyai balikan");
      } else {
        System.out.println("Balikan dari matriks tersebut adalah: ");
        n.displayMatrix();
      }
    }
}
