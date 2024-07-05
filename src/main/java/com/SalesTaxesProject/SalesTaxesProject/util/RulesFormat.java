package com.SalesTaxesProject.SalesTaxesProject.util;

public final class RulesFormat {

    public static double roundingTaxesFormat(double priceWithTaxes) {
        return Math.ceil((priceWithTaxes) / 0.05) * 0.05;
    }

}
