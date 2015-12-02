package chat.view;

<<<<<<< HEAD
import chat.controller.ChatController;
import chat.view.ChatPanel;
import javax.swing.JFrame;
=======
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import chat.controller.ChatController;
>>>>>>> try_adding_an_icon

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
	
<<<<<<< HEAD
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
=======
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setTitle("Chatbot");
		this.setResizable(false);
		this.setVisible(true);
>>>>>>> try_adding_an_icon
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> try_adding_an_icon
}
