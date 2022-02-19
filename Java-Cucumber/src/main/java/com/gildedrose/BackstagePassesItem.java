package com.gildedrose;

public class BackstagePassesItem extends Item {
    public static final String ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassesItem(int sellIn, int quality) {
        super(ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, quality);
    }

    @Override
    public void updateQualityForItem() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
