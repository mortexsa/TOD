package asciiPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * This is a simple and low level way to create AsciiPanel animations.
 * 
 * @author Trystan Spangler
 */
public abstract class Animation {

	private final Timer timer;

	public Animation(final AsciiPanel asciiPanel, int framesPerSecond) {
		timer = new Timer(1000 / framesPerSecond, new ActionListener() {
			int frame = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean done = true;
				try {
					asciiPanel.pushState();
					done = repaint(frame++);
					asciiPanel.repaint();
				} finally {
					asciiPanel.popState();
				}

				if (done)
					stop();
			}

		});
		synchronized (timer) {
			timer.start();
			try {
				timer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void stop() {
		timer.stop();
	}

	/**
	 * Repaint a single frame as part of an animation.
	 * 
	 * @param frameNumber the current frame number; the first frame will be 0
	 * @return weather you are done or not: true to stop the animation, false to
	 *         continue.
	 */
	public abstract boolean repaint(int frameNumber);
}
