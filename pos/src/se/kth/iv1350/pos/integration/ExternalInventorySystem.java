package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Item;
import java.util.ArrayList;
import java.util.List;

public class ExternalInventorySystem 
{
	private final  ArrayList<Item> inventory = new ArrayList<>();
	
	/**
	 * The inventory and it's contents this instance.
	 */
	public ExternalInventorySystem()
	{
		/*
		 * #################---IMPORTANT---#################
		 * The Item() method takes the following input:
		 * int identifier, String name, String itemDescription, float price, int amount, float vatRate
		 */
		inventory.add(new Item("0001", "McDonkel's Fries", "The tastiest fries around", 2.99f, 0, 25f));
		inventory.add(new Item("0002", "Konka Kola", "Real Magic is only a sip away", 3.49f, 0, 25f));
		inventory.add(new Item("0003", "Casio Saxophone", "Does Casio even make saxophones?", 11.95f, 0, 12f));
		inventory.add(new Item("0004", "KTH Merch", "The coolest merch out there", 32f, 0, 6f));
		inventory.add(new Item("0005", "Amazon Gift Cards", "Totally legit", 49.99f, 0, 12f));
	}
	
	/**
	 * This method takes an identifier/barcode and finds the respective item in the inventory. 
	 * Tried to throw exception but couldn't figure out how, so it just returns null.
	 * @param identifier: the barcode that identifies each item.
	 * @return the item with the inputed barcode, or null if no such item exists.
	 */
	public Item getItem(String identifier) throws InvalidItemIdentifierException, InventoryServerConnectionIssueException
	{
		if (identifier.equals("404")) //The specific "non-existing" identifier will cause a connection error
		{
			connectionError();
			return null;
		}
		else
		{
			return searchInventory(identifier);
			 
		}
		
	}
	private Item searchInventory(String identifier) throws InvalidItemIdentifierException
	{
		for (Item item : inventory)
		{
			if (item.getIdentifier().equals(identifier))
			{
				return item;
			}
		}
		throw new InvalidItemIdentifierException(identifier);
	}
	private void connectionError() throws InventoryServerConnectionIssueException
	{
		throw new InventoryServerConnectionIssueException("\n### InventoryServerConnectionIssueException: "
        		+ "Could not connect to the inventory server when scanning an item. This is "
				+ "caused because the identifier used was likely '404'. ###"); 
	}
	
	
}
