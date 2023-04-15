package com.matrix;

import java.util.ArrayList;
import java.util.List;

import com.exception.*;

public class MatrixLib {
	private int row;
	private int col;
	private int[][] matrix;
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public MatrixLib(int row,int col){
		this.row=row;
		this.col=col;
		this.matrix=new int[row][col];
	}
	public int[][] add(MatrixLib b) throws InvalidMatrixAdditionException{
		if(this.getRow()!=b.getRow()) {
			throw new InvalidMatrixAdditionException("Matrices are not same size");
		}
		int[][] mat=new int[row][col];
		for(int i=0;i<this.getRow();i++) {
			for(int j=0;j<this.getCol();j++) {
				mat[i][j]= this.matrix[i][j]+b.matrix[i][j];
			}
		}
		return mat;
	}
	public int[][] sub(MatrixLib b) throws InvalidMatrixSubtractionException{
		if(this.getRow()!=b.getRow()) {
			throw new InvalidMatrixSubtractionException("Matrices are not same size");
		}
		int[][] mat=new int[row][col];
		for(int i=0;i<this.getRow();i++) {
			for(int j=0;j<this.getCol();j++) {
				mat[i][j]= this.matrix[i][j]-b.matrix[i][j];
			}
		}
		return mat;
	}
	public int[][] multiply(MatrixLib b) throws InvalidMatrixMultiplicationException{
		if(this.getCol()!=b.getRow()) {
			throw new InvalidMatrixMultiplicationException("Invalid matrix size");
		}
		int [][]mat=new int[this.getRow()][b.getCol()];
		for(int row=0;row<this.getRow();row++) {
			for(int col=0;col<b.getCol();col++) {
				for(int i=0,j=0;i<this.getCol() && j<b.getRow();i++,j++) {
					mat[row][col]+=this.matrix[row][i]*b.matrix[j][col];
				}
			}
		}
		
		return mat;
	}
	public int[][] transpose(){
		int [][] mat = new int[this.getCol()][this.getRow()];
		for(int i=0;i<this.getCol();i++) {
			for(int j=0;j<this.getRow();j++) {
				mat[i][j]=this.matrix[j][i];
			}
		}
		return mat;
	}
	public int [][] diagonal(){
		int size=Math.min(this.getRow(), this.getCol());
		int mat[][]=new int[2][size];
		for(int i=0,j=0,idx=0;i<row && j<col && idx<size;i++,j++,idx++) {
			mat[0][idx]=this.matrix[i][j];
		}
		for(int i=0,j=col-1,idx=0;i<row && j>=0 && idx<size;i++,j--,idx++) {
			mat[1][idx]=this.matrix[i][j];
		}
		return mat;
	}
	public List saddlePoint() {
		List<int []> arr = new ArrayList<>();
		
		for(int i=0;i<row;i++) {
			int minVal=matrix[i][0],colIdx=0,rowIdx=i;
			for(int j=1;j<col;j++) {
				if(matrix[i][j]<minVal) {
					minVal=matrix[i][j];
					colIdx=j;
				}
			}
			int maxVal=matrix[0][colIdx];
			for(int j=0;j<row;j++) {
				if(matrix[j][colIdx]>maxVal) {
					maxVal=matrix[j][colIdx];
					rowIdx=j;
				}
			}
			if(rowIdx==i) {
				arr.add(new int[] {rowIdx,colIdx});
			}
		}
		return arr;
	}
}
