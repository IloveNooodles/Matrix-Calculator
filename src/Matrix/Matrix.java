package Matrix;

import java.util.Scanner;

public class Matrix {
  private int row, col;
  private Double mtxr[][];

  // KONSTRUKTOR
  public Matrix(){
    this.row = 0;
    this.col = 0;
  }
  public Matrix(int row, int col){
    this.row = row;
    this.col = col;
    this.mtxr = new Double [row][col];
  }

  // GETTER DAN SETTER
  public int getRow(){
    return this.row;
  }

  public int getCol(){
    return this.col;
  }

  public void setRow(int row){
    this.row = row;
  }

  public void setCol(int col){
    this.col = col;
  }

  public void setElmt(int row, int col, double elmt){
    this.mtxr[row][col] = elmt;
  }

  //OPERASI
  public void createMatrix(){
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        double d = sc.nextDouble();
        this.mtxr[i][j] = d;
      }
    }
    sc.close();
  }

  public void displayMatrix(){
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        System.out.print(this.mtxr[i][j]);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }
}
