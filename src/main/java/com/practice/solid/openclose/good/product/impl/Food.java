package com.practice.solid.openclose.good.product.impl;

import com.practice.solid.openclose.good.Product;

public class Food extends Product {

    @Override
    public double calculateTaxIncludedPrice() {
        return getBasePrice() * 1.08;
    }

}
