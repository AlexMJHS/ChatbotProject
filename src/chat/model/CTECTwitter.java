package chat.model;

import java.util.ArrayList;
import twitter4j.*;

/**
 * 
 * @author Alejandro Magallanes
 * @version 0.2 Ref to Twitter4j
 * Will interact with Twitter
 *
 */

public class CTECTwitter
{
	//Declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet()
	{
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
}
