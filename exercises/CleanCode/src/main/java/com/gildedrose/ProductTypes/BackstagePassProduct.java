package com.gildedrose.ProductTypes;

import com.gildedrose.Item;

public class BackstagePassProduct extends BasicProduct {
    //“Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches;
    // Quality increases by 2 when there are 10 days or less
    // and by 3 when there are 5 days or less
    // but Quality drops to 0 after the concert


    @Override
    public void updateQuality(Item item) {
        if (item.sellIn == 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality += 3;
        } else if (item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
    }
}
