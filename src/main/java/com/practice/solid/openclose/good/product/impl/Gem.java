package com.practice.solid.openclose.good.product.impl;

import com.practice.solid.openclose.good.Product;

public class Gem extends Product {

    @Override
    public double calculateTaxIncludedPrice() {
        return getBasePrice();
    }

}