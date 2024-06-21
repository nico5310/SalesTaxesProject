package com.SalesTaxesProject.SalesTaxesProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;
    private double price;
    private boolean basicTax;
    private boolean importTax;
    private int quantity;
}
