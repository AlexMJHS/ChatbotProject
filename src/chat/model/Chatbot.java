package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Alejandro Magallanes
 * @version 1.2 10/21/15 Completed the lengthChecker method. Fixed the Constructor and getter for userName
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMashList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.keyboardMashList = new ArrayList<String>();
		this.content = "memes";
	
		
		buildMemesList();
		buildPoliticalTopicsList();
		
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("aliens");
		this.memesList.add("Spoderman");
		this.memesList.add("rare pepe");
		this.memesList.add("what if I told you");
		this.memesList.add("bad luck brian");
		this.memesList.add("unhelpful high school teacher");
		this.memesList.add("me gusta");
		this.memesList.add("troll face");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("democrat");
		this.politicalTopicList.add("republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/8/1016");
		
	}
	
	private boolean KeyboardMashChecker(String currentInput)
	{
		boolean mashTyping = false;
		
		if(currentInput.equals("sdf")|| currentInput.equals("dfg")|| currentInput.equals("cvb")|| currentInput.equals(",./"))
		{
			mashTyping = true;
		}
		
		return mashTyping;
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitics = false;
		
		for(String currentPolitics : politicalTopicList)
		{
			if(currentPolitics.equalsIgnoreCase(currentInput))
			{
				hasPolitics = true;
			}
		}
		return hasPolitics;
	}
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String currentMeme : memesList)
		{
			if(currentMeme.equalsIgnoreCase(currentInput))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
		
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equals("quit"))
		{
			hasQuit = true;
		}
		return hasQuit;
	}
	
	public String processConversation(String currentInput)
	{
		String nextConversation = " Oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		if(keyboardmMashChecker(currentInput))
		{
			return "stop mashing the keyboard!";
		}
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentInput))
				{
					nextConversation = "That is a very popular meme this year. What else are you"
							+ " wanting to talk about?";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = "That's so cool";
				}
				break;
			case 2:
			{
				if(contentChecker(currentInput))
				{
					nextConversation = "Wow, interesting";
				}
				
			}
				break;
			case 3:
			{
				if(currentInput.length() > 20)
				{
					nextConversation = "So cool";
				}
				
			}
				break;
			case 4:
			{
				if(contentChecker(currentInput))
				{
					nextConversation = "That sounds pretty cool";
				}
				
			}
				break;
			default:
				nextConversation = "The universe has ended sad panda";
				break;
		}		
		
		return nextConversation;
	}
	
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}
