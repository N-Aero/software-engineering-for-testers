package com.gildedrose.ProductTypes;

import com.gildedrose.Item;

public class BasicProduct implements Product {
    public void updateQuality(Item item) {
        int expiryRate = item.sellIn<=0 ? 2: 1;
        item.quality = Math.max(0, item.quality - expiryRate);
    }

    public void updateSellIn(Item item) {
        item.sellIn -= 1;
    }

    public void updatePriceAndSellIn(Item item) {
        updateQuality(item);
        updateSellIn(item);
    }

}
