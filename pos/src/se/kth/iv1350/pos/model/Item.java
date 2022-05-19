package se.kth.iv1350.pos.model;



public class Item 
{
	String identifier;
	String name;
	String itemDescription;
	float price;
	int amount;
	float vatRate;
	
	/**
	 * A item the store sells. It's parameters are information about the item as stated.
	 * @param identifier: barcode that identifies this item.
	 * @param name: name of item.
	 * @param itemDescription: describes the item.
	 * @param price: how much the item costs to buy.
	 * @param amount: amount of items in the sale (the amount of this item that have been scanned).
	 * @param vatRate: a percentage of VAT tax on the item.
	 */
	public Item(String identifier, String name, String itemDescription, float price, int amount, float vatRate)
	{
		this.identifier = identifier;
		this.name = name;
		this.itemDescription = itemDescription;
		this.price = price;
		this.amount = amount;
		this.vatRate = vatRate;
	}
	
	/**
	 * @return returns identifier
	 */
    public String getIdentifier() 
    {
        return identifier;
    }

    /**
	 * @return name
	 */
    public String getName()
    {
    	return name;
    }
    
    /**
	 * @return description
	 */
    public String getItemDescription() 
    {
    	return itemDescription;
    }

    /**
	 * @return price
	 */
    public float getPrice() 
    {
        return price;
    }

    /**
	 * @return amount
	 */
    public int getAmount()
    {
    	return amount;
    }
    
    /**
	 * set a new amount of this item
	 */
    public void setAmount(int newAmount)
    {
    	amount = newAmount; 
    }
    
    /**
     * The same as setAmount, but only adds one as a quality of life.
     */
    public void upAmountByOne()
    {
    	amount++; 
    }

    /**
	 * @return vat rate
	 */
    public float getVATRate() 
    {
        return vatRate;
    }
    
    /**
     * For returning a string that describes the item and its variables.
     */
    public String toString()
    {
    	return "Product " + identifier + ":\n " +
    			name + "\n " +
    			itemDescription + "\n " +
    			"Price $" + price + "\n " +
    			"Amount " + amount + "\n " + 
    			"VAT " + vatRate + "%";
    }
}
