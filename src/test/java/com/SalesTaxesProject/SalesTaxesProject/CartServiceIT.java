package com.SalesTaxesProject.SalesTaxesProject;

import com.SalesTaxesProject.SalesTaxesProject.model.Cart;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;
import com.SalesTaxesProject.SalesTaxesProject.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CartServiceIT {

    private static CartService cartService = new CartService();

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private static List<Product> products;

    @Before
    public void setUp() {
        product1 = new Product("book", 12.49, false, false, 1);
        product2 = new Product("imported box of chocolates", 10.00, false, true, 1);
        product3 = new Product("music CD", 14.99, true, false, 1);
        product4 = new Product("imported bottle of perfume", 47.50, true, true, 1);
    }

    @Test
    @DisplayName("Product non Taxes")
    public void displayCartProductNoneTaxesTest() {
        //GIVEN
        products = new ArrayList<>();
        products.add(this.product1);
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream).println("1 book: 12,49");
        verify(mockedPrintStream, times(2)).println(anyString());
        System.setOut(old);
    }

    @Test
    @DisplayName("Product with import Taxes")
    public void displayCartWithImportTaxesProductTest() {
        //GIVEN
        products = new ArrayList<>();
        products.add(this.product2);
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream).println("1 imported box of chocolates: 10,50");
        verify(mockedPrintStream, times(2)).println(anyString());
        System.setOut(old);
    }

    @Test
    @DisplayName("Product with basic Taxes")
    public void displayCartWithBasicTaxesProductTest() {
        //GIVEN
        products = new ArrayList<>();
        products.add(product3);
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream).println("1 music CD: 16,49");
        verify(mockedPrintStream, times(2)).println(anyString());
        System.setOut(old);
    }

    @Test
    @DisplayName("Product with basic and import Taxes")
    public void displayCartWithBasicAndImportTaxesProductTest() {
        //GIVEN
        products = new ArrayList<>();
        products.add(product4);
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream).println("1 imported bottle of perfume: 54,65");
        verify(mockedPrintStream, times(2)).println(anyString());
        System.setOut(old);
    }

    @Test
    @DisplayName("Cart with multiple Products")
    public void displayCartWithAnyProductsTest() {
        //GIVEN
        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream, times(5)).println(anyString());
        System.setOut(old);
    }


    @Test
    public void displayErrorWhenCartIsEmptyTest() {
        products = new ArrayList<>();
        Cart cart = new Cart(products);

        PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
        PrintStream old = System.out;
        System.setOut(mockedPrintStream);

        //WHEN
        cartService.displayCartSelection(cart);

        //THEN
        verify(mockedPrintStream).println("This cart is empty");
        verify(mockedPrintStream, times(1)).println(anyString());
        System.setOut(old);
    }

}
