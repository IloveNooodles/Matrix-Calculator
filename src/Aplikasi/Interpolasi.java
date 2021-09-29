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
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        Matrix ans = new Matrix(a.getRow(),1);
        b = SistemPersamaanLinear.MatrixGaussJordan(a);

        System.out.print("y = ");
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
        for (int i=0;i<ans.getRow();i++){
            ans.setElmt(i, 0, b.getElmt(i, n-1));
        }
        return ans;
    }

    public static void outputInterpolasi(Matrix a, int x) {
        int n = a.getCol();
        Scanner sc = new Scanner(System.in);
        Matrix inputData = new Matrix(a.getRow(), 1);
        inputData = keluarkanInterpolasi(a);
        while (x > 0) {
            double y = 0;
            double tc = sc.nextDouble();
            for (int k = 0; k < a.getRow(); k++) {
                y += inputData.getElmt(k, 0) * Math.pow(tc, k);
            }
            System.out.println("Prediksi nilai y dari interpolasi adalah : " + String.format("%.4f", y));
            x--;
        }
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
