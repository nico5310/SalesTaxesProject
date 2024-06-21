package com.SalesTaxesProject.SalesTaxesProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private List<Product> products;

}
