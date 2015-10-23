package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * 
 * @author Alejandro Magallanes
 *@version 1.11 10/21/15 fixed error
 */
public class ChatController 
{
	private Chatbot myBot;
	private ChatView myDisplay;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
	}
	
	public void start()
	{
		myDisplay.showResponse("Hello " + myBot.getUserName());
	}
}
