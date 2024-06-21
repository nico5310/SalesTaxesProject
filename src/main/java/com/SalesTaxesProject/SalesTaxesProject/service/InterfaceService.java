package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.database.Database;
import com.SalesTaxesProject.SalesTaxesProject.util.InputReaderUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InterfaceService {

    private static final CartService cartService = new CartService();
    private static final InputReaderUtil inputReaderUtil = new InputReaderUtil();
    private static final Database database = new Database();

    private static String messageSelection = "Please enter your cart number:" + "\n" + "1 First Cart / " + "2 Second Cart / " + "3 Third Cart / " + "0 Exit";
    private static String messageError = "Please select a cart between 1 and 3 : ";

    private static boolean continueApp = true;

    public static void loadInterface() throws IOException {
        database.initDatabase();
        selectionBasketMenu();
    }

    public static void loadMenu() {
        System.out.println(messageSelection);
    }

    private static void selectionBasketMenu() {
        while (continueApp) {
            loadMenu();
            int selectBasket = inputReaderUtil.readSelection();
            switch (selectBasket) {
                case 1: {
                    cartService.displayCartSelection(database.getFirstBasket());
                    break;
                }
                case 2: {
                    cartService.displayCartSelection(database.getSecondBasket());
                    break;
                }
                case 3: {
                    cartService.displayCartSelection(database.getThirdBasket());
                    break;
                }
                case 0: {
                    System.out.print("Exit selection");
                    continueApp = false;
                    break;
                }
                default:
                    System.out.println(messageError);
            }
        }
    }

}
