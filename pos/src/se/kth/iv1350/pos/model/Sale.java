package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sale 
{
	private ArrayList<Item> addedItems = new ArrayList<>();
	private LocalTime starttimeOfSale;
	private double runningTotal;
	
	private ArrayList<TotalRevenueObserver> totalRevenueObserverList = new ArrayList<TotalRevenueObserver>();
	
	/**
	 * This is the sale function. It is called at the start of a new sale, and saves the time
	 * for use later in the receipt and Sale log.
	 */
	public Sale() 
	{
		starttimeOfSale = LocalTime.now();
	}
	
	/**
	 * This method is called for adding an item to the current sales list of items.
	 * this method only manages adding an item to the list, through other methods. 
	 * first checks if the item is already on the list. 
	 * if true, increase the number of that item. otherwise, increase the list size and then add the item.
	 * then lastly, update the running total and display the changes.
	 * @param item
	 */
	public String addItemToSale(Item item)
	{
		int arraySlot = isItemAlreadyInList(item);
		if (arraySlot == -1)
		{
			//addedItems = copyArrayAndAddSlots(addedItems, 1);
			addANewItemToList(item);
		}
		else
		{
			increaseNumberOfItem(arraySlot);
		}
		updateRunningTotal(item);
		return getAddedItemAsString(item);	
	}
	
	
	private void addANewItemToList(Item item)
	{
		addedItems.add(item);		//This is to add the item object to the list
		item.upAmountByOne();		//This adds +1 to the amount of the item that is in the list (because the starting amount is 0)
		
	}
	
	
	private void updateRunningTotal(Item item)
	{
		runningTotal += getItemPriceWithVAT(item);
	}
	
	
	private double getItemPriceWithVAT(Item item)
	{
		return item.getPrice()*(1+item.getVATRate()/100);
	}
	
	
	private void increaseNumberOfItem(int arraySlot)
	{
		addedItems.get(arraySlot).upAmountByOne();
	}
	
	
	private int isItemAlreadyInList(Item item)
	{
		String identifier = item.getIdentifier();
		int differentProducts = addedItems.size();
		for(int i = 0; i < differentProducts; i++)
		{
			if (addedItems.get(i).getIdentifier().equals(identifier))
			{
				return i;
			}
		}
		return -1; //The return can't be -1 unless the item is not in the list.
	}
	
	private String getAddedItemAsString(Item item)
	{
		return ("\nAdded " + item.getName() + " to cart." +
				"\n  VAT: " + item.getVATRate() + "%" +
				"\n  Description: '" + item.getItemDescription() + "'" +
				"\n  Price: $" + item.getPrice() +
				"\n  Amount: " + item.getAmount() + 
				"\nRunning Total: $" + runningTotal);
	}
	
	/**
	 * method returns the running total of the sale
	 * @return the running total
	 */
	public double getRunningTotal()
	{
		return runningTotal;
	}
	/**
	 * To make the receipt printing n accounting logging easier. This only
	 * gives out the time of day, items(toString) and total price. NOT amountPaid or change.
	 */
	public String toString()
	{
		String itemString = "";
		for (int i = 0; i < addedItems.size(); i++)
		{
			itemString = itemString + addedItems.get(i).toString() + "\n\n";
		}
		return "Time of day: " + starttimeOfSale.toString() + 
				"\n\nItems purchased: \n" + itemString + 
				"Total price: $" + getRunningTotal();
	}
	
	/**
	 * Notifies all observers. 
	 */
	public void notifyObservers()
	{
		for(TotalRevenueObserver observer : totalRevenueObserverList)
		{
			observer.updateRevenue(runningTotal);
		}
	}
	
	/**
	 * Adds a whole list of new observers to the observer list
	 * @param observer The observer that will be added
	 */
	public void addNewRevenueObserver(ArrayList<TotalRevenueObserver> observer) 
	{
		totalRevenueObserverList.addAll(observer);
	}


}
