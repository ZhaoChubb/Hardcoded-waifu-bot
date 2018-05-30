import javax.swing.*;

public class Main extends JPanel {

	static JFrame frame = new JFrame();

	static BotScreen botScreen = new BotScreen();

	public static void main(String args[]) {

		botScreen.Screen(); // Get name screen components
		
		frame.setTitle("Waifu Bottu");
		frame.setSize(600, 700); // Set size of frame
		frame.setLocationRelativeTo(null); // Center frame
		frame.setVisible(true); // Show frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when JFrame is close
		frame.setResizable(false); // Don't allow user to resize frame
		frame.add(botScreen.getGUI()); // Show nameScreen
		
	}
}