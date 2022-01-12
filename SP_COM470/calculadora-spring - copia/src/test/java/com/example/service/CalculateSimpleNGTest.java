/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import org.junit.After;
import org.junit.Before;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Erwin
 */
public class CalculateSimpleNGTest {

    By botonSumar = By.name("add");
    By botonRestar = By.name("subtract");
    By botonMult = By.name("divide");
    By botonDividir = By.name("multiply");
    By botonBorrar = By.name("clearSimple");
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/calculadora");

    }

    //Test Suma
    @Test
    public void sumaTest() {
        WebElement caja1 = driver.findElement(By.name("a"));
        WebElement caja2 = driver.findElement(By.name("b"));
        caja1.clear();
        caja2.clear();
        caja1.sendKeys("2");
        caja2.sendKeys("3");

        WebElement btnsumar = driver.findElement(botonSumar);
        btnsumar.click();

        segundosPausa(1);

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("5"));
    }
//Test Restar

    @Test
    public void restarTest() {
        WebElement caja1 = driver.findElement(By.name("a"));
        WebElement caja2 = driver.findElement(By.name("b"));
        caja1.clear();
        caja2.clear();
        caja1.sendKeys("2");
        caja2.sendKeys("3");

        WebElement btnsumar = driver.findElement(botonRestar);
        btnsumar.click();

        segundosPausa(1);

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("-1"));
    }

    //Test Multiplicar
    @Test
    public void multiplicarTest() {
        WebElement caja1 = driver.findElement(By.name("a"));
        WebElement caja2 = driver.findElement(By.name("b"));
        caja1.clear();
        caja2.clear();
        caja1.sendKeys("2");
        caja2.sendKeys("3");

        WebElement btnsumar = driver.findElement(botonMult);
        btnsumar.click();

        //segundosPausa(1);
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("6"));
    }

    //Test Dividir
    @Test
    public void dividirTest() {
        WebElement caja1 = driver.findElement(By.name("a"));
        WebElement caja2 = driver.findElement(By.name("b"));
        caja1.clear();
        caja2.clear();
        caja1.sendKeys("2");
        caja2.sendKeys("3");

        WebElement btnsumar = driver.findElement(botonDividir);
        btnsumar.click();

        //segundosPausa(1);
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("0.6666666666666666"));
    }

    //Test Borrar
    @Test
    public void borrarTest() {

        WebElement btnsumar = driver.findElement(botonBorrar);
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("0"));
    }

    //Test factorial
    @Test
    public void factorialTest() {
        WebElement caja1 = driver.findElement(By.name("c"));

        caja1.clear();

        caja1.sendKeys("5");

        WebElement btnsumar = driver.findElement(By.name("factorial"));
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("120"));
    }

    //Test raiz
    @Test
    public void raizTest() {
        WebElement caja1 = driver.findElement(By.name("c"));

        caja1.clear();

        caja1.sendKeys("5");

        WebElement btnsumar = driver.findElement(By.name("sqrt"));
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("2.23606797749979"));
    }

    //Test potencia
    @Test
    public void potenciaTest() {
        WebElement caja1 = driver.findElement(By.name("c"));

        caja1.clear();

        caja1.sendKeys("5");

        WebElement btnsumar = driver.findElement(By.name("power"));
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("25"));
    }

    //Test Fibonacci
    @Test
    public void fiboTest() {
        WebElement caja1 = driver.findElement(By.name("c"));

        caja1.clear();

        caja1.sendKeys("5");

        WebElement btnsumar = driver.findElement(By.name("fibonacci"));
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("5"));
    }

    //Test Borrar Avanzado
    @Test
    public void borrarAvanzadoTest() {
        WebElement caja1;
        caja1 = driver.findElement(By.name("c"));

        caja1.clear();

        caja1.sendKeys("5");

        WebElement btnsumar = driver.findElement(By.name("clearAdvanced"));
        btnsumar.click();

        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("0"));
    }

    public static void segundosPausa(long sleeptime) {
        try {
            Thread.sleep(sleeptime * 1000);
        } catch (Exception e) {
        }

    }

    @After
    public void tearDown() {

        driver.quit();
    }

}
