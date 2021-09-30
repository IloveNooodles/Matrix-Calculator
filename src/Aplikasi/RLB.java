package Aplikasi;

import Matrix.*;
import Utility.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        }else if(j == 0){
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
    // return rlb;
    return SistemPersamaanLinear.MatrixGaussJordan(rlb);

  }

  public static void keluarkanRLB(Matrix m) {
    /* KAMUS */
    int i;
    Matrix n;
    /* ALGORITMA */
    n = new Matrix(m.getRow(), m.getCol());
    n = convertRLBMatrix(m);

    System.out.println("Fungsi Regresi Linear Berganda: ");
    System.out.print("y = ");
    for (i = 0; i < n.getCol() - 1; i++) {
      if (n.getElmt(i, n.getCol() - 1) == 0) {
        continue;
      }
      else if (i == 0) {
        System.out.print(String.format("(%.4f)", n.getElmt(i, n.getCol() - 1)));
      }
      else {
        System.out.print(String.format(n.getElmt(i - 1, n.getCol() - 1) == 0 ? "" : " + " + "(%.4f)", n.getElmt(i, n.getCol() - 1)) + "x" + i);
      }
    }

  }

  public static void outputRLB(Matrix m, int x) {
    /* KAMUS */
    int i;
    double y;
    Matrix n;
    InputStreamReader streamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(streamReader);
    /* ALGORITMA */
    
    n = new Matrix(m.getRow(), m.getCol());
    n = convertRLBMatrix(m);

    y = n.getElmt(0, n.getCol() - 1);
    for(i = 0; i < x; i++){
      double b = 0;
      System.out.print(String.format("Masukan nilai x%d: ", i+1));
      try {
        b = Double.parseDouble(bufferedReader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
      y += b*n.getElmt(i+1, n.getCol() - 1);
    }
    System.out.println(String.format("\nPrediksi nilai y dari regresi linear adalah : %,.4f", y));
  }

  public static void fileRLB(Matrix m, String namaFile) {
    /* KAMUS */
    int i;
    Matrix n;
    String tempString;

    /* ALGORITMA */

    n = new Matrix(m.getRow(), m.getCol());
    n = convertRLBMatrix(m);

    tempString = "";
    tempString += "y = ";
    for (i = 0; i < n.getCol() - 1; i++) {
      if (n.getElmt(i, n.getCol() - 1) == 0) {
        continue;
      }
      else if (i == 0) {
        tempString += String.format("%.4f", n.getElmt(i, n.getCol() - 1));
      }
      else {
        tempString += String.format(" + " + "(%.4f)", n.getElmt(i, n.getCol() - 1)) + "x" + i;
      }
    }
    tempString += "\n";

    IO.writeFileString(namaFile, tempString);
  }
}