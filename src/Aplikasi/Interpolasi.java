package Aplikasi;

import Matrix.Matrix;
import Utility.IO;

public class Interpolasi {
    public static Matrix masukkanInterpolasi(int n) {
        Matrix a = new Matrix(n, n + 1);
        Matrix inputData = new Matrix(n, 2);
        inputData.createMatrix();

        for (int i=0;i<n;i++){
            double x = inputData.getElmt(i, 0);
            double y = inputData.getElmt(i, 1);
            a.setElmt(i, n, y);
            for (int j=0;j<n;j++){
                a.setElmt(i, j, Math.pow(x, j));
            }
        }
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
        for (int k=0;k < b.getRow();k++){
            if (b.getElmt(k, n - 1) == 0) {
                continue;
            }
            else if(k==0){
                System.out.print(String.format("%.4f", b.getElmt(k,n-1)));
            }
            else if(k==1){
                System.out.print((b.getElmt(k-1, n-1) == 0 ? "" : " + ") + String.format("(%.4f)" + "x", b.getElmt(k, n-1)));
            }
            else {
                System.out.print((b.getElmt(k-1, n-1) == 0 ? "" :" + ") + String.format("(%.4f)" + "x^" + k, b.getElmt(k, n-1)));
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
          System.out.print(String.format(b.getElmt(i-1, 0) == 0 ? "" : " + " + "(%.4f)x", b.getElmt(i, 0)) + "x");
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
      Matrix inputData = new Matrix(a.getRow(), 1);
      inputData = getAnsInterpolasi(a);
      double y = 0;
      for (int k = 0; k < a.getRow(); k++) {
          y += inputData.getElmt(k, 0) * Math.pow(x, k);
      }
      System.out.println(String.format("Taksiran nilai f(%.4f) ialah: %.4f", x, y));
    }

    public static void fileInterpolasi(Matrix a, String namaFile) {
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = SistemPersamaanLinear.MatrixGaussJordan(a);

        String tempString = "";
        tempString += "f(x) = ";
        for (int k=0;k < b.getRow();k++){
            if (b.getElmt(k, n - 1) == 0) {
                continue;
            }
            else if(k==0){
                tempString += String.format("%.4f", b.getElmt(k,n-1));
            }
            else if(k==1){
                tempString += (b.getElmt(k-1, n-1) == 0 ? "" :" + ") + String.format("(%.4f)" + "x", b.getElmt(k, n-1));
            }
            else {
                tempString += (b.getElmt(k-1, n-1) == 0 ? "" :" + ") + String.format("(%.4f)" + "x^" + k, b.getElmt(k, n-1));
            }
        }
        tempString += "\n";

        IO.writeFileString(namaFile, tempString);
    }
}
