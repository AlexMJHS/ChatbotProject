package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot project.
 * @author Alejandro Magallanes
 *@version 1.3 11/5/15 Added Icons to popup windows!
 */

public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot";
		chatIcon = new ImageIcon(getClass().getResource("images/Chatbot.png"));
	}
	
	public void showResponse(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
	
	public String grabAnswer(String popupText)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, popupText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here").toString();
		return answer;
	}
}
