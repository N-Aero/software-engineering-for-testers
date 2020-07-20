package com.gildedrose;

import com.gildedrose.ProductTypes.Product;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private Product product(Item item) {
        return new ProductFactory().getProduct(item);
    }

    public void updateProducts() {

        //get an object of Circle and call its draw method.
        for (Item item : items) {
            product(item).updatePriceAndSellIn(item);
        }
    }
}