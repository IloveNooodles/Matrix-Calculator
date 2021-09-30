package Aplikasi;

import java.util.Scanner;

import Matrix.Matrix;
import Utility.IO;

public class Interpolasi {
    public static Matrix masukkanInterpolasi(int n) {
        Matrix a = new Matrix(n, n+1);

        Scanner sc = new Scanner(System.in);
        for (int i=0;i<n;i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            a.setElmt(i, n, y);
            for (int j=0;j<n;j++){
                a.setElmt(i, j, Math.pow(x, j));
            }
        }
        sc.close();
        return a;
    }

    //NOTE ini buat ngerubah dari bentuk file ke matrix interpolasi
    public static Matrix MatrixToMatrixInterpolasi(Matrix m){
      int n = m.getRow();
      Matrix b = new Matrix(n, n+1);
      for(int i = 0; i < n; i++){
        b.setElmt(i, n, m.getElmt(i, m.getCol() - 1));
        for(int j = 0; j < n; j++){
          b.setElmt(i, j, Math.pow(m.getElmt(i, 0), j));
        }
      }
      return b;
    }
    //NOTE ini cuma buat ngeprint fungsinya
    public static void keluarkanInterpolasi(Matrix a) {
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = SistemPersamaanLinear.MatrixGaussJordan(a);
        System.out.println("\nPolinom interpolasi yang melewati titik-titik tersebut ialah: ");
        System.out.print("f(x) = ");
        for (int k=0;k<n-1;k++){
            if (b.getElmt(k, n - 1) == 0) {
                continue;
            }
            else if(k==0){
                System.out.print(String.format("%.4f", b.getElmt(k,n-1)));
            }
            else if(k==1){
                System.out.print(String.format(b.getElmt(k - 1, n - 1) == 0 ? "" : " + " + "(%.4f)", b.getElmt(k, n-1)) + "x");
            }
            else {
                System.out.print(String.format(b.getElmt(k - 1, n - 1) == 0 ? "" : " + " + "(%.4f)", b.getElmt(k, n-1)) + "x^" + k);
            }
        }
    }

    /*public static void keluarkanInterpolasiCrammer(Matrix a){
      Matrix b = new Matrix();
      b = Crammer.matrixCrammer(a);
      for(int i = 0; i < b.getRow(); i++){
        if(i == 0){
          System.out.print(String.format("%.4f", b.getElmt(i,0)));
        }
        else if(i == 1){
          System.out.print(String.format(b.getElmt(i-1, 0) == 0 ? "" : " + " + "(%.4f)", b.getElmt(i, 0)) + "x");
        }else{
          System.out.print(String.format(b.getElmt(i-1, 0) == 0 ? "" : " + " + "(%.4f)", b.getElmt(i, 0)) + "x^" + i);
        }
      }
    }*/

    //NOTE ini buat ngedapetin array answernya
    public static Matrix getAnsInterpolasi(Matrix a){
      int n = a.getCol();
      Matrix b = new Matrix(a.getRow(), a.getCol());
      Matrix ans = new Matrix(a.getRow(),1);
      b = SistemPersamaanLinear.MatrixGaussJordan(a);
      // b = Crammer.matrixCrammer(a);
      for (int i=0;i<ans.getRow();i++){
          ans.setElmt(i, 0, b.getElmt(i, n-1));
      }
      return ans;
    }
    
    //NOTE x ini sebagai input nilainya misal mau nyari f(2) berarti x nya 2
    public static void outputInterpolasi(Matrix a, double x) {
      Scanner sc = new Scanner(System.in);
      Matrix inputData = new Matrix(a.getRow(), 1);
      inputData = getAnsInterpolasi(a);
      double y = 0;
      for (int k = 0; k < a.getRow(); k++) {
          y += inputData.getElmt(k, 0) * Math.pow(x, k);
      }
      System.out.println(String.format("\nTaksiran nilai f(%f) ialah: %f", x, y));
      sc.close();
    }

    public static void fileInterpolasi(Matrix a, int x, String namaFile) {
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = SistemPersamaanLinear.MatrixGaussJordan(a);

        String tempString = "";
        tempString += "y = ";
        for (int k=0;k<n-1;k++){
            if (b.getElmt(k, n - 1) == 0) {
                continue;
            }
            else if(k==0){
                tempString += String.format("%.4f", b.getElmt(k,n-1));
            }
            else if(k==1){
                tempString += String.format(b.getElmt(k - 1, n - 1) == 0 ? "" : " + " + "(%.4f)", b.getElmt(k, n-1)) + "x";
            }
            else {
                tempString += String.format(b.getElmt(k - 1, n - 1) == 0 ? "" : " + " + "(%.4f)", b.getElmt(k, n-1)) + "x^" + k;
            }
        }
        tempString += "\n";

        Matrix inputData = new Matrix(1, b.getRow());

        while (x > 0) {
            double y = 0;
            inputData.createMatrix();
            for (int k = 0; k < n - 1; k++) {
                y += b.getElmt(k, n - 1) * Math.pow(inputData.getElmt(0, k), k);
            }
            tempString += String.format("%.4f", y) + "\n";
            x--;
        }

        IO.writeFileString(namaFile, tempString);
    }
}
