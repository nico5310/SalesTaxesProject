package com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes;

import com.SalesTaxesProject.SalesTaxesProject.CalculateTaxes;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;

public class NoneTaxes implements CalculateTaxes {

    @Override
    public double calculate(Product product) {
        return product.getPrice();
    }
}
