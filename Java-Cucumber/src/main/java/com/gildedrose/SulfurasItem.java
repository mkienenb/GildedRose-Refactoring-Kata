package com.gildedrose;

import static com.gildedrose.AgedBrieItem.ITEM_NAME__AGED_BRIE;
import static com.gildedrose.BackstagePassesItem.ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT;

public class SulfurasItem extends Item {
    public static final String ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public SulfurasItem(int sellIn, int quality) {
        super(ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
    }

    @Override
    public void updateQualityForItem() {
    }
}
