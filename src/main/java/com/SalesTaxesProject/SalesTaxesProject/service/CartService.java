package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.model.Cart;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;

import static java.lang.Math.round;


public class CartService {

    private static final TaxesService taxesService = new TaxesService();

    private double totalCartAmount;
    private double totalCartAmountWithTaxes = 0;
    private double totalTaxesCart = 0;
    private double productPriceWithTaxes = 0;

    public void displayCartSelection(Cart cart) {
            try {if (!cart.getProducts().isEmpty()) {
                displayProductPriceWithTaxes(cart);
                this.totalCartAmount = calculateCartPrice(cart);
                this.totalTaxesCart = this.totalCartAmountWithTaxes - this.totalCartAmount;
                displayTaxesWithTotalCartAmount();
                this.totalCartAmountWithTaxes = 0;
            } else {
                System.out.println("This cart is empty");
            }} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void displayProductPriceWithTaxes(Cart cart) {
        for (Product product : cart.getProducts()) {
            this.productPriceWithTaxes = taxesService.calculateProductPriceWithTaxes(product);
            this.totalCartAmountWithTaxes += this.productPriceWithTaxes;
            System.out.println(toString(product));
        }
    }

    private void displayTaxesWithTotalCartAmount() {
        System.out.println("Sales Taxes: " + String.format("%.2f", this.totalTaxesCart) + " " + "Total: " + round(this.totalCartAmountWithTaxes * 100.0) / 100.0 + "\n");

    }

    private double calculateCartPrice(Cart cart) {
        double total = 0;
        for (Product product : cart.getProducts()) {
            total += product.getPrice();
        }
        return total;
    }

    private String toString(Product product) {

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(product.getQuantity() + " ");
        stringbuilder.append(product.getName() + ": ");
        stringbuilder.append(String.format("%.2f", round(this.productPriceWithTaxes * 100.0) / 100.0));

        return stringbuilder.toString();
    }
}
