package com.rupert.learning.guildedrose2020;

import static org.junit.Assert.assertEquals;

//import org.junit.Ignore;
import org.junit.Test;

public class GildedRose2020Test {
	
	//Normal Item Tests
	
    @Test
    public void normalItemDecreaseSellInByOneDecreaseQualityByOne() {
    	 Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
         GildedRose2020 app = new GildedRose2020(items);
         app.updateQuality();
         assertEquals(9, app.items[0].sellIn); 
         assertEquals(19, app.items[0].quality);	
    }
    
    @Test
    public void normalItemPassesSellByDateQualityDropsByTwo() {
    	 Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
         GildedRose2020 app = new GildedRose2020(items);
         app.updateQuality();
         assertEquals(-1, app.items[0].sellIn); 
         assertEquals(18, app.items[0].quality);	
    }
    
    @Test
    public void normalItemPassesSellByDateQualityDoesntDropBelowZero() {
    	 Item[] items = new Item[] { new Item("Normal Item", -1, 1) };
         GildedRose2020 app = new GildedRose2020(items);
         app.updateQuality();
         assertEquals(-2, app.items[0].sellIn); 
         assertEquals(0, app.items[0].quality);	
    }
	
  //Aged Brie Tests
    
    @Test
    public void agedBrieDecreaseSellInByOneIncreaseQualityByOne() {
    	 Item[] items = new Item[] { new Item("Aged Brie", 5, 25) };
         GildedRose2020 app = new GildedRose2020(items);
         app.updateQuality();
         assertEquals(4, app.items[0].sellIn); 
         assertEquals(26, app.items[0].quality);	
    }
}