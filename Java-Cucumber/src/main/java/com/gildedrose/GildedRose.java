package com.gildedrose;

class GildedRose {
    public static final java.lang.String ITEM_NAME__AGED_BRIE = "Aged Brie";
    public static final java.lang.String ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final java.lang.String ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    {
        zeroItemQuality(item);
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateQualityOfItem(item);
        }
    }

    private void updateQualityOfItem(Item item) {
        switch (item.name) {
            case ITEM_NAME__AGED_BRIE:
                updateQualityOfAgedBrie(item);
                break;
            case ITEM_NAME__BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateQualityOfBackstagePasses(item);
                break;
            case ITEM_NAME__SULFURAS_HAND_OF_RAGNAROS:
                updateQualityOfSulfuras(item);
                break;
            default:
                updateQualityOfOtherItems(item);
                break;
        }
    }

    private void updateQualityOfAgedBrie(Item item) {
        if (item.sellIn >= 0) {
            guardedIncreaseQuality(item);
        } else {
            guardedIncreaseQuality(item);
            guardedIncreaseQuality(item);
        }
    }

    private void updateQualityOfBackstagePasses(Item item) {
        if (item.sellIn > 10) {
            guardedIncreaseQuality(item);
        } else if (item.sellIn > 5) {
            guardedIncreaseQuality(item);
            guardedIncreaseQuality(item);
        } else {
            guardedIncreaseQuality(item);
            guardedIncreaseQuality(item);
            guardedIncreaseQuality(item);
        }
    }

    private void updateQualityOfSulfuras(Item item) {
    }

    private void updateQualityOfOtherItems(Item item) {
        guardedDecreaseItemQuality(item);
        decreaseItemSellin(item);

        if (item.sellIn < 0) {
            guardedDecreaseItemQuality(item);
        }
    }

    private void guardedIncreaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void guardedDecreaseItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void zeroItemQuality(Item item) {
        item.quality = 0;
    }

    private void decreaseItemSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

}
