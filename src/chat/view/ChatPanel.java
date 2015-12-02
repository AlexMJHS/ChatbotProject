package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Enter");
		firstTextField = new JTextField("Talk to me!");
		promptLabel = new JLabel("Chat with me!");
		firstTextArea = new JTextArea("Hello, I'm chatbot");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(firstTextArea);
		firstTextField.setToolTipText("Type here for the chatbot");
		firstTextArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, 184, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextArea, 416, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -63, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, -383, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -58, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -179, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		
	}
	
	public JTextField getTextField()
	{
		return firstTextField;
	}
}
