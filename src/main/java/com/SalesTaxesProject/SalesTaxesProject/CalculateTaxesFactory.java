package com.SalesTaxesProject.SalesTaxesProject;

import com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes.NoneTaxes;
import com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes.WithBasicAndImportTaxes;
import com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes.WithBasicTaxes;
import com.SalesTaxesProject.SalesTaxesProject.ConditionTaxes.WithImportTaxes;
import com.SalesTaxesProject.SalesTaxesProject.model.Product;

public class CalculateTaxesFactory {

    public CalculateTaxes calculateTaxes(Product product) {

        if (product.isBasicTax() && !product.isImportTax()) {
            return new WithBasicTaxes();
        }
        else if (!product.isBasicTax() && product.isImportTax()) {
            return new WithImportTaxes();
        }
        else if (product.isBasicTax() && product.isImportTax()) {
            return new WithBasicAndImportTaxes();
        }
        return new NoneTaxes();
    }

}
