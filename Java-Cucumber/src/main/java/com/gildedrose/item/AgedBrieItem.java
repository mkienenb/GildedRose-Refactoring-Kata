package com.gildedrose.item;

import com.gildedrose.Item;

public class AgedBrieItem extends UpdateableItem {
    public static final String ITEM_NAME__AGED_BRIE = "Aged Brie";

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQualityForItem() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
