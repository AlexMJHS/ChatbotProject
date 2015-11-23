package chat.view;

import chat.controller.ChatController;
import chat.view.ChatPanel;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	/**
	 * Required helper method to prepare the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);  //Must be first line of setupFrame! Installs he panel in the frame.
		this.setSize(400,400);           //Find a good size for the app.
		this.setTitle("Simple App");
		this.setResizable(false);        //Advisable not required.
		this.setVisible(true);           //Must be last line of setupFrame!
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
	
	
}
