/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab_8;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erwin
 */
public class SudoTest {
    

@Test 
public void testVerifyValido(){
    Sudo sudo = new Sudo();
    int check = sudo.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    assertEquals(0, check);
}

//compruba el tamaño de la tabla y devuelve true si es de 81
@Test
public void testCheckSolutionLength() {
    Sudo sudo = new Sudo();
    boolean check = sudo.CheckSolutionLength("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    assertTrue(check);
}
    
//separa la tabla en filas    
@Test
    public void testSplitRows() {
    Sudo sudo = new Sudo();
    String[] actual = sudo.SplitRows("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
    String expected = "417369825";
    assertEquals(expected, actual[0]);
}



    //separa la tabla en columnas    
@Test
    public void testSplitColumns() {
    Sudo sudo = new Sudo();
    String[] actual = sudo.SplitColumns("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
    String expected = "198765432";
    assertEquals(expected, actual[0]);
}    

    
//esta funcion compruba que en la fila dada no haya repetidos    
@Test
public void testCheckTheGrid() {
    Sudo sudo = new Sudo();
    int[][] grid = initializeTheGrid();
    boolean check = sudo.CheckTheGrid(grid);
    assertTrue(!check);
}
    

//verifica que los datos de la tabla esten entre 1-9 y si hay devuelve -1
@Test
public void TestIfTheDigitsAreNot1_9() {
    Sudo sudo = new Sudo();
    int actual = sudo.verify("103456789912345678891234567789123456678912345567891234456789123345678912234567891");
    int expected = -1;
    assertEquals(expected, actual);
}    
  

//verifica si hay numeros repetidos en cada cuadricula y de ser asi devuelve -2
@Test
public void TestIfDigitsAppearOnlyOnceInASubGrid() {
    Sudo sudo = new Sudo();
    int actual = sudo.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891");
    int expected = -2;
    assertEquals(expected, actual);
}  
   
//verifica las filas y si hay iguales devuelve -3
@Test
public void TestIfDigitsAppearOnlyOnceInEveryRow() {
        Sudo sudo = new Sudo();
        int actual = sudo.verify("417369825632158947958724316825437169791586432346912758289643571573295684164871293");
        int expected = -3;
        assertEquals(expected, actual);
}


//verifica cada columna si hay numeros iguales en cada columna y si hay debuelve -4
@Test
public void TestIfDigitsAppearOnlyOnceInEveryColumn() {
    Sudo sudo = new Sudo();
        int actual = sudo.verify("147369825632158947958724316825437169791586432346912758289643571573291684164875293");
        int expected = -4;
        assertEquals(expected, actual);
    }
    
    
public int[][] initializeTheGrid() {
    int[][] grid = new int[3][3];
    int counter = 0;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            grid[i][j] = counter;
            counter++;
        }
    }
    grid[0][1] = 0;
    return grid;
    }
    
}


