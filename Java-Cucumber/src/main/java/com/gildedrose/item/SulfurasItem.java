package com.gildedrose.item;

public class SulfurasItem extends UpdateableItem {
    public static final String ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public SulfurasItem(int sellIn, int quality) {
        super(ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
    }

    @Override
    public void updateQualityForItem() {
    }
}
