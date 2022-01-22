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

	    if (itemMatches(item, ITEM__AGED_BRIE) || itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
		if (item.quality < 50) {
		    increaseQualityByOne(item);

		    if (itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
			if (item.quality < 50) {
			    if (item.sellIn < 11) {
				increaseQualityByOne(item);
			    }
			}

			if (item.quality < 50) {
			    if (item.sellIn < 6) {
				increaseQualityByOne(item);
			    }
			}
		    }
		}
	    } else {
		if (item.quality > 0) {
		    if (!itemMatches(item, ITEM__SULFURAS)) {
			decreaseQualityByOne(item);
		    }
		}
	    }

	    if (!itemMatches(item, ITEM__SULFURAS)) {
		decreaseSellInByOne(item);
	    }

	    if (item.sellIn < 0) {
		if (!itemMatches(item, ITEM__AGED_BRIE)) {
		    if (!itemMatches(item, ITEM__BACKSTAGE_PASSES)) {
			if (item.quality > 0) {
			    if (!itemMatches(item, ITEM__SULFURAS)) {
				decreaseQualityByOne(item);
			    }
			}
		    } else {
			item.quality = 0;
		    }
		} else {
		    if (item.quality < 50) {
			increaseQualityByOne(item);
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
