package se.kth.iv1350.pos.integration;

public class Register 
{
	private double amountInRegister;
	
	/**
	 * The method that calculates the change, and updates the amount currently present in the register.
	 * @param price
	 * @param amountPaid
	 */
	public double addPaymentToRegister(double price, double amountPaid)
	{
		double change = 0;
		if (price <= amountPaid)
		{
			change = amountPaid-price;
			amountInRegister += amountPaid-change;
		}
		else
		{
			//We've been scammed... not again :(
		}
		return change;
	}
}
