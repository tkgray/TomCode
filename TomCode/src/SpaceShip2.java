/* Written by Thomas Gray
 * 
 */


import java.awt.*;
import java.applet.*;
import java.awt.event.*;




public class SpaceShip2 extends Applet {
	
	private Point clickPoint = null, point1 = null;
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
	private final int RADIUS = 64;
	
	public void init()
	{
		addMouseMotionListener (new MouseMotionHandler());
		addMouseListener (new MouseHandler());
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	// Draws a dot that follows the mouse	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS,
					RADIUS * 4, RADIUS * 2);
		
		if (point1 != null)
			g.fillOval(point1.x - RADIUS, point1.y - RADIUS,
					RADIUS * 8, RADIUS * 4);
		
	}

/*
	public void setPoint(Point pnt) {
		 clickPoint = pnt;
	}
	
	public void setPoint1(Point pnt) {
		 point1 = pnt;
	}
*/	
	  //--------------------------------------------------------
    // MouseHandler is an inner class listening for mouse events
    //--------------------------------------------------------
   private class MouseHandler implements MouseListener
   {
	//--------------------------------------------------
   	//  Captures the position at which the mouse is pushed.
   	//---------------------------------------------------
	public void mousePressed (MouseEvent event)
   	{
      		point1 = event.getPoint();
      		repaint();
     }
   	//-----------------------------------------------------
	//  Provide empty definitions for unused event methods.
   	//-----------------------------------------------------
   	public void mouseClicked (MouseEvent event) {}
   	public void mouseReleased (MouseEvent event) {}
   	public void mouseEntered (MouseEvent event) {}
   	public void mouseExited (MouseEvent event) {}
    }

	
	
	//--------------------------------------------------------
    // MouseMotionHandler is an inner class listening for mouse 
    // motion events
    //--------------------------------------------------------
   private class MouseMotionHandler implements MouseMotionListener
   {
	//------------------------------------------------------
   	// Gets the current position of the mouse as it is dragged
   	// and draws the line to create the rubberband effect
   	//-------------------------------------------------------
	public void mouseMoved (MouseEvent event)
   	{
      		clickPoint = event.getPoint();
      		repaint();
	}
   	//----------------------------------------------------
   	//  Provide empty definitions for unused event methods
   	//----------------------------------------------------
	public void mouseDragged (MouseEvent event) {}
    }

}
