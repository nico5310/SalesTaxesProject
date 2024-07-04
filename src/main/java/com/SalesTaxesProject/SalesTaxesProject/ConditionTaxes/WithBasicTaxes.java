package com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes;

import com.SalesTaxesProject.SalesTaxesProject.CalculateTaxes;
import com.SalesTaxesProject.SalesTaxesProject.TaxPercent;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;
import com.SalesTaxesProject.SalesTaxesProject.util.RulesFormat;

import static java.lang.Math.round;

public class WithBasicTaxes implements CalculateTaxes {

    @Override
    public double calculate(Product product) {
        double priceWithTaxes = product.getPrice();
        priceWithTaxes += RulesFormat.roundingTaxesFormat(round(priceWithTaxes * TaxPercent.BASIC_TAX_PERCENT) / 100.0);
        return priceWithTaxes;
    }
}
