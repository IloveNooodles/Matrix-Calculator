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

    public static Matrix keluarkanInterpolasi(Matrix a) {
        Scanner sc = new Scanner(System.in);
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        Matrix ans = new Matrix(a.getRow(),1);
        b = SistemPersamaanLinear.MatrixGaussJordan(a);
        for (int k=0;k<n-1;k++){
            if(k==0){
                System.out.print(String.format("%.4f", b.getElmt(k,n-1)));
            }
            else if(k==1){
                System.out.print(String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x");
            }
            else {
                System.out.print(String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x^" + k);
            }
        }
        for (int i=0;i<a.getRow();i++){
            ans.setElmt(i, 0, b.getElmt(i, n-1));
        }
        return ans;
    }

    public static void fileInterpolasi(Matrix a, String namaFile) {
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = SistemPersamaanLinear.MatrixGaussJordan(a);
        for (int k=0;k<n-1;k++){
            if(k==0){
                IO.writeFileString(namaFile, String.format("%.4f", b.getElmt(k,n-1)));
            }
            else if(k==1){
                IO.writeFileString(namaFile, String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x");
            }
            else {
                IO.writeFileString(namaFile, String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x^" + k);
            }
        }
    }
}
