package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public final class ItemStepDefinitions {
    private static final String ITEM__AGED_BRIE = "Aged Brie";
    private static final String ITEM__SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String ITEM__BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private Item[] items = new Item[1];
    private GildedRose app;

    protected void some_item_has_sell_in_of_and_the_item_has_quality_of(String itemName, Integer sellIn, Integer quality) {
        items[0] = new Item(itemName, sellIn, quality);
        app = new GildedRose(items);
    }

    @Given("The item is named {string}")
    public void the_item_is_named(String name) {
        some_item_has_sell_in_of_and_the_item_has_quality_of(name, 0, 0);
    }

    @When("I update the quality")
    public void i_update_the_quality() {
        app.updateQuality();
    }

    @Then("I should get an item named {string}")
    public void i_should_get_an_item_named(String expectedName) {
        assertThat(app.items[0].name).as("name for first item").isEqualTo(expectedName);
    }
    
    @Given("The normal item has SellIn of {int} And the item has Quality of {int}")
    public void the_normal_item_has_sell_in_of_and_the_item_has_quality_of(Integer sellIn, Integer quality) {
        some_item_has_sell_in_of_and_the_item_has_quality_of("foo", sellIn, quality);
    }

    @Then("the item SellIn should be {int}")
    public void the_item_sell_in_should_be(Integer expectedSellIn) {
        assertThat(app.items[0].sellIn).as("sell-in for first item").isEqualTo(expectedSellIn);
    }

    @Then("the item Quality should be {int}")
    public void the_item_quality_should_be(Integer expectedQuality) {
        assertThat(app.items[0].quality).as("quality for first item").isEqualTo(expectedQuality);
    }

    @Given("The aged brie item has SellIn of {int} And a Quality of {int}")
    public void the_aged_brie_item_has_sell_in_of_and_a_quality_of(Integer sellIn, Integer quality) {
        some_item_has_sell_in_of_and_the_item_has_quality_of(ITEM__AGED_BRIE, sellIn, quality);
    }

    @Given("The Sulfuras item has SellIn of {int} And a Quality of {int}")
    public void the_sulfuras_item_has_sell_in_of_and_a_quality_of(Integer sellIn, Integer quality) {
        some_item_has_sell_in_of_and_the_item_has_quality_of(ITEM__SULFURAS, sellIn, quality);
    }

    @Given("The backstage passes item has SellIn of {int} And a Quality of {int}")
    public void the_backstage_passes_item_has_sell_in_of_and_a_quality_of(Integer sellIn, Integer quality) {
        some_item_has_sell_in_of_and_the_item_has_quality_of(ITEM__BACKSTAGE_PASSES, sellIn, quality);
    }
}

