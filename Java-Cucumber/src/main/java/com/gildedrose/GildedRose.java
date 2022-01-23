package com.gildedrose;

class GildedRose {
    private static final String ITEM__AGED_BRIE = "Aged Brie";
    private static final String ITEM__BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String ITEM__SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (itemMatches(item, ITEM__AGED_BRIE)) {
                decreaseSellInByOne(item);
                increaseQualityByOneIfLessThanMax(item);
                if (item.sellIn < 0) {
                    increaseQualityByOneIfLessThanMax(item);
                }
            } else if (itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    increaseQualityByOne(item);

                    if (item.sellIn < 11) {
                        increaseQualityByOneIfLessThanMax(item);
                    }
                    if (item.sellIn < 6) {
                        increaseQualityByOneIfLessThanMax(item);
                    }
                }
                decreaseSellInByOne(item);
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else if (itemMatches(item, ITEM__SULFURAS)) {
                // We do nothing
            } else {
                decreaseSellInByOne(item);
                decreaseQualityByOneIfGreaterThanMin(item);
                if (item.sellIn < 0) {
                    decreaseQualityByOneIfGreaterThanMin(item);
                }
            }
        }
    }

    private void decreaseQualityByOneIfGreaterThanMin(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityByOneIfLessThanMax(Item item) {
        if (item.quality < 50) {
            increaseQualityByOne(item);
        }
    }

    private boolean itemMatches(Item item, String itemName) {
        return item.name.equals(itemName);
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }
}
