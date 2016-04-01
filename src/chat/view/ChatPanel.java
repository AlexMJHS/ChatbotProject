package chat.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import chat.controller.ChatController;
import chat.controller.IOController;

/**
 * ChatPanel for the Chatbot project.
 * @author Alejandro Magallanes
 * @version 2.1 Feb. 23, 2016
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private SpringLayout baseLayout_1;
	private JButton firstButton;
	private JButton colorButton;
	private JTextField firstTextField;
	private JTextField firstTextField_1;
	private JTextArea firstTextArea;
	private JLabel promptLabel;
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton tweetButton_1;
	private JButton analyzeTwitterButton;
	private JButton analyzeTwitterButton_1;
	private JButton saveButton;
	private JButton loadButton;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Enter");
		tweetButton = new JButton("Tweet");
		saveButton = new JButton ("Save");
		loadButton = new JButton("Load");
		analyzeTwitterButton = new JButton("Analyze");
		colorButton = new JButton("Change Color");
		firstTextField = new JTextField(25);
		promptLabel = new JLabel("Chat with me!");
		firstTextArea = new JTextArea(10,25);
		
		this.baseController = baseController;
		baseLayout_1 = new SpringLayout();
		baseLayout_1.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, analyzeTwitterButton, 6, SpringLayout.EAST, colorButton);
		baseLayout_1.putConstraint(SpringLayout.NORTH, colorButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, colorButton, 6, SpringLayout.EAST, saveButton);
		baseLayout_1.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, tweetButton);
		baseLayout_1.putConstraint(SpringLayout.NORTH, tweetButton, 8, SpringLayout.SOUTH, loadButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, loadButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, promptLabel, 177, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, promptLabel, -10, SpringLayout.SOUTH, this);
		firstTextArea = new JTextArea(10,30);
		firstTextField_1 = new JTextField(30);
		firstButton = new JButton("Submit");
		tweetButton_1 = new JButton("Send Tweet!");
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		textPane = new JScrollPane(firstTextArea);
		firstTextArea.setLineWrap(true);
		firstTextArea.setWrapStyleWord(true);
		firstTextArea.setEnabled(false);
		firstTextArea.setEditable(false);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout_1);
		this.add(loadButton);
		this.add(tweetButton);
		this.add(textPane);
		this.add(analyzeTwitterButton);
		this.add(saveButton);
		this.add(colorButton);
		this.add(promptLabel);
		//DO NOT HAVE the line this.add(chatArea);
		this.add(firstTextField_1);
//		this.setLayout(baseLayout);
//		this.setBackground(Color.GRAY);
//		this.add(firstButton);
//		this.add(colorButton);
//		this.add(firstTextArea);
//		this.add(firstTextField);
//		this.add(promptLabel);
		firstTextField.setToolTipText("Type here for the chatbot");
     	firstTextArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		baseLayout_1.putConstraint(SpringLayout.NORTH, firstTextArea, 6, SpringLayout.SOUTH, firstTextField_1);
		baseLayout_1.putConstraint(SpringLayout.WEST, firstTextArea, 69, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, firstTextArea, -95, SpringLayout.SOUTH, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, firstTextArea, -67, SpringLayout.EAST, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, firstButton, 0, SpringLayout.NORTH, colorButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, firstButton, 63, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, analyzeTwitterButton_1, 0, SpringLayout.NORTH, tweetButton_1);
		baseLayout_1.putConstraint(SpringLayout.WEST, analyzeTwitterButton_1, 6, SpringLayout.EAST, tweetButton_1);
		baseLayout_1.putConstraint(SpringLayout.NORTH, tweetButton_1, 8, SpringLayout.SOUTH, loadButton);
		baseLayout_1.putConstraint(SpringLayout.WEST, tweetButton_1, 0, SpringLayout.WEST, loadButton);
		baseLayout_1.putConstraint(SpringLayout.NORTH, firstTextField_1, 14, SpringLayout.SOUTH, textPane);
		baseLayout_1.putConstraint(SpringLayout.NORTH, loadButton, 15, SpringLayout.SOUTH, textPane);
		baseLayout_1.putConstraint(SpringLayout.NORTH, textPane, 25, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, textPane, 20, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, textPane, 175, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, firstTextField_1, 0, SpringLayout.EAST, loadButton);
		baseLayout_1.putConstraint(SpringLayout.EAST, firstTextField_1, -35, SpringLayout.EAST, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, loadButton, 26, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, loadButton, -351, SpringLayout.EAST, this);
	}
	
	private void changeColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
		
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = firstTextField.getText();  //Grab user typed answer
				firstTextArea.append("/nUser: " + userText); //display typed answer
				firstTextField.setText("");
				String response = baseController.userToChatbot(userText); //send the text to chatbot, chatbot will process
				firstTextArea.append("/nChatbot: " + response); //display the response
			}
		});
		
		tweetButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});
		
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = firstTextField.getText();
				String results = baseController.analyze(user);
				firstTextArea.setText(results);
			}
		});
		
		colorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText =IOController.readTextFromFile(promptLabel.getText());
				firstTextArea.setText(loadedText);
			}
		});
	
	
	saveButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			String file = IOController.saveFile(firstTextArea.getText());
			promptLabel.setText(file);
		}
	});
}
	
	public JTextField getTextField()
	{
		return firstTextField_1;
	}
	
}
