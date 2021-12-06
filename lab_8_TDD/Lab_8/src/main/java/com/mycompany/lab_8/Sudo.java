/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab_8;

/**
 *
 * @author Erwin
 */
public class Sudo {

	public int verify(String candidateSolution) {
		                
                //si retorna 0 la solucion es valida 
                //si retorna -1 Se esta violando las regla #1  
                //si retorna -2 Se esta violando las regla #2  
                //si retorna -3 Se esta violando las regla #3  
                //si retorna -4 Se esta violando las regla #4  
                
		
		
                //Divide la cadena en filas de 9 elementos 
		String[] rows = SplitRows(candidateSolution);
		
		// Splitting the forwarded string into columns of 9 elements
                //Divide la cadena en columnas de 9 elementos 
		String[] columns = SplitColumns(candidateSolution);
	
	
                // iteramos la cadena para ver si hay un digito que no sea del 1 al 9 
                //Si hay un digito que noes de 1-9 la funcion de verificacion devolvera -1 segun las instrucciones 
		for (int i = 0; i < rows.length; i++)
		{
			char[] row = rows[i].toCharArray();
			
			for(int j = 0; j < row.length; j++)
			{
				if(Character.getNumericValue(row[j]) < 1 || Character.getNumericValue(row[j]) > 9)
					return -1;
			}
		}
		
                //Iterando a traves de cada subcuadricula para ver si hay dos digitos iguales
                //S hay dos digitos iguales, la funcion de verificacion devolvera -2 segun las instrucciones
		
		
                // Inicializamos la matriz de 9x9 
		int[][] mainGrid = new int[9][9];
		
		for (int i = 0; i < 9; i++)
		{
			char[] rowsElements = rows[i].toCharArray();
			
			for (int j = 0; j < 9; j++)
			{	
				mainGrid[i][j] = Character.getNumericValue(rowsElements[j]);
			}
		}
		
		///////////PRINTING//////////
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{	
				System.out.print(mainGrid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		///////////PRINTING//////////
		
		
		//recorremos la matriz y se crea submatrices de 3x3
		int[][] subGrid = new int[3][3];		
		
		for(int i = 0; i < 9; i+=3)
		{
			for(int j = 0; j < 9; j+=3)
			{
				for (int k = 0; k < 3; k++)
				{	
					for (int l = 0; l < 3; l++)
					{	
						subGrid[k][l] = mainGrid[i+k][j+l];					
					}
				}
				
				///////////PRINTING//////////
				for (int m = 0; m < 3; m++)
				{
					for (int n = 0; n < 3; n++)
					{	
						System.out.print(subGrid[m][n] + "  ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println();
				///////////PRINTING//////////
                                
				
				
				if (CheckTheGrid(subGrid) != true)
				{
					return -2;
				}
				else
				{
					subGrid = new int[3][3];
				}
			}
		}
		

                // iteramos cada fila para ver si algun digito aparece dos veces 
		// si aparece dos veces la funcion de verificacion devolvera -3 
		for (int i = 0; i < rows.length; i++) {
			char[] charArray = rows[i].toCharArray();
			int[] integerArray = new int[9];

			for (int j = 0; j < integerArray.length; j++) {
				integerArray[j] = Character.getNumericValue(charArray[j]);
			}

			for (int k = 0; k < integerArray.length - 1; k++) {
				for (int l = k + 1; l < integerArray.length; l++) {
					if (integerArray[k] == integerArray[l])
						return -3;
				}
			}
		}

                // iteramos cada columna para ver si algun digito aparece dos veces 
		// si aparece dos veces la funcion de verificacion devolvera -4 
		for (int i = 0; i < columns.length; i++) {
			char[] charArray = columns[i].toCharArray();
			int[] integerArray = new int[9];

			for (int j = 0; j < integerArray.length; j++) {
				integerArray[j] = Character.getNumericValue(charArray[j]);
			}

			for (int k = 0; k < integerArray.length - 1; k++) {
				for (int l = k + 1; l < integerArray.length; l++) {
					if (integerArray[k] == integerArray[l])
						return -4;
				}
			}
		}
		
		// retorna 0 si la solucion es correcta 
		return 0;
	}//
	
	
	
	
	
	///// HELPER METHODS ///////
	
	public boolean CheckSolutionLength(String solution)
	{
		if(solution.length() == 81)
			return true;
		else
			return false;
	}
	
        //separa en filas
	public String[] SplitRows(String string)
	{
		int startIndex = 0;
		int endIndex = 9;
		String[] strings = new String[9];
		
		for (int i = 0; i < 9; i++, startIndex += 9, endIndex += 9)
		{
			String row = string.substring(startIndex, endIndex);
			strings[i] = row;
		}
		
		return strings;
	}
	
	
	// Separa en columnas 
	public String[] SplitColumns(String string)
	{
		char[] charArray = string.toCharArray();
		String[] columns = new String[9];
		int columnNumber = 0;
		boolean first = true;
		
		for(int i = 0; i < string.length(); i++, columnNumber++)
		{
			if(columnNumber == 9)
			{
				columnNumber = 0;
				first = false;
			}
			
			int integer = Character.getNumericValue(charArray[i]);
			
			if(first)
				columns[columnNumber] = "" + String.valueOf(integer);
			else
				columns[columnNumber] = columns[columnNumber] + String.valueOf(integer);
		}
		
		return columns;
	}
	
	
	
	public boolean CheckTheGrid(int[][] grid)
	{
		
		int[] array = new int[9];
		int counter = 0;
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{	
				array[counter] = grid[i][j];
				counter++;
			}
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					return false;
			}
		}
		
		return true;
	}
}

