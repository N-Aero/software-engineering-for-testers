package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemIsFound() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testItemDegrades() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void testItemDegradesByOne() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void testBrieDoesNotDegrade() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void testBackstagePassDoesNotDegrade() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(3, app.items[0].quality);
    }

    //All items have a SellIn value which denotes the number of days we have to sell the item
    //All items have a Quality value which denotes how valuable the item is
    //At the end of each day our system lowers both values for every item
    @Test
    void testQualityLowers() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void testSellInLowers() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(-1, app.items[0].sellIn);
    }
    //Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void testQualityLowersTwiceAsFastIfExpired() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void testQualityLowersTwiceAsFastForConjured() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void testQualityLowersTwiceAsFastForConjuredIfExpired() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(6, app.items[0].quality);
    }

    //The Quality of an item is never negative
    @Test
    void testQualityNeverBelowZero() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(0, app.items[0].quality);
    }

    //“Aged Brie” actually increases in Quality the older it gets
    @Test
    void testAgedBrieIncreasesQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(1, app.items[0].quality);
    }

    //The Quality of an item is never more than 50
    @Test
    void testQualityNeverAboveFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(50, app.items[0].quality);
    }


    //“Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
    @Test
    void testSulfurasDoesntChange() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void testSulfurasDoesntChangeOverMultipleDays() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        app.updateProducts();
        app.updateProducts();
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void testSulfurasDoesntRequireSellIn() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(1, app.items[0].sellIn);
    }

    //“Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches;
    // Quality increases by 2 when there are 10 days or less
    // and by 3 when there are 5 days or less
    // but Quality drops to 0 after the concert
    @Test
    void testBackstagePassIncreasesInQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void testBackstagePassIncreasesInQualityByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void testBackstagePassIncreasesInQualityByThree() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(13, app.items[0].quality);
    }
    @Test
    void testBackstagePassDropsToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateProducts();
        assertEquals(0, app.items[0].quality);
    }


}
