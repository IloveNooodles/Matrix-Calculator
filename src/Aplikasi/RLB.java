package Aplikasi;

import Matrix.*;

public class RLB {
  public static Matrix convertRLBMatrix(Matrix m){
    //NOTE sebanyak n data dan k variabel akan dibentuk k x k matrix. Matrix y berupa kolom y dan matri x berupa n*k-1 matrix
    int n = m.getRow();
    int k = m.getCol();
    Matrix y = new Matrix(), x = new Matrix();
    Operation.splitRLBMatrix(m, y, x);
    Matrix rlb = new Matrix(k, k);
    for(int i = 0; i < rlb.getRow(); i++){
      for(int j = 0; j < rlb.getCol(); j++){
        if(i == 0 && j == 0){
          rlb.setElmt(i, j, n);
        }else if(i == 0){
          rlb.setElmt(i, j, Operation.sumCol(x, j-1));
        }else if(i != 0 && j == 0){
          rlb.setElmt(i, j, Operation.sumCol(x, i-1));
        }else if(i != 0 && j != 0){
          rlb.setElmt(i, j, Operation.sumColTCol(x, i-1, j-1));
        }
      }
    }
    return rlb;
  }
}
