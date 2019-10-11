package rodgelike.rodgelike;

import javax.swing.*;
import java.awt.event.*;

import asciiPanel.AsciiPanel;

import screens.Screen;
import screens.StartScreen;


public class Jeu extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1060623638149583738L;
	
	private AsciiPanel terminal;
	private Screen screen;

	
	public Jeu(){
		super();
		
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();


		addKeyListener(this);
		
		repaint();
		
	}
	@Override
	public void repaint(){
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	public void keyReleased(KeyEvent e) { }

	public void keyTyped(KeyEvent e) { }
	
	public static void main(String[] args) {
		Jeu app = new Jeu();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}


}
