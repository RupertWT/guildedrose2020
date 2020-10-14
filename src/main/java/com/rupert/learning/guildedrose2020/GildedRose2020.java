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
    		applySellInStrategy(i);
    	}	
    }

	private void applySellInStrategy(int i) {
		
		String itemType;
		itemType = setItemType(i);
		
		switch(itemType) {
			case "Sulfuras":
				// sellIn doesn't change for Sulfuras
				break;
			default:	
				items[i].sellIn = items[i].sellIn - 1;
		}
	}
    		
	
	
	
    public void updateQuality() {
        
    	for (int i = 0; i < items.length; i++) {    	
    		applyQualityStrategy(i);	
        }
    }

	private void applyQualityStrategy(int i) {
		
		String itemType;
		itemType = setItemType(i);
		
		switch(itemType) {
			case "Sulfuras":
				// quality doesn't change for Sulfuras
				break;
			case "Aged Brie":
				agedBrieQualityStrategy(i);
				break;
			case "Backstage passes":
				backstagePassesQualityStrategy(i);
				break;
			case "Conjured":
				conjuredQualityStrategy(i);
				break;
			default:	
				normalItemQualityStrategy(i);
				break;
			}
	}

	private String setItemType(int i) {
		
		String itemType;
		if (items[i].name.contains("Sulfuras")) {
			itemType = "Sulfuras";
		} else if (items[i].name.contains("Aged Brie")) {
			itemType = "Aged Brie";
		} else if (items[i].name.contains("Backstage passes")) {
			itemType = "Backstage passes";
		} else if (items[i].name.contains("Conjured")) {
			itemType = "Conjured";
		} else {
			itemType = "Normal";
		}
		return itemType;
	}

	private void agedBrieQualityStrategy(int i) {
		
		if (pastSellByDate(i)) {
			items[i].quality = items[i].quality + 2;
		} else {
			items[i].quality = items[i].quality + 1;
		}
		
		maxQualityStrategy(i);		
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
		
		maxQualityStrategy(i);	
	}

	private void conjuredQualityStrategy(int i) {
		
		if (pastSellByDate(i)) {
			items[i].quality = items[i].quality - 4;
		} else {
			items[i].quality = items[i].quality - 2;
		}
	
		minQualitySgtrategy(i);	
		
	}
	
	private void normalItemQualityStrategy(int i) {
		
		if (pastSellByDate(i)) {
			items[i].quality = items[i].quality - 2;
		} else {
			items[i].quality = items[i].quality - 1;
		}
		
		minQualitySgtrategy(i);	
	}

	private void minQualitySgtrategy(int i) {
		
		if (items[i].quality < 0) {
			items[i].quality = 0;
		}
	}
	
	private void maxQualityStrategy(int i) {
		
		if (items[i].quality > 50) {
			items[i].quality = 50;
		}
	}
	
	private boolean pastSellByDate(int i) {
		
		return items[i].sellIn <=0;
	}
	
}