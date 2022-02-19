package com.gildedrose.item;

import com.gildedrose.Item;

import static com.gildedrose.item.AgedBrieItem.ITEM_NAME__AGED_BRIE;
import static com.gildedrose.item.BackstagePassesItem.ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT;
import static com.gildedrose.item.SulfurasItem.ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS;

public abstract class UpdateableItem {
    protected final Item item;

    public UpdateableItem(Item item) {
        this.item = item;
    }

    static public UpdateableItem createUpdatableItem(Item item) {
        switch (item.name) {
            case ITEM_NAME__AGED_BRIE:
                return new AgedBrieItem(item);
            case ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackstagePassesItem(item);
            case ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasItem(item);
            default:
                return new GenericItem(item);
        }
    }

    public abstract void updateQualityForItem();
}
