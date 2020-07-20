package com.gildedrose.ProductTypes;

import com.gildedrose.Item;

public class AgedProduct extends BasicProduct {
    @Override
    public void updateQuality(Item item) {
        item.quality = Math.min(50,item.quality + 1);
    }
}
