package com.rupert.learning.guildedrose2020;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
//import org.junit.Ignore;
import org.junit.Test;

public class GildedRose2020Test {
	
// 	End to end test
	
    @Test
    public void normal_Item_End_To_End() {  	
    	Item[] items = new Item[] { 
    			new Item("Normal Item", 10, 20), 
    			new Item("Sulfuras, Hand of Ragnaros", 11, 22),
    			new Item("Blah", 15, 10)};
       
    	GildedRose2020 app = new GildedRose2020(items);
        app.updateItems();
        
        assertEquals(9, app.items[0].sellIn); 
        assertEquals(19, app.items[0].quality); 
        assertEquals(11, app.items[1].sellIn); 
        assertEquals(22, app.items[1].quality); 
        assertEquals(14, app.items[2].sellIn); 
        assertEquals(10, app.items[2].quality); 
    }
	
	
//	Normal Item SellIn Tests
	
    @Test
    public void normal_Item_Within_Sell_By_Date_Decrease_SellIn_By_One() {  	
    	Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn); 
    }
    
    @Test
    public void normal_Item_Outside_Sell_By_Date_Decrease_SellIn_By_One() {
    	Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(-1, app.items[0].sellIn); 
    }
    
//	Normal Item Quality Tests
        
    @Test
    public void normal_Item_Within_Sell_By_Date_Decrease_Quality_By_One() {
    	Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);	
    }
    
    @Test
    public void normal_Item_Within_Sell_By_Date_Quality_Doesnt_Go_Below_Zero() {
    	Item[] items = new Item[] { new Item("Normal Item", 15, 0) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);	
    }
    
    @Test
    public void normal_Item_Last_Sell_By_Date_Decrease_Quality_By_One() {
    	Item[] items = new Item[] { new Item("Normal Item", 1, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);	
    }
    
    @Test
    public void normal_Item_Outside_Sell_By_Date_Decrease_Quality_By_Two() {
    	Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality); 
    } 
    
    @Test
    public void normal_Item_Outside_Sell_By_Date_Quality_Doesnt_Go_Below_Zero() {
    	Item[] items = new Item[] { new Item("Normal Item", -1, 1) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);	
    }
	
//	Aged Brie SellIn Tests
    
    @Test
    public void aged_Brie_Within_Sell_By_Date_Decrease_SellIn_By_One() {  	
    	Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn); 
    }
    
    @Test
    public void aged_Brie_Outside_Sell_By_Date_Decrease_SellIn_By_One() {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(-1, app.items[0].sellIn); 
    }
    
//	Aged Brie Quality Tests
    
    @Test
    public void aged_Brie_Within_Sell_By_Date_Increase_Quality_By_One() {
    	Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);	
    }
    
    @Test
    public void aged_Brie_Within_Sell_By_Date_Quality_Doesnt_Go_Above_Fifty() {
    	Item[] items = new Item[] { new Item("Aged Brie", 15, 50) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
    @Test
    public void aged_Brie_Last_Sell_By_Date_Increase_Quality_By_One() {
    	Item[] items = new Item[] { new Item("Aged Brie", 1, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);	
    }
    
    @Test
    public void aged_Brie_Outside_Sell_By_Date_Increase_Quality_By_Two() {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality); 
    } 
    
    @Test
    public void aged_Brie_Outside_Sell_By_Date_Quality_Doesnt_Go_Above_Fifty() {
    	Item[] items = new Item[] { new Item("Aged Brie", -1, 49) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
//	Sulfuras SellIn Tests    

    @Test
    public void sulfuras_Sell_By_Date_Doesnt_Change() {  	
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 9, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn); 
    }
    
//	Sulfuras Quality Tests    

    @Test
    public void sulfuras_Quality_Doesnt_Change() {  	
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 9, 80) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality); 
    }    

//	Backstage SellIn Tests  
    
    @Test
    public void backstage_Item_Within_Sell_By_Date_Decrease_SellIn_By_One() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn); 
    }
    
    @Test
    public void backstage_Item_Outside_Sell_By_Date_Decrease_SellIn_By_One() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateSellIn();
        assertEquals(-1, app.items[0].sellIn); 
    }
    
//	Backstage Quality Tests
    
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_One_More_Than_Ten_Days_Left() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality); 
    }
    
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_Two_More_Than_Five_Days_Less_Than_Ten_Left() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality); 
    }
    
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_Two_More_Eleven_Days_Left() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality); 
    }
    
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_Three_More_Than_Zero_Days_Less_Than_Five_Left() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality); 
    }
    
    @Test
    public void backstage_Item_Outside_Sell_By_Date_Decrease_SellIn_To_Zero() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality); 
    }
    
    //@Ignore
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_One_More_Than_Ten_Days_Left_But_Not_Above_Fifty() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 51) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(51, app.items[0].quality); 
    }
    
    //@Ignore
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_Two_More_Than_Five_Days_Less_Than_Ten_Left_But_Not_Above_Fifty() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 51) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(51, app.items[0].quality); 
    }
    
    //@Ignore
    @Test
    public void backstage_Item_Within_Sell_By_Date_Increase_SellIn_By_Three_More_Than_Zero_Days_Less_Than_Five_Left_But_Not_Above_Fifty() {  	
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 51) };
        GildedRose2020 app = new GildedRose2020(items);
        app.updateQuality();
        assertEquals(51, app.items[0].quality); 
    }

}