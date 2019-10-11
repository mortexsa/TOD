package screens;



import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {

	public void displayOutput(AsciiPanel terminal) {
		terminal.write("You are now playing", 1, 1);

	}

	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){

		}
		
		return this;
	}
}

