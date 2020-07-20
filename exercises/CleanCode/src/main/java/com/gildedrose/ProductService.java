package com.gildedrose;

public class ProductService {
    public static int updateQuality(int currentValue, int rate){
        return Math.min(50,Math.max(0,currentValue - rate));
    }
}
