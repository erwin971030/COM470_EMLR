/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.controller;

import com.com470.boleto.app.entities.Boleto;
import com.com470.boleto.app.service.BoletoService;
import java.util.ArrayList;
import java.util.Date;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Erwin
 */
public class BoletoControllerTest {
    
    @Mock
    private BoletoService boletoService;
    
   
    @InjectMocks
    BoletoController boletoController;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void createBoletoTest() {
        Boleto boleto = new Boleto();
	boleto.setBoletoId(1);
	boleto.setFecha(new Date());
	boleto.setEmail("jorge.perez@gmail.com");
	boleto.setNombreDelPasajero("Jorge Perez");
	boleto.setSalida("Sucre");
	boleto.setDestino("Potosi");
        boletoController.createBoleto(boleto);
        Mockito.verify(boletoService).createBoleto(boleto);
    }
    
    @Test
    public void getBoletoByIDTest() {
        Boleto boleto = new Boleto();
	boleto.setBoletoId(1);
	boleto.setFecha(new Date());
	boleto.setEmail("jorge.perez@gmail.com");
	boleto.setNombreDelPasajero("Jorge Perez");
	boleto.setSalida("Sucre");
	boleto.setDestino("Potosi");
        boletoController.getBoletoById(boleto.getBoletoId());
        Mockito.verify(boletoService).getBoletoById(boleto.getBoletoId());
    }
    
    @Test
    public void getAllBoletosTest() {
        ArrayList<Boleto> boletos = new ArrayList<Boleto>();
	boletos.add(new Boleto());
        boletos.add(new Boleto());
        boletos.add(new Boleto());
        boletoController.getAllBoletos();
        Mockito.verify(boletoService).getAllBoletos();
    }
     
    @Test 
    public void deleteBoletoTest() {
       Boleto boleto = new Boleto();
       boleto.setBoletoId(1);
       boleto.setFecha(new Date());
       boleto.setEmail("jorge.perez@gmail.com");
       boleto.setNombreDelPasajero("Jorge Perez");
       boleto.setSalida("Sucre");
       boleto.setDestino("Potosi");
       boletoController.deleteBoleto(1);
       Mockito.verify(boletoService).deleteBoleto(1);
    }

    @Test
    public void updateBoletoTest() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boletoController.updateBoleto(boleto.getBoletoId(), boleto.getEmail());
        Mockito.verify(boletoService).updateBoleto(boleto.getBoletoId(), boleto.getEmail());
    }
    
   
}
