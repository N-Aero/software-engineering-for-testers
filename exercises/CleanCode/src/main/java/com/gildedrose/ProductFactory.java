package com.gildedrose;

import com.gildedrose.ProductTypes.*;

public class ProductFactory {
    //use getShape method to get object of type shape
    public Product getProduct(Item product) {
//            if (product.name.contains("Aged Brie")) {
//                return new AgedProduct();
//            } else if (product.name.contains("Sulfuras, Hand of Ragnaros")) {
//                return new LegendaryProduct();
//            } else if (product.name.contains("Backstage pass")) {
//                return new BackstagePassProduct();
//            } else if (product.name.startsWith("Conjured ")) {
//                return new ConjuredProduct();
//            } else {
//                return new BasicProduct();
//            }

        switch (product.name) {
            case "Aged Brie":
                return new AgedProduct();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryProduct();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassProduct();
            case "Conjured Mana Cake":
                return new ConjuredProduct();
            default:
                return new BasicProduct();
        }
    }

}
