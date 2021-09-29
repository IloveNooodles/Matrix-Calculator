package Aplikasi;

import Matrix.Matrix;
import Matrix.Operation;
import Utility.IO;

public class SistemPersamaanLinear {
    public static boolean IsEmpty (double[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static String ToString(double[] m){
        String variabel = "abcdefghijklmnopqrstuvwxyz";
        String ans = "";
        Operation.setPrecisionArray(m, 4);
        for (int i=1;i<m.length;i++){
            if(Math.abs(m[i])>=1.00e-4){
                if (ans==""){
                    if(Math.abs(m[i]-1)<=1.00e-4){
                        ans = variabel.substring(i-1, i);
                    }
                    else if(Math.abs(m[i]+1)<=1.00e-4){
                        ans = "-" + variabel.substring(i-1, i);
                    }
                    else{
                        ans = String.format("%.2f", m[i]) + variabel.substring(i-1, i);
                    }
                }
                else{
                    if (m[i] > 0) {
                        if (Math.abs(m[i]-1)<=1.00e-4) {
                            ans += " + " + variabel.substring(i-1, i);
                        } 
                        else {
                            ans += " + " + String.format("%.2f", m[i]) + variabel.substring(i-1, i);
                        }
                    } 
                    else {
                        if (Math.abs(m[i]+1)<=1.00e-4) {
                            ans += " - " + variabel.substring(i-1, i);
                        } else {
                            ans += " - " + String.format("%.2f", m[i]*(-1)) + variabel.substring(i-1, i);
                        }
                    }
                }
            }
        }
        if(Math.abs(m[0])>=1.00e-4){
            if(ans==""){
                ans = String.format("%.2f", m[0]);
            }
            else{
                if(m[0]>=1.00e-4){
                    ans += " + " + String.format("%.2f", m[0]);
                }
                else{
                    ans += " - " + String.format("%.2f", m[0]*(-1));
                }
            }
        }
        else{
            if(ans==""){
                ans = "0";
            }
        }
        return ans;
    }

    public static Matrix MatrixGaussJordan(Matrix m) {
        /* KAMUS */
        Matrix n;
        int i, j, idxMax, row;

        /* ALGORITMA */

        n = new Matrix();
        n = n.copyMatrix(m);

        row = 0;
        for (j = 0; j < n.getCol() - 1; j++) {

            if (row == n.getRow()) {
                break;
            }

            idxMax = row;
            for (i = row + 1; i < n.getRow(); i++) {
                idxMax = Math.abs(n.getElmt(i, j)) > Math.abs(n.getElmt(idxMax, j)) ? i : idxMax;
            }

            if (Math.abs(n.getElmt(idxMax, j)) == 0) {
                continue;
            }

            Operation.swapRow(n, idxMax, row);

            for (i = 0; i < n.getRow(); i++) {
                if (i == row) {
                    continue;
                }

                Operation.rowReduction(n, row, i, j);
            }

            Operation.rowTimesK(n, 1 / n.getElmt(row, j), row);

            row++;
        }

        return n;
    }
    
    public static void SPLinverse(Matrix m){
        Matrix a = new Matrix(m.getRow(),m.getCol()-1);
        Matrix b = new Matrix(m.getRow(),1);
        Operation.splitAugmentedMatrix(m, a, b);
        if(a.isSquare()){
            double det = Determinan.ekspansiKofaktor(a);
            if (det==0){
                System.out.println("Sistem tidak bisa diselesaikan dengan inverse matriks");
                return;
            }
            else{
                a = Operation.multMatrix(Inverse.inverseAdjoint(a), b);
                for (int i=0;i<a.getRow();i++){
                    System.out.println("x" + i + " = " + String.format("%.4f", a.getElmt(i, 0)));
                }
            }
        }
    }

    public static void FileSPLinverse(Matrix m, String namaFile) {
        Matrix a = new Matrix(m.getRow(),m.getCol()-1);
        Matrix b = new Matrix(m.getRow(),1);
        Operation.splitAugmentedMatrix(m, a, b);
        if(a.isSquare()){
            double det = Determinan.ekspansiKofaktor(a);
            if (det==0){
                IO.writeFileString(namaFile, "Sistem tidak bisa diselesaikan dengan inverse matriks");
                return;
            }
            else{
                a = Operation.multMatrix(Inverse.inverseAdjoint(a), b);
                String tempString = "";
                for (int i=0;i<a.getRow();i++){
                    tempString += "x" + i + " = " + String.format("%.4f", a.getElmt(i, 0)) + "\n";
                }
                IO.writeFileString(namaFile, tempString);
            }
        }
    }

    public static Matrix matrixGauss (Matrix m){
        //REVIEW cek kalau matrixGaussnya gajadi matriks segitiga.
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        int utama = 0;
        for (int i=0;i<n.getCol();i++){
            int max = utama;
            for (int j=utama+1;j<n.getRow();j++){
                if (Math.abs(n.getElmt(j, i)) > Math.abs(n.getElmt(max, i))){
                    max = j;
                }
            }
            if (Math.abs(n.getElmt(max, i))==0){
                continue;
            }
            else{
                Operation.swapRow(n, utama, max);
                Operation.rowTimesK(n, 1/(n.getElmt(utama, i)), utama);
                for (int k=utama+1;k<n.getRow();k++){
                    Operation.rowReduction(n, utama, k, i);
                }
                utama = utama + 1;
            }
            if (utama==n.getRow()-1){
                for (int x=i+1;x<n.getCol();x++){
                    if(Math.abs(n.getElmt(utama, x))>1.00e-4){
                        Operation.rowTimesK(n, 1/(n.getElmt(utama, x)), utama);
                        break;
                    }
                }
                break;
            }
        }
        return n;
    }
    public static void SPLGauss(Matrix m){
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        m = matrixGauss(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
        for (int i=m.getRow()-1;i>=0;i--){
            int found = -1;
            double[] hasil = new double[27];
            for (int j=0;j<m.getCol();j++){
                if(Math.abs(m.getElmt(i, j))>=1.00e-4){
                    if(j==m.getCol()-1){
                        hasil[0] += m.getElmt(i, j);
                    }
                    else{
                        if(IsEmpty(solusi[j])){
                            if(found!=-1){
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1)*m.getElmt(i, j);
                                variabel+=1;
                            }
                            else{
                                found = j;
                            } 
                        }
                        else{
                            for (int k=0;k<27;k++){
                                hasil[k] = hasil[k] - solusi[j][k]*m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
            if(found==-1){
                if(Math.abs(m.getElmt(i, m.getCol()-1))>=1.00e-4){
                    noSolution = true;
                }
            }
            else{
                solusi[found] = hasil;
            } 
        }
        if (noSolution){
            System.out.println("SPL tidak memiliki solusi");
        }
        else{
            for (int i=0;i<m.getCol()-1;i++){
                if(ToString(solusi[i])!="0"){
                    System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                }
                else{
                    for (int k=0;k<n.getRow();k++){
                        if(n.getElmt(k,i)!=0){
                            System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                            break;
                        }
                        else if(k==n.getRow()-1){
                            solusi[i][variabel]=1;
                            variabel++;
                            System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                        }
                    }
                }
            }
        }
    }

    public static void FileSPLGauss(Matrix m, String namaFile) {
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        m = matrixGauss(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
        for (int i=m.getRow()-1;i>=0;i--){
            int found = -1;
            double[] hasil = new double[27];
            for (int j=0;j<m.getCol();j++){
                if(Math.abs(m.getElmt(i, j))>=1.00e-4){
                    if(j==m.getCol()-1){
                        hasil[0] += m.getElmt(i, j);
                    }
                    else{
                        if(IsEmpty(solusi[j])){
                            if(found!=-1){
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1)*m.getElmt(i, j);
                                variabel+=1;
                            }
                            else{
                                found = j;
                            } 
                        }
                        else{
                            for (int k=0;k<27;k++){
                                hasil[k] = hasil[k] - solusi[j][k]*m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
            if(found==-1){
                if(Math.abs(m.getElmt(i, m.getCol()-1))>=1.00e-4){
                    noSolution = true;
                }
            }
            else{
                solusi[found] = hasil;
            } 
        }
        if (noSolution){
            IO.writeFileString(namaFile, "SPL tidak memiliki solusi");
        }
        else{
            String tempString = "";
            for (int i=0;i<m.getCol()-1;i++){
                tempString += "x" + (i+1) + " = " + ToString(solusi[i]) + "\n";
            }
            IO.writeFileString(namaFile, tempString);
        }
    }

    public static void SPLGaussJordan(Matrix m){
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        m = matrixGauss(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
        for (int i=m.getRow()-1;i>=0;i--){
            int found = -1;
            double[] hasil = new double[27];
            for (int j=0;j<m.getCol();j++){
                if(Math.abs(m.getElmt(i, j))>=1.00e-4){
                    if(j==m.getCol()-1){
                        hasil[0] += m.getElmt(i, j);
                    }
                    else{
                        if(IsEmpty(solusi[j])){
                            if(found!=-1){
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1)*m.getElmt(i, j);
                                variabel+=1;
                            }
                            else{
                                found = j;
                            } 
                        }
                        else{
                            for (int k=0;k<27;k++){
                                hasil[k] = hasil[k] - solusi[j][k]*m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
            if(found==-1){
                if(Math.abs(m.getElmt(i, m.getCol()-1))>=1.00e-4){
                    noSolution = true;
                }
            }
            else{
                solusi[found] = hasil;
            } 
        }
        if (noSolution){
            System.out.println("SPL tidak memiliki solusi");
        }
        else{
            for (int i=0;i<m.getCol()-1;i++){
                if(ToString(solusi[i])!="0"){
                    System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                }
                else{
                    for (int k=0;k<n.getRow();k++){
                        if(n.getElmt(k,i)!=0){
                            System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                            break;
                        }
                        else if(k==n.getRow()-1){
                            solusi[i][variabel]=1;
                            variabel++;
                            System.out.println("x" + (i+1) + " = " + ToString(solusi[i]));
                        }
                    }
                }
            }
        }
    }

    public static void FileSPLGaussJordan(Matrix m, String namaFile) {
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        m = MatrixGaussJordan(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
        for (int i=m.getRow()-1;i>=0;i--){
            int found = -1;
            double[] hasil = new double[27];
            for (int j=0;j<m.getCol();j++){
                if(Math.abs(m.getElmt(i, j))>=1.00e-4){
                    if(j==m.getCol()-1){
                        hasil[0] += m.getElmt(i, j);
                    }
                    else{
                        if(IsEmpty(solusi[j])){
                            if(found!=-1){
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1)*m.getElmt(i, j);
                                variabel+=1;
                            }
                            else{
                                found = j;
                            } 
                        }
                        else{
                            for (int k=0;k<27;k++){
                                hasil[k] = hasil[k] - solusi[j][k]*m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
            if(found==-1){
                if(Math.abs(m.getElmt(i, m.getCol()-1))>=1.00e-4){
                    noSolution = true;
                }
            }
            else{
                solusi[found] = hasil;
            } 
        }
        if (noSolution){
            IO.writeFileString(namaFile, "SPL tidak memiliki solusi");
        }
        else{
            String tempString = "";
            for (int i=0;i<m.getCol()-1;i++){
                tempString += "x" + (i+1) + " = " + ToString(solusi[i]) + "\n";
            }
            IO.writeFileString(namaFile, tempString);
        }
    }
}