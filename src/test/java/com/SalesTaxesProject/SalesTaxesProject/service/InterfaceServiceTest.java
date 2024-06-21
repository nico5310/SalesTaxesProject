package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.database.Database;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InterfaceServiceTest {

    private static InterfaceService interfaceService = new InterfaceService();
    private String messageSelection;

    Database database;

    @Before
    public void setUp() {
        messageSelection = "Please enter your cart number:" + "\n" + "1 First Cart / " + "2 Second Cart / " + "3 Third Cart / " + "0 Exit";
        database = new Database();
    }
  
    @Test
    public void loadMenuTest() {
        //GIVEN
        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        interfaceService.loadMenu();

        //THEN
        verify(mockedPrintStream).println(messageSelection);
    }
}
