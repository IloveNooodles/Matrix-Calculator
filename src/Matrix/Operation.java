package Matrix;

public class Operation {

  public static Matrix addMatrix(Matrix a, Matrix b){
    Matrix c = new Matrix(a.getRow(), a.getCol());
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < a.getCol(); j++){
        c.setElmt(i, j, (a.getElmt(i, j) + b.getElmt(i, j)));
      }
    }
    return c;
  }
  
  public static Matrix subtractMatrix(Matrix a, Matrix b){
    Matrix c = new Matrix(a.getRow(), a.getCol());
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < a.getCol(); j++){
        c.setElmt(i, j, (a.getElmt(i, j) - b.getElmt(i, j)));
      }
    }
    return c;
  }

  public static double timesRowCol(Matrix a, Matrix b, int row, int col){
    double ans = 0;
    for(int i = 0; i < a.getCol(); i++){
      ans += a.getElmt(row, i) * b.getElmt(i, col);
    }
    return ans;
  }

  public static Matrix multMatrix(Matrix a, Matrix b){
    Matrix c = new Matrix(a.getRow(), b.getCol());
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < b.getCol(); j++){
        double elmt = Operation.timesRowCol(a, b, i, j);
        c.setElmt(i, j, elmt);
      }
    }
    return c;
  }

  //mengalikan baris dengan konstanta k
  public static void rowTimesK(Matrix a, double k, int row){
    for(int i = 0; i < a.getCol(); i++){
      a.setElmt(row, i, k*a.getElmt(row, i));
    }
  }
  //menukar kolom 1 dengan kolom2
  public static void swapRow(Matrix a, int row1, int row2){
    double temp;
    for(int i = 0; i < a.getCol(); i++){
      temp = a.getElmt(row1, i);
      a.setElmt(row1, i, a.getElmt(row2, i));
      a.setElmt(row2, i, temp);
    }
  }
  public static void swapCol(Matrix a, int col1, int col2){
    double temp;
    for(int i = 0; i < a.getRow(); i++){
      temp = a.getElmt(i, col1);
      a.setElmt(i, col1, a.getElmt(i, col2));
      a.setElmt(i, col2, temp);
    }
  }

  public static Matrix transpose(Matrix a){
    Matrix b = new Matrix(a.getCol(), a.getRow());
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < a.getCol(); j++){
        b.setElmt(j, i, a.getElmt(i, j));
      }
    }
    return b;
  }
  //row 2 - row 1
  public static void rowReduction(Matrix a, int row1, int row2, int col){
    double anchor = a.getElmt(row2, col)/a.getElmt(row1, col);
    for(int i = 0; i < a.getCol(); i++){
      double elmt = a.getElmt(row2, i) - anchor * a.getElmt(row1, i);
      a.setElmt(row2, i, elmt);
    }
  }
}
