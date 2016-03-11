package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import java.io.*;
import chat.controller.ChatController;

/**
 * 
 * @author Alejandro Magallanes
 * @version 0.4 Changed the sendTweet method to handle errors
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
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	/**
	 * Loads 2000 tweets from the supplied Twitter user to a List<Status> and a
	 * Llist<String>
	 * @param twitterHandle
	 * @throws TwitterException
	 */
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split("");
			for (String word : tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}
	
	/**
	 * Create the statistics about the tweets
	 * @param wordList The supplied list of words
	 * @return A String containing the name the user,
	 * their most common word in their tweets, and how often it is in their tweets.
	 */
//	public String topResults(ArrayList<String> wordList)
//	{
//		
//	}
}
