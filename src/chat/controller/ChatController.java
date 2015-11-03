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
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.grabAnswer("What would you like to talk about today?");
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.contentChecker(conversation))
			{
				myDisplay.showResponse("wow, I had no idea you are interested in " + myBot.getContent());
			}
			else if(myBot.memeChecker(conversation))
			{
				myDisplay.showResponse("That meme is dank");
			}
			else if(myBot.politicalTopicChecker(conversation))
			{
				myDisplay.showResponse("You know politics!");
			}
			
			conversation = myDisplay.grabAnswer(conversation);
			
		}
	}
	
	private void shutDown()
	{
		
	}
}
