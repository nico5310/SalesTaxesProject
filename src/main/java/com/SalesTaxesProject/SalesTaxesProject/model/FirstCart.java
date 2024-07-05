package com.SalesTaxesProject.SalesTaxesProject.model;

import com.SalesTaxesProject.SalesTaxesProject.UserAction;
import com.SalesTaxesProject.SalesTaxesProject.database.Database;
import com.SalesTaxesProject.SalesTaxesProject.service.CartService;
import com.SalesTaxesProject.SalesTaxesProject.service.MenuSelectorService;

public class FirstCart implements UserAction {

    private Database database = new Database();
    private CartService cartService = new CartService();

    @Override
    public void execute() {
        database.initDatabase();
        cartService.displayCartSelection(database.getFirstCart());
        MenuSelectorService.loadMenu();
    }
}
