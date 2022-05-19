package se.kth.iv1350.pos.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.pos.model.TotalRevenueObserver;

/**
 * A class for writing the total revenue to a text file
 */
public class TotalRevenueFileOutput implements TotalRevenueObserver
{
	private PrintWriter logStream;
	
	/**
	 * Creates a new log file for this instance. Existing log file will be removed
	 */
	public TotalRevenueFileOutput()
	{
		try
		{
			logStream = new PrintWriter(new FileWriter("totalRevenueLog.txt"), true);
		}
		catch (IOException exception)
		{
			System.out.println("Can't cannot not log :)");
			exception.printStackTrace();
		}
	}
	/**
	 * Writes to the log file
	 * @param message The string that will be written in the log file
	 */
	public void writeLog(String message)
	{
		logStream.println(message);
	}
	
	/**
	 * prints the total profit for the store.
	 * @param totalRevenue the total revenue
	 */
	@Override
	public void updateRevenue(double latestIncome)
	{
		writeLog("New sale completed for: $" + latestIncome);
	}
}
