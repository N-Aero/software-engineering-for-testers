package com.gildedrose.ProductTypes;

import com.gildedrose.Item;

public interface Product {
    void updateQuality(Item item);
    void updateSellIn(Item item);
    void updatePriceAndSellIn(Item item);
}
