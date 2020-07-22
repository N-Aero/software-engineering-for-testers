package com.gildedrose;

import com.gildedrose.ProductTypes.Product;

class GildedRose {
    private ProductFactory productFactory;

    Item[] items;

    public GildedRose(Item[] items) {
        this.productFactory = new ProductFactory();
        this.items = items;
    }


    public void updateProducts() {

        //get an object of Circle and call its draw method.
        for (Item item : items) {
            Product product = productFactory.getProduct(item);
            product.updatePriceAndSellIn(item);
        }
    }
}