package chat.controller;

import chat.view.ChatView;
import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;

/**
 * 
 * @author Alejandro Magallanes
 *@version 1.11 10/21/15 fixed error
 */
public class ChatController 
{
	private CTECTwitter chatTwitter;
	private Chatbot myBot;
	private ChatView myDisplay;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		chatTwitter = new CTECTwitter(this);
		
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
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
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
	
	public String analyze(String userName)
	{
		String userAnalysis = "The twitter user " + userName + " has ...";
		
		return userAnalysis;
	}
	
	public void handleErrors(String errorMessage)
	{
		display.DisplayText(errorMessage);
	}
}	
