package se.kth.iv1350.pos.integration;
/**
 * This class is the exception for connection errors with the external inventory system.
 */
public class InventoryServerConnectionIssueException extends RuntimeException {
	/**
	 * 
	 * @param exceptionMessage a message to specify that there's an issue with connection
	 */
	public InventoryServerConnectionIssueException(String exceptionMessage)
	{
        super(exceptionMessage);
    }
}
