package com.SalesTaxesProject.SalesTaxesProject.Cart;

import com.SalesTaxesProject.SalesTaxesProject.UserAction;
import com.SalesTaxesProject.SalesTaxesProject.service.MenuSelectorService;

public class ExitCart implements UserAction {

    @Override
    public void execute() {
        System.out.print("Exit selection" + "\n");
        MenuSelectorService.setContinueApp(false);
    }

}
