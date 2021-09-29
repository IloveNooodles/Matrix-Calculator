package Aplikasi;

import Matrix.*;
import Utility.*;
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

  public static Matrix inputRLB(int n, int k) {
    /* KAMUS */
    Matrix m;
    double elmt;

    /* ALGORITMA */
    Scanner sc = new Scanner(System.in);
    m = new Matrix(n, k + 1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k + 1; j++) {
        if (j == k) {
          elmt = sc.nextDouble();
          m.setElmt(i, j, elmt);
        } else {
          elmt = sc.nextDouble();
          m.setElmt(i, j, elmt);
        }
      }
    }

    sc.close();
    return m;
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
    Scanner sc = new Scanner(System.in);
    /* ALGORITMA */
    
    n = new Matrix(m.getRow(), m.getCol());
    n = convertRLBMatrix(m);
    
    System.out.println("\nAkan dicek prediksi nilai y dengan memasukan nilai x");

    y = n.getElmt(0, n.getCol() - 1);
    for(i = 0; i < x; i++){
      System.out.print(String.format("Masukan nilai x%d: ", i+1));
      double b = sc.nextDouble();
      y += b*n.getElmt(i+1, n.getCol() - 1);
    }
    System.out.println(String.format("\nPrediksi nilai y dari regresi linear adalah : %,.4f", y));
    sc.close();
  }

  public static void fileRLB(Matrix m, int x, String namaFile) {
    /* KAMUS */
    int i;
    double y;
    Matrix inputData, n;
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
        tempString += String.format(n.getElmt(i - 1, n.getCol() - 1) == 0 ? "" : " + " + "(%.4f)", n.getElmt(i, n.getCol() - 1)) + "x" + i;
      }
    }
    tempString += "\n";

    inputData = new Matrix(1, n.getRow());

    while (x > 0) {
      inputData.createMatrix();
      y = n.getElmt(0, n.getCol() - 1);
      for (i = 1; i < n.getRow();i++) {
        y += inputData.getElmt(0, i - 1) * n.getElmt(i, n.getCol() - 1);
      }
      tempString += String.format("%.4f", y) + "\n";
      x--;
    }

    IO.writeFileString(namaFile, tempString);
  }
}