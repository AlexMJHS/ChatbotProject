package chat.view;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton firstButton;
	private JButton colorButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstTextArea = new JTextArea(10,30);
		firstTextField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		colorButton = new JButton("Change Colors");
		firstButton = new JButton("Submit");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(firstButton);
		this.add(colorButton);
		this.add(firstTextArea);
		this.add(firstTextField);
		this.add(promptLabel);
		firstTextField.setToolTipText("Type here for the chatbot");
		firstTextArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -236, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextArea, 6, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 69, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, -95, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextArea, -67, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 0, SpringLayout.NORTH, colorButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 63, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, colorButton, 18, SpringLayout.SOUTH, firstTextArea);
		baseLayout.putConstraint(SpringLayout.EAST, colorButton, 0, SpringLayout.EAST, firstTextArea);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 179, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, firstTextField);
		
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
		
		colorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
			}
		});
	}
	
	public JTextField getTextField()
	{
		return firstTextField;
	}
}
