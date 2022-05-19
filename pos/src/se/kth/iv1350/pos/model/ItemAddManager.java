package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import se.kth.iv1350.pos.integration.InventoryServerConnectionIssueException;
import se.kth.iv1350.pos.model.ItemIdentifier;
import se.kth.iv1350.pos.model.Sale;


public class ItemAddManager 
{
	private Sale sale;
	private ItemIdentifier itemIdentifier;
	
	/**
	 * The method takes both the amount of goods, as well as it's barcode/item identifier 
	 * and adds those goods to the Sale by first identifying the item, and then adding the amount.
	 * @param sale
	 */
	public ItemAddManager(Sale sale)
	{
		this.sale = sale;
		itemIdentifier = new ItemIdentifier();
		
	}
	
	/**
	 * Passes the barcode to ItemIdentifier for evaluation (either gets an item back, or invalid item)
	 * An invalid item is represented by null. then checks for the same item in the current sale
	 * and adds the amount if there's none, otherwise it ups the number already in the sale by the amount.
	 * @param barcode
	 * @param amount
	 * @throws InvalidItemIdentifierException 
	 */
	public String evaluateScannedItem(String barcode, int amount) throws InvalidItemIdentifierException, InventoryServerConnectionIssueException
	{
		Item requestedItem = itemIdentifier.getItemWithIdentifier(barcode);
		return addAmountOfItem(requestedItem, amount);
	}
	
	private String addAmountOfItem(Item item, int amount)
	{
		String addedItemAsString = "";
		for(int i = 0; i < amount; i++)
		{
			addedItemAsString = sale.addItemToSale(item);
		}
		return addedItemAsString;
	}
	
}
