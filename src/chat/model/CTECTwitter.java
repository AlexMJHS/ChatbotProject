package chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
	private ArrayList<String> tweetTexts;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		tweetTexts = new ArrayList<String>();
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
		statusList.clear();
		tweetTexts.clear();
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
	 * Removes defined punctuation marks and symbols from the supplied string.
	 * @param currentString
	 * @return
	 */
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!;:\"(){}^[]<>-"; 
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	/**
	 * Removes empty text entries from the tweetTexts list.
	 */
	private void removeEmptyText()
	{
		for (int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if(tweetTexts.get(spot).equals(""))
			{
				tweetTexts.remove(spot);
				spot--; //When you remove you have to have -- or you will skip over
			}
		}
	}
	
	/**
	 * Removes all words found in commonWords.txt from the parameter wordList.
	 * @param wordList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ArrayList removeCommonEnglishWords(ArrayList<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit the inner loop
				}
			}
		}
		
		//Comment this if you want to keep Twitter usernames in your word list.
		removeTwitterUsernamesFromList(wordList);
		
		return wordList;
		
	}
	
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for (int index = 0; index < tweetTexts.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < tweetTexts.size(); spot++)
			{
				if(tweetTexts.get(index).equals(tweetTexts.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweets was " + tweetTexts.get(topWordLocation) + " and it was used " + topCount + " times!";
		return tweetResults;
	}
	
	/**
	 * Removes 
	 * @param wordList
	 */
	private void removeTwitterUsernamesFromList(List<String> wordList)
	{
		for(int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if (wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
			{
				wordList.remove(wordCount);
				wordCount--;
			}
		}
	}
	
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
				
			}
			wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
			
			return boringWords;
			}
	

public String sampleInvestigation()
{
	String results = "";
	
	Query query = new Query("5k run");
	query.setCount(100);
	query.setGeoCode(new GeoLocation(40.58721, -111.869178), 5, Query.MILES);
	query.setSince("2016-1-1");
	try
	{
		QueryResult result = chatbotTwitter.search(query);
		results += "Count : " + result.getTweets().size();
		for (Status tweet : result.getTweets())
		{
			results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
		}
	}
	catch (TwitterException error)
	{
		error.printStackTrace();
	}
	
	return results;
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
