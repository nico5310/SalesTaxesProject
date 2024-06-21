package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.model.Product;

import static java.lang.Math.round;

public class TaxesService {

    private static final double BASIC_TAX_PERCENT = 10;
    private static final double IMPORT_TAX_PERCENT = 5;
    

    public double calculateProductPriceWithTaxes(Product product) {
        double priceWithTaxes = product.getPrice();

        if (product.isBasicTax() && !product.isImportTax()) {
            priceWithTaxes += roudingRulesFormat(round(priceWithTaxes * BASIC_TAX_PERCENT) / 100.0);
        }
        if (!product.isBasicTax() && product.isImportTax()) {
            priceWithTaxes += roudingRulesFormat(round(priceWithTaxes * IMPORT_TAX_PERCENT) / 100.0);
        }
        if (product.isBasicTax() && product.isImportTax()) {
            priceWithTaxes += roudingRulesFormat(round(priceWithTaxes * (BASIC_TAX_PERCENT + IMPORT_TAX_PERCENT)) / 100.0);
        }
        return priceWithTaxes;
    }

    private double roudingRulesFormat(double priceWithTaxes) {
        return Math.ceil((priceWithTaxes) / 0.05) * 0.05;
    }

}
