package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * 
 * @author Alejandro Magallanes
 *@version 1.11 10/21/15 fixed error
 */
public class ChatController 
{
	private Chatbot myBot;
	private ChatView myDisplay;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		myDisplay.showResponse("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
//		String conversation = myDisplay.grabAnswer("What would you like to talk about today?");
//		while(myBot.lengthChecker(conversation))
//		{
//			conversation = myBot.processConversation(conversation);
//			conversation = myDisplay.grabAnswer(myBot.processConversation(conversation));
			
//		}
	}
	
	public String userToChatbot(String conversation)
	{
		String response= "";
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		response = myBot.processConversation(conversation);
		
		return response;
	}
	
	private void shutDown()
	{
		myDisplay.showResponse("Goodbye " + myBot.getUserName() + " it has been a pleasure talking with you.");
		System.exit(0);
	}
	
	public Chatbot getChatbot()
	{
		return myBot;
	}
	
	public ChatView getChatView()
	{
		return myDisplay;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}	
