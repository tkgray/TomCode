// Thomas Gray
// Lesson 8
// Space Ship java
// java 111B

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class SpaceShip extends Applet {
	// creates a listener for mouse events
	public void init() {
		this.addMouseListener(new MouseL());
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}

	// Draws a dot where user last clicked mouse	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS,
					RADIUS * 2, RADIUS * 2);
	}

	// Sets the point at which to draw the next dot	
	public void setPoint(Point pnt) {
		 clickPoint = pnt;
	}

	// MouseL is an inner class, designated as a mouseListener,
	// which implements the MouseListener Interface	
	private class MouseL implements MouseListener {
		// code only the method we need	
		public void mouseClicked(MouseEvent e) {
			Point pnt = e.getPoint();
			setPoint(pnt);// inner classes have access to members of enclosing class
			repaint(); // requests JVM to call paint method
		}
		// list the empty methods from the MouseListener Interface
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}

	// instance variables belong to EventDemo applet
	private Point clickPoint = null;
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
	private final int RADIUS = 64;
}

