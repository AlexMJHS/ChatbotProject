package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import java.io.*;
import chat.controller.ChatController;

/**
 * 
 * @author Alejandro Magallanes
 * @version 0.3 Added a method that can send a tweet
 * Will interact with Twitter
 *
 */
public class CTECTwitter
{
	//Declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	
	/**
	 * Send the supplied message as a tweet.
	 * @param tweet the supplied String
	 */
	public void sendTweet(String tweet)
	{
		try
		{
		chatbotTwitter.updateStatus("");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	/**
	 * Create the statistics about the tweets
	 * @param wordList The supplied list of words
	 * @return A String containing the name the user,
	 * their most common word in their tweets, and how often it is in their tweets.
	 */
	public String topResults(ArrayList<String> wordList)
	{
		
	}
}
