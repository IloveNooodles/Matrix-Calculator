package Aplikasi;

import Matrix.Matrix;
import Matrix.Operation;

public class SistemPersamaanLinear {

    public static Matrix SPLGaussJordan(Matrix m) {
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

            Operation.swapRow(m, idxMax, row);

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
}