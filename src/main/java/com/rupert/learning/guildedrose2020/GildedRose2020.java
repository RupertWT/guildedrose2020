package com.rupert.learning.guildedrose2020;

class GildedRose2020 {
    Item[] items;

    public GildedRose2020(Item[] items) {
        this.items = items;
    }
    
    public void updateItems() {
    	updateSellIn();
    	updateQuality();
    }
    
    public void updateSellIn() {
    	for (int i = 0; i < items.length; i++) {
    		sellIn(i);
    	}
    }

		private void sellIn(int i) {
			items[i].sellIn = (items[i].name.equals("Sulfuras, Hand of Ragnaros")) ? items[i].sellIn : items[i].sellIn -1;
		}
    
		
		
		
		
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
                    	
        	if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        		if (items[i].quality > 0) {
        			items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (items[i].sellIn-1 < 0) {
                if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1;
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
	
}