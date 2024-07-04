package com.SalesTaxesProject.SalesTaxesProject.model;

import com.SalesTaxesProject.SalesTaxesProject.UserAction;

public class ErrorCart implements UserAction {

    private static String messageError = "Your cart isn't existing,\n" + "Select a cart between 1 and 3 or to exit select 0.";

    @Override
    public void execute() {
        System.out.println(messageError);
    }
}
