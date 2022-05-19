package se.kth.iv1350.pos.view;
/**
 * A class that prints messages for developers.
 */
public class DeveloperMessagePrinter {
	/**
	 * prints a message with specified developer tags, only for devs.
	 * @param message	the message
	 */
	public void logDevMessage(Exception message)
	{
		System.out.println("\n### DEVELOPER EXCEPTION LOG: " + message + " ###");
	}
}
