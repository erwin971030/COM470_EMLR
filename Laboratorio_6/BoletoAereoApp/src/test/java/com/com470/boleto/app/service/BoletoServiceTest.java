/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.service;

import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
/**
 *
 * @author Erwin
 */
public class BoletoServiceTest {
    
    @Mock
    private BoletoDao boletoDao;
    
    @InjectMocks
    BoletoService boletoService;

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
        
        //Boleto guardar;
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        //guardar = boletoService.createBoleto(boleto);
        //assertEquals(guardar, boleto);
        assertThat(boletoService.createBoleto(boleto)).isEqualTo(boleto);
        
    }
    
    @Test
    public void getBoletoByIDTest() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        assertThat(boletoService.getBoletoById(1)).isEqualTo(boleto);
        
    }
    
    
    
    @Test
    public void getAllBoletosTest() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoService.getAllBoletos()).thenReturn(Arrays.asList(boleto));
        assertEquals(boletoService.getAllBoletos(), Arrays.asList(boleto));
    }

    @Test
    public void deleteBoletoTest() {
        Boleto guardar ;
        boletoService.deleteBoleto(1);
        guardar=boletoService.getBoletoById(1);
        Mockito.when(guardar).thenReturn(null);
        assertEquals(guardar, null);
        
    }
    
    @Test
    public void updateBoletoTest() {
        Boleto boleto = new Boleto();
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        Boleto response = boletoService.updateBoleto(1, "correo");
        assertEquals(response, boletoDao.save(boleto));
        
    }

    
}
