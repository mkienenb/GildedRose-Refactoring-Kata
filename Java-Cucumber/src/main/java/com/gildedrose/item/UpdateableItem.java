package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class UpdateableItem extends Item {
    public UpdateableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQualityForItem();
}
