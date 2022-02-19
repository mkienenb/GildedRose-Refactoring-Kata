package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstagePassesItem extends UpdateableItem {
    public static final String ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQualityForItem() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
