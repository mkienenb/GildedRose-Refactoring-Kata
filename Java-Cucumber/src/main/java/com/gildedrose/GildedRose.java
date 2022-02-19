package com.gildedrose;

import com.gildedrose.item.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateableItem updateableItem = UpdateableItem.createUpdatableItem(item);
            updateableItem.updateQualityForItem();
        }
    }
}
