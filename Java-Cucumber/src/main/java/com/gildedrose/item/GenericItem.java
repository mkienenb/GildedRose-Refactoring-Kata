package com.gildedrose.item;

import com.gildedrose.Item;

public class GenericItem extends UpdateableItem {
    public GenericItem(Item item) {
        super(item);
    }

    @Override
    public void updateQualityForItem() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
