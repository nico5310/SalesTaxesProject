package com.SalesTaxesProject.SalesTaxesProject;

import com.SalesTaxesProject.SalesTaxesProject.Cart.*;

public class UserActionFactory {

    public UserAction action(int choice) {
        switch (choice) {
            case 0: return new ExitCart();
            case 1: return new FirstCart();
            case 2: return new SecondCart();
            case 3: return new ThirdCart();
            default: return new ErrorCart();
        }
    }
}
