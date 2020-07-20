package com.gildedrose.ProductTypes;

import com.gildedrose.Item;

public class ConjuredProduct extends BasicProduct {
    @Override
    public void updateQuality(Item item) {
        int expiryRate;
        if (item.sellIn <= 0) {
            expiryRate = 4;
        } else {
            expiryRate = 2;
        }
        item.quality = Math.max(0, item.quality - expiryRate);
    }
}
