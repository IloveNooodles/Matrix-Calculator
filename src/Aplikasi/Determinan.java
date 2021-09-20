package Aplikasi;

import Matrix.Matrix;

public class Determinan {
    public static double kofaktor(Matrix m, int a, int b) {
        /* KAMUS */
        int i, j, iHasil, jHasil;
        Matrix mHasil;
        double hasil;

        /* ALGORITMA */
        hasil = 0;
        mHasil = new Matrix(m.getRow() - 1, m.getCol() - 1);

        iHasil = 0;
        for (i = 0; i < m.getRow(); i++) {
            jHasil = 0;
            for (j = 0; j < m.getCol(); j++) {
                if (i == a) {
                    iHasil = i - 1;
                } else if (j == b) {
                    jHasil = j - 1;
                } else {
                    mHasil.setElmt(iHasil, jHasil, m.getElmt(i, j));
                }
                jHasil++;
            }
            iHasil++;
        }

        if ((a + b) % 2 == 0) {
            hasil = ekspansiKofaktor(mHasil);
        } else {
            hasil = -1 * ekspansiKofaktor(mHasil);
        }

        return hasil;
    }

    public static double ekspansiKofaktor(Matrix m) {
        /* KAMUS */
        int i, j;
        double hasil;

        /* ALGORITMA */
        hasil = 0;

        if (m.getRow() == 1 && m.getCol() == 1) {
            hasil = m.getElmt(0, 0);
        } else {
            i = 0;
            for (j = 0; j < m.getCol(); j++) {
                hasil += m.getElmt(i, j) * kofaktor(m, i, j);
            }
        }

        return hasil;
    }
}
