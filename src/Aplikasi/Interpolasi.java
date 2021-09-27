package Aplikasi;

import java.util.Scanner;

import Matrix.Matrix;

public class Interpolasi {
    public static void interpolasi(int n){
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
        Matrix b = new Matrix();
        b = SistemPersamaanLinear.SPLGaussJordan(a);
        for (int k=0;k<n;k++){
            if(k==0){
                System.out.print(String.format("%.4f", b.getElmt(k,n)));
            }
            else{
                System.out.print(String.format("+ " + "%.4f", b.getElmt(k, n)) + "x^" + k);
            }
        }
        sc.close();
    }
}
