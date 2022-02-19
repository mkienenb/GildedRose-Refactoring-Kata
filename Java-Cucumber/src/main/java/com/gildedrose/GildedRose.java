package com.gildedrose;

class GildedRose {
    public static final String ITEM_NAME__AGED_BRIE = "Aged Brie";
    public static final String ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityForItem(item);
        }
    }

    private void updateQualityForItem(Item item) {
        switch (item.name) {
            case ITEM_NAME__AGED_BRIE:
                updateQualityForAgedBrie(item);
                break;
            case ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateQualityForBackstagePasses(item);
                break;
            case ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS:
                updateQualityForSulfuras(item);
                break;
            default:
                updateQualityForOtherItems(item);
                break;
        }
    }

    private void updateQualityForSulfuras(Item item) {
    }

    private void updateQualityForOtherItems(Item item) {
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

    private void updateQualityForBackstagePasses(Item item) {
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

    private void updateQualityForAgedBrie(Item item) {
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
