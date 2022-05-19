package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Sale;

public class Printer 
{
	
	/**
	 * the printer
	 */
	public Printer()
	{
		
	}
	
	/**
	 * This method prints a receipt from the parameters below.
	 * @param sale
	 * @param amountPaid
	 * @param change
	 */
	public void printReceipt(Sale sale, double amountPaid, double change)
	{
		String receipt = "\n\nReceipt for proof of purchase at Generic Grocery Store\n\n" + sale.toString()
			+ "\nAmount paid: $" + amountPaid + "\nChange: $" + change + "\n\nThank you, come again!\n\n\n";
		System.out.println(receipt);
	}
}
