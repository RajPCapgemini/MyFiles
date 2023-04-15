package com.matrix.client;

import com.matrix.MatrixLib;
import com.exception.*;

import java.util.List;
import java.util.Scanner;

public class MatrixTest {
	MatrixTest(){
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1: Add\n2: Subtract\n3: Multiply\n4: Transpose\n5: Diagonal\n6: Saddle Point\n7: exit");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				System.out.print("Enter second matrix row size: ");
				int rowB=scanner.nextInt();
				System.out.print("Enter second matrix column size: ");
				int colB=scanner.nextInt();
				MatrixLib matrixB=new MatrixLib(rowB,colB);
				mat=new int[rowB][colB];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowB;i++) {
					for(int j=0;j<colB;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixB.setMatrix(mat);
				try {
					mat=matrixA.add(matrixB);
					System.out.println("Result: ");
					for(int i=0;i<mat.length;i++) {
						for(int j=0;j<mat[0].length;j++) {
							System.out.print(mat[i][j]+" ");
						}
						System.out.println();
					}
				} catch (InvalidMatrixAdditionException e) {
					System.out.println(e);
				}
				break;
			}
			case 2:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				System.out.print("Enter second matrix row size: ");
				int rowB=scanner.nextInt();
				System.out.print("Enter second matrix column size: ");
				int colB=scanner.nextInt();
				MatrixLib matrixB=new MatrixLib(rowB,colB);
				mat=new int[rowB][colB];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowB;i++) {
					for(int j=0;j<colB;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixB.setMatrix(mat);
				try {
					mat=matrixA.sub(matrixB);
					System.out.println("Result: ");
					for(int i=0;i<mat.length;i++) {
						for(int j=0;j<mat[0].length;j++) {
							System.out.print(mat[i][j]+" ");
						}
						System.out.println();
					}
				} catch (InvalidMatrixSubtractionException e) {
					System.out.println(e);
				}
				break;
			}
			case 3:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				System.out.print("Enter second matrix row size: ");
				int rowB=scanner.nextInt();
				System.out.print("Enter second matrix column size: ");
				int colB=scanner.nextInt();
				MatrixLib matrixB=new MatrixLib(rowB,colB);
				mat=new int[rowB][colB];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowB;i++) {
					for(int j=0;j<colB;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixB.setMatrix(mat);
				try {
					mat=matrixA.multiply(matrixB);
					System.out.println("Result: ");
					for(int i=0;i<mat.length;i++) {
						for(int j=0;j<mat[0].length;j++) {
							System.out.print(mat[i][j]+" ");
						}
						System.out.println();
					}
				} catch(InvalidMatrixMultiplicationException e) {
					System.out.println(e);
				}
				break;
			}
			case 4:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				mat=matrixA.transpose();
				System.out.println("Result: ");
				for(int i=0;i<mat.length;i++) {
					for(int j=0;j<mat[0].length;j++) {
						System.out.print(mat[i][j]+" ");
					}
					System.out.println();
				}
				break;
			}
			case 5:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				mat=matrixA.diagonal();
				System.out.println("Result: ");
				for(int i=0;i<mat.length;i++) {
					if(i==0)
					System.out.print("Principal Diagonal: ");
					else System.out.print("Counter Diagonal: ");
					for(int j=0;j<mat[0].length;j++) {
						System.out.print(mat[i][j]+" ");
					}
					System.out.println();
				}
				break;
			}
			case 6:{
				System.out.print("Enter first matrix row size: ");
				int rowA=scanner.nextInt();
				System.out.print("Enter first matrix column size: ");
				int colA=scanner.nextInt();
				MatrixLib matrixA=new MatrixLib(rowA,colA);
				int [][]mat=new int[rowA][colA];
				System.out.println("Enter matrix row wise:");
				for(int i=0;i<rowA;i++) {
					for(int j=0;j<colA;j++) {
						mat[i][j]=scanner.nextInt();
					}
				}
				matrixA.setMatrix(mat);
				List<int[]> arr =matrixA.saddlePoint();
				for(int[] a:arr) {
					System.out.println("Point: "+a[0]+" "+a[1]);
				}
				break;
			}
			case 7:{
				choice=0;
				break;
			}
			default:{
				
			}
			}
		}while(choice!=0);
		
	}

}
