package Aplikasi;

import Matrix.*;
import java.util.Scanner;

public class RLB {
  public static Matrix convertRLBMatrix(Matrix m){
    /* KAMUS */
    int n, k, i, j;
    Matrix rlbX, rlbY, rlb;

    /* ALGORITMA */
    n = m.getRow();
    k = m.getCol();

    rlbX = new Matrix(k, k);
    for(i = 0; i < rlbX.getRow(); i++){
      for(j = 0; j < rlbX.getCol(); j++){
        if(i == 0 && j == 0){
          rlbX.setElmt(i, j, n);
        }else if(i == 0){
          rlbX.setElmt(i, j, Operation.sumCol(m, j-1));
        }else if(i != 0 && j == 0){
          rlbX.setElmt(i, j, Operation.sumCol(m, i-1));
        }else {
          rlbX.setElmt(i, j, Operation.sumColTCol(m, i-1, j-1));
        }
      }
    }
    
    rlbY = new Matrix(k, 1);
    for (i = 0; i < rlbY.getRow(); i++) {
      if (i == 0) {
        rlbY.setElmt(i, 0, Operation.sumCol(m, m.getCol() - 1));
      } else {
        rlbY.setElmt(i, 0, Operation.sumColTCol(m, i - 1, m.getCol() - 1));
      }
    }

    rlb = new Matrix();
    rlb = rlb.copyMatrix(Operation.augmentedMatrix(rlbX, rlbY));

    return SistemPersamaanLinear.SPLGaussJordan(rlb);

  }

  public static Matrix inputRLB(int k) {
    /* KAMUS */
    Matrix m;
    double elmt;

    /* ALGORITMA */
    Scanner sc = new Scanner(System.in);
    m = new Matrix(k, k + 1);

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k + 1; j++) {
        if (j == k) {
          System.out.print("Nilai y ke-" + (i + 1) + " : ");
          elmt = sc.nextDouble();
          m.setElmt(i, j, elmt);
        } else {
          System.out.print("Nilai x" + (j + 1) + " ke-" + (i + 1) + " : ");
          elmt = sc.nextDouble();
          m.setElmt(i, j, elmt);
        }
      }
    }

    sc.close();

    return convertRLBMatrix(m);
  }
}
