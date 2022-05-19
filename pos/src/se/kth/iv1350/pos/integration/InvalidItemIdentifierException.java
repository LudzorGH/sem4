package se.kth.iv1350.pos.integration;
/**
 * This class is the exception for invalid identifiers.
 */
public class InvalidItemIdentifierException extends Exception{
	String invalidIdentifier;
	
	/**
	 * This exception prints the exception error together with the invalid identifier
	 * @param identifier the item identifier that caused the exception
	 */
	public InvalidItemIdentifierException(String identifier)
	{
        super("\nInvalidItemIdentifierException: "
        		+ "Item identifier " + identifier + " was scanned but does not exist in inventory system.");
        invalidIdentifier = identifier;
    }
	/**
	 * This method just returns the invalid identifier
	 * @return the identifier that caused the exception
	 */
	public String getInvalidItemIdentifier()
	{
		return invalidIdentifier;
	}
}
