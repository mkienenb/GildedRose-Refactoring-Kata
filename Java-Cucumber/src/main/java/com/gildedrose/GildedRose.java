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
                if (item.quality < 50) {
                    increaseQualityByOne(item);
                }
                decreaseSellInByOne(item);
            } else if (itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    increaseQualityByOne(item);

                    if (item.quality < 50) {
                        if (item.sellIn < 11) {
                            increaseQualityByOne(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQualityByOne(item);
                        }
                    }
                }
                decreaseSellInByOne(item);
            } else if (itemMatches(item, ITEM__SULFURAS)) {
                // We do nothing
            } else {
                if (item.quality > 0) {
                    decreaseQualityByOne(item);
                }
                decreaseSellInByOne(item);
            }

            if (itemMatches(item, ITEM__AGED_BRIE)) {
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        increaseQualityByOne(item);
                    }
                }
            } else if (itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else if (itemMatches(item, ITEM__SULFURAS)) {
                if (item.sellIn < 0) {
                }
                // ITEM__SULFURAS never changes sellIN,
                // so this would only be reached if entered with a negative SellIn amount
                // This can be removed if SellIn is never negative
            } else {
                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        decreaseQualityByOne(item);
                    }
                }
            }
        }
    }

    private boolean itemMatches(Item item, String itemName) {
        return item.name.equals(itemName);
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }
}
