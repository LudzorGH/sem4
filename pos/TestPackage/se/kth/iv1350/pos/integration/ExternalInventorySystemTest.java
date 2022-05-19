package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.model.Item;


class ExternalInventorySystemTest 
{
	private ExternalInventorySystem testInventory;
	private String itemIdentifier;
	
	private Item testedItem;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testInventory = new ExternalInventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testInventory = null;
		testedItem = null;
	}

	@Test
	void testValidItemIdentifier() throws InvalidItemIdentifierException, InventoryServerConnectionIssueException
	{
		itemIdentifier = "0004";
		try
		{
			testedItem = testInventory.getItem(itemIdentifier);
			assert(true);
		}
		catch (InvalidItemIdentifierException invalidIdentifierException)
		{
			//fail("Failed: The item identifier was invalid.");
			assert(false);
		}
		catch (InventoryServerConnectionIssueException inventoryConnectionIssueException)
		{
			//fail("Failed: No connection to test server.");
			assert(false);
		}
	}
	
	@Test
	void testInvalidItemIdentifierException() throws InvalidItemIdentifierException
	{
		itemIdentifier = "4985";
		try
		{
			testedItem = testInventory.getItem(itemIdentifier);
			//fail("Failed: Inventory found an item with invalid identifier.");
			assert(false);
		}
		catch (InvalidItemIdentifierException invalidIdentifierException)
		{
			assert(true);
		}
	}
	
	@Test
	void testInventoryServerConnectionIssueException() throws InventoryServerConnectionIssueException, InvalidItemIdentifierException
	{
		itemIdentifier = "404";
		try
		{
			testedItem = testInventory.getItem(itemIdentifier);
			//fail("Failed: Found test server even though connection error occured.");
			assert(false);
		}
		catch (InventoryServerConnectionIssueException inventoryConnectionIssueException)
		{
			assert(true);
		}
	}
}
