package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.UserAction;
import com.SalesTaxesProject.SalesTaxesProject.UserActionFactory;
import com.SalesTaxesProject.SalesTaxesProject.database.Database;
import com.SalesTaxesProject.SalesTaxesProject.util.InputReaderUtil;
import org.springframework.stereotype.Component;

@Component
public class MenuSelectorService {

    private static InputReaderUtil inputReaderUtil = new InputReaderUtil();
    private static UserActionFactory userActionFactory = new UserActionFactory();

    private static String messageSelection = "Please enter your cart number:" + "\n" + "1 First Cart / " + "2 Second Cart / " + "3 Third Cart / " + "0 Exit";
    private static boolean continueApp = true;

    public static void loadingMenuSelector() {
        loadMenu();
        while (continueApp) {
            int userChoice = inputReaderUtil.readSelection();
            UserAction action = userActionFactory.action(userChoice);
            action.execute();
        }
    }

    public static void loadMenu() {
        System.out.println(messageSelection);
    }

    public static void setContinueApp(boolean continueApp) {
        MenuSelectorService.continueApp = continueApp;
    }

}
