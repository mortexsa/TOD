package screens;
import java.awt.event.KeyEvent;
import screens.PlayScreen;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen
{

	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("Welcome To the Rodge Like Game", 11);
		terminal.writeCenter("-- press [enter] to start --", 22);
		
	}

	public Screen respondToUserInput(KeyEvent key) {
		return (Screen) (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
	}
	
}
