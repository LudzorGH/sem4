package se.kth.iv1350.pos.model;


/**
 * A listener interface for receiving notifications about the total revenue. The class that is intetrested
 * in such notifications implements this interface.
 */
public interface TotalRevenueObserver
{
	void updateRevenue(double latestIncome);
}

