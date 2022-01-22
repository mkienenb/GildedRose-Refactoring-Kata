Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking item named foo
    Given The item is named "foo"
    When I update the quality
    Then I should get an item named "foo"

  Scenario Outline: Checking that normal item quality and SellIn decrease by one during updates
    Given The normal item has SellIn of <startingSellIn> And the item has Quality of <startingQuality>
    When I update the quality
    Then the item SellIn should be <finalSellIn>
    #          which is one less
    And the item Quality should be <finalQuality>

    #          which is one less
    #
    Examples: 
      | startingQuality | finalQuality | startingSellIn | finalSellIn |
      |               5 |            4 |             23 |          22 |
      |               7 |            6 |             29 |          28 |
      |              11 |           10 |             31 |          30 |
      |              13 |           12 |             41 |          40 |
      |               1 |            0 |             61 |          60 |
      |              17 |           15 |             0  |          -1 |
      |              19 |           17 |            -1  |          -2 |

  Scenario: Checking that normal item quality never goes below zero
    Given The normal item has SellIn of 10 And the item has Quality of 0
    When I update the quality
    Then the item SellIn should be 9
    And the item Quality should be 0

  Scenario Outline: Checking that normal item quality decreases by two during updates when SellIn is zero
    Given The normal item has SellIn of <startingSellIn> And the item has Quality of <startingQuality>
    When I update the quality
    Then the item SellIn should be <finalSellIn>
    #          which is two less
    And the item Quality should be <finalQuality>

    #          which is two less
    #
    Examples: 
      | startingQuality | finalQuality | startingSellIn | finalSellIn |
      |              17 |           15 |             0  |          -1 |
      |              19 |           17 |            -1  |          -2 |

  Scenario Outline: "Aged Brie" actually increases in Quality the older it gets
    Given The aged brie item has SellIn of <startingSellIn> And a Quality of <startingQuality>
    When I update the quality
    Then the item SellIn should be <finalSellIn>
    And the item Quality should be <finalQuality>

    Examples: 
      | startingQuality | finalQuality | startingSellIn | finalSellIn |
      |               1 |            2 |             61 |          60 |
      |               5 |            6 |             23 |          22 |
      |               7 |            8 |             29 |          28 |
      |              11 |           12 |             31 |          30 |
      |              49 |           50 |             41 |          40 |

  Scenario: "Aged Brie" will not increase in Quality past 50
    Given The aged brie item has SellIn of 7 And a Quality of 50
    When I update the quality
    Then the item SellIn should be 6
    And the item Quality should be 50

  Scenario Outline: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    Given The Sulfuras item has SellIn of <sellIn> And a Quality of <quality>
    When I update the quality
    Then the item SellIn should be <sellIn>
    And the item Quality should be <quality>

    Examples: 
      | quality | sellIn |
      |       1 |     60 |
      |       5 |     22 |
      |       7 |     28 |
      |      11 |     30 |
      |      49 |     40 |

  Scenario: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality but is there a bug if there's a negative SellIn?
    Given The Sulfuras item has SellIn of -5 And a Quality of 30
    When I update the quality
    Then the item SellIn should be -5
    And the item Quality should be 30

  Scenario: "Backstage passes" quality increases by 1 when there are 11 days or more
    Given The backstage passes item has SellIn of 11 And a Quality of 23
    When I update the quality
    Then the item SellIn should be 10
    And the item Quality should be 24

  Scenario: "Backstage passes" quality increases by 2 when there are 10 days or less
    Given The backstage passes item has SellIn of 10 And a Quality of 31
    When I update the quality
    Then the item SellIn should be 9
    And the item Quality should be 33

  Scenario: "Backstage passes" quality increases by 3 when there are 5 days or less but
    Given The backstage passes item has SellIn of 3 And a Quality of 41
    When I update the quality
    Then the item SellIn should be 2
    And the item Quality should be 44

  Scenario: "Backstage passes" quality drops to 0 after the concert
    Given The backstage passes item has SellIn of -1 And a Quality of 11
    When I update the quality
    Then the item SellIn should be -2
    And the item Quality should be 0

  Scenario Outline: "Backstage passes" have a wide range of quality change rules
    Given The backstage passes item has SellIn of <startingSellIn> And a Quality of <startingQuality>
    When I update the quality
    Then the item SellIn should be <finalSellIn>
    And the item Quality should be <finalQuality>

    Examples: 
      | startingQuality | finalQuality | startingSellIn | finalSellIn |
      |              25 |           26 |             11 |          10 |
      |              25 |           27 |             10 |           9 |
      |              25 |           27 |              9 |           8 |
      |              25 |           27 |              6 |           5 |
      |              25 |           28 |              5 |           4 |
      |              25 |           28 |              4 |           3 |
      |              25 |            0 |              0 |          -1 |
      |              25 |            0 |             -1 |          -2 |
