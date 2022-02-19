package com.gildedrose;

public class AgedBrieItem extends UpdateableItem {
    public static final String ITEM_NAME__AGED_BRIE = "Aged Brie";

    public AgedBrieItem(int sellIn, int quality) {
        super(ITEM_NAME__AGED_BRIE, sellIn, quality);
    }

    @Override
    public void updateQualityForItem() {
        if (quality < 50) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
