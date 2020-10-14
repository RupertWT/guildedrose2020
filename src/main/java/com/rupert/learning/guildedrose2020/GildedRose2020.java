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
        	quality(i);   	
        }
    }

	private void quality(int i) {
		String itemName = items[i].name;
		switch(itemName) {
			case "Sulfuras, Hand of Ragnaros":
				break;
			case "Aged Brie":
				agedBrieQualityStrategy(i);
				break;
			default:	
				if (itemName.contains("Backstage passes")) {
					backstagePassesQualityStrategy(i);
					break;
				} else {
					normalItemQualityStrategy(i);
					break;
				}
			}
	}

	private void backstagePassesQualityStrategy(int i) {

		if (pastSellByDate(i)) {
			items[i].quality = 0;
		} else if (items[i].sellIn <=5) {
			items[i].quality = items[i].quality + 3;
		} else if (items[i].sellIn <=10) {
			items[i].quality = items[i].quality + 2;
		} else {
			items[i].quality = items[i].quality + 1;
		}
		
		maxQualityThreshold(i);
		
	}

	private void normalItemQualityStrategy(int i) {
		
		if (pastSellByDate(i)) {
			items[i].quality = items[i].quality - 2;
		} else {
			items[i].quality = items[i].quality - 1;
		}
		
		minQualityThreshold(i);
		
	}

	private void minQualityThreshold(int i) {
		if (items[i].quality < 0) {
			items[i].quality = 0;
		}
	}

	private void agedBrieQualityStrategy(int i) {
		
		if (pastSellByDate(i)) {
			items[i].quality = items[i].quality + 2;
		} else {
			items[i].quality = items[i].quality + 1;
		}
		
		maxQualityThreshold(i);	
		
	}

	private void maxQualityThreshold(int i) {
		if (items[i].quality > 50) {
			items[i].quality = 50;
		}
	}
	
	private boolean pastSellByDate(int i) {
		return items[i].sellIn <=0;
	}
	
}