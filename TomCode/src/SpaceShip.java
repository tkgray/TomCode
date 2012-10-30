// Thomas Gray
// Lesson 8
// Space Ship java
// java 111B

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class SpaceShip extends Applet {
	
	// instance variables belong to SpaceShip applet
	private Point clickPoint = null;
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
	private final int RADIUS = 64;
	
	// creates a listener for mouse events
	public void init() {
		this.addMouseMotionListener(new MouseL());
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		
	}

	// Draws a dot that follows the mouse	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS,
					RADIUS * 4, RADIUS * 2);
	
	}

	// Sets the point at which to draw the next dot	
	public void setPoint(Point pnt) {
		 clickPoint = pnt;
	}

	// MouseL is an inner class, designated as a mouseListener,
	// which implements the MouseListener Interface	
	private class MouseL implements MouseMotionListener {
		// code only the method we need	

		
		public void mouseMoved(MouseEvent e) {
			Point pnt = e.getPoint();
			setPoint(pnt);// inner classes have access to members of enclosing class
			repaint(); // requests JVM to call paint method	
		}
		// list the empty methods from the MouseMotionListener Interface
		public void mouseDragged(MouseEvent e) {}
	}
	
}

