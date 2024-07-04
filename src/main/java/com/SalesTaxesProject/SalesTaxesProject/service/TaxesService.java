package com.SalesTaxesProject.SalesTaxesProject.service;

import com.SalesTaxesProject.SalesTaxesProject.CalculateTaxes;
import com.SalesTaxesProject.SalesTaxesProject.CalculateTaxesFactory;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;

import static java.lang.Math.round;

public class TaxesService {

    private CalculateTaxesFactory calculateTaxesFactory = new CalculateTaxesFactory();


    public double calculateProductPriceWithTaxes(Product product) {

        CalculateTaxes calculateTaxes = calculateTaxesFactory.calculateTaxes(product);
        return calculateTaxes.calculate(product);
    }

}
