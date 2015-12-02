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
		firstButton = new JButton("asda");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.CYAN);
		this.add(firstButton);
		this.add(colorButton);
		this.add(firstTextArea);
		this.add(firstTextField);
		this.add(firstButton);
		this.add(promptLabel);
		firstTextField.setToolTipText("Type here for the chatbot");
		firstTextArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		
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
	}
	
	public JTextField getTextField()
	{
		return firstTextField;
	}
}
