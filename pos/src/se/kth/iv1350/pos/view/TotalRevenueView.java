package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.TotalRevenueObserver;
/**
 * A class for keeping the view updated on the total revenue
 *
 */
public class TotalRevenueView implements TotalRevenueObserver
{
	private double totalRevenue = 0;
	/**
	 * prints the total profit for the store.
	 * @param totalRevenue the total revenue
	 */
	@Override
	public void updateRevenue(double latestIncome)
	{
		calculateUpdatedRevenue(latestIncome);
		System.out.println("\n*****\nThe total revenue so far is: $" + totalRevenue + "\n*****\n");
	}
	
	private void calculateUpdatedRevenue(double latestIncome)
	{
		totalRevenue = totalRevenue + latestIncome;
	}
}
