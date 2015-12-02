package chat.view;

<<<<<<< HEAD
import chat.controller.ChatController;
import javax.swing.*;
import java.awt.event.*;
=======
import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import chat.controller.ChatController;
>>>>>>> try_adding_an_icon

public class ChatPanel extends JPanel
{
	private ChatController baseController;
<<<<<<< HEAD
	private JButton firstButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
=======
	private SpringLayout baseLayout;
	private JButton firstButton;
	private JButton colorButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
>>>>>>> try_adding_an_icon
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
<<<<<<< HEAD
		firstButton = new JButton("Enter");
		firstTextField = new JTextField("Talk to me!");
		promptLabel = new JLabel("Chat with me!");
		firstTextArea = new JTextArea("Hello, I'm chatbot");
=======
		firstTextArea = new JTextArea(10,30);
		firstTextField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		firstButton = new JButton("asda");
>>>>>>> try_adding_an_icon
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
<<<<<<< HEAD
		this.add(firstButton);
		this.add(firstTextField);
		this.add(firstTextArea);
=======
		this.setBackground(Color.CYAN);
		this.add(firstButton);
		this.add(colorButton);
		this.add(firstTextArea);
		this.add(firstTextField);
		this.add(firstButton);
		this.add(promptLabel);
>>>>>>> try_adding_an_icon
		firstTextField.setToolTipText("Type here for the chatbot");
		firstTextArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
<<<<<<< HEAD
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 40, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, 184, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextArea, 416, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -63, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, -383, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -58, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -179, SpringLayout.EAST, this);
=======
		
>>>>>>> try_adding_an_icon
	}
	
	private void setupListeners()
	{
<<<<<<< HEAD
		
=======
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
>>>>>>> try_adding_an_icon
	}
	
	public JTextField getTextField()
	{
		return firstTextField;
	}
}
