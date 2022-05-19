package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import se.kth.iv1350.pos.integration.InventoryServerConnectionIssueException;
import se.kth.iv1350.pos.logging.TotalRevenueFileOutput;

public class View 
{
	private Controller controller;
	private ErrorMessagePrinter errorMessagePrinter = new ErrorMessagePrinter();
	private DeveloperMessagePrinter devMessagePrinter = new DeveloperMessagePrinter();
	
	/**
	 * Creates a controller so the entire sale process can begin. A controller is necessary, since we're
	 * using MVC (Model, View, Controller).
	 * @param controller
	 */
	public View(Controller controller)
	{
		this.controller = controller;
		controller.addNewRevenueObserver(new TotalRevenueView());
		controller.addNewRevenueObserver(new TotalRevenueFileOutput());

	}
	
	/**
	 * A testing void for starting a test sale, which will tell the controller to start it's sale process.
	 * @throws InvalidItemIdentifierException if the identifier is invalid
	 * @throws InventoryServerConnectionIssueException if there's no connection to the inventory server (if the string is null)
	 */
	public void startATestSale() throws InvalidItemIdentifierException
	{
		//Starting a test sale
		//devMessagePrinter.logDevMessage("Starting a test sale");
		controller.startSale();
		try 
		{
			//Adding items to the test sale's shoppinglist
			//devMessagePrinter.logDevMessage("Adding items to shoppinglist");
			
			System.out.println	(controller.scanItem("0001", 1));
			System.out.println	(controller.scanItem("0003", 1));
			System.out.println	(controller.scanItem("0001", 1));
			System.out.println	(controller.scanItem("0002", 3));
			System.out.println	(controller.scanItem("0004", 1));
		}
		catch (InvalidItemIdentifierException exception)
		{
			errorMessagePrinter.printErrorMessage("The item identifier " + exception.getInvalidItemIdentifier() + " is invalid.");
		}
		catch (InventoryServerConnectionIssueException exception)
		{
			errorMessagePrinter.printErrorMessage("Could not connect to the inventory server. Please check connection and try again.");
		}
		//Ending the test sale
		//devMessagePrinter.logDevMessage("Ending test sale");
		System.out.println("\n\nSale has ended.\nTotal price incl. VAT is: $" + controller.endSale());
		
		//Paying for the test sale
		double testPayment = 100;
		//devMessagePrinter.logDevMessage("Customer paid $" + testPayment +  ". Completeing sale");
		controller.completedSale(testPayment);
	}
	
	/**
	 * Another testing void for starting a test sale. This test sale tests some different things, like exceptions.
	 * @throws InvalidItemIdentifierException if the identifier is invalid
	 * @throws InventoryServerConnectionIssueException if there's no connection to the inventory server (if the string is null)
	 */	
	
	public void startAnotherTestSale() throws InvalidItemIdentifierException, InventoryServerConnectionIssueException
	{
		//devMessagePrinter.logDevMessage("Starting another test sale");
		controller.startSale();
		try 
		{
			//devMessagePrinter.logDevMessage("Adding more items to shoppinglist");
			System.out.println	(controller.scanItem("0001", 1));
			System.out.println	(controller.scanItem("1337", 4)); //This item identifier doesn't exist
			System.out.println	(controller.scanItem("404", 4)); //This item identifier will cause connection error

		}
		catch (InvalidItemIdentifierException exception)
		{
			errorMessagePrinter.printErrorMessage("\nThe item identifier " + exception.getInvalidItemIdentifier() + " is invalid.");
			devMessagePrinter.logDevMessage(exception);
			
		}
		catch (InventoryServerConnectionIssueException exception)
		{
			errorMessagePrinter.printErrorMessage("\nCould not connect to the inventory server. Please check connection and try again.");
			devMessagePrinter.logDevMessage(exception);
		}
		
		//devMessagePrinter.logDevMessage("Ending test sale");
		System.out.println("\nSale has ended.\nTotal price incl. VAT is: $" + controller.endSale());
		
		double testPayment = 30;
		//devMessagePrinter.logDevMessage("Customer paid $" + testPayment +  ". Completeing sale");
		controller.completedSale(testPayment);
	}
	
	
}
