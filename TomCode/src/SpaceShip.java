/* Written by Thomas Gray
 * 
 */


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;


public class SpaceShip extends Applet {
	
	private Point clickPoint = null, mouseClick = null;
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600;
	private final int RADIUS = 64;
	public Random generator;
	public int randomX, randomY;
	public boolean laserDone;
	public int laserCount = 0, laserCountMod;
	public String lineColor;
	public Button butn1 = new Button("Click to Reset Label Counter");
	
	public void init()
	{
					
		addMouseMotionListener (new MouseMotionHandler());
		addMouseListener (new MouseHandler());
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		
		butn1.addActionListener(new Butn1Handler());
		add(butn1);
	}
	
	// Draws a SpaceShip that follows the mouse	
	public void paint(Graphics g) {
				
	    g.setColor(Color.green);
		if (clickPoint != null)
			g.fillOval(clickPoint.x - RADIUS, clickPoint.y - RADIUS,
					RADIUS * 4, RADIUS * 2);
		
	
	
	// Draws the laser			

		if ( laserDone != true){
						
				generator = new Random();           //gets numbers for random laser lines
			 	randomX = generator.nextInt(800);
			 	randomY = generator.nextInt(600);
				
			 	laserCountMod = laserCount % 4;     // gets the mod for four colors
			 	
			 	switch (laserCountMod)             // draws the colors
			 	{
			 	case 0:
			 		g.setColor(Color.yellow);
			 		break;
			 	case 1:
			 		g.setColor(Color.red);
			 		break;
			 	case 2:
			 		g.setColor(Color.white);
			 		break;
			 	case 3:
			 		g.setColor(Color.orange);
			 		break;
			  	}
				 	
			 	g.drawLine (mouseClick.x, mouseClick.y, randomX, randomY); // the actual laser line
			 			 			 	
			 	laserCount++;                        // count of clicks
			 	laserDone = true;                   // keeps the laser off when you move the spaceship
		 			
		}
		
		g.setColor(Color.white);
		g.drawString ("Count: " + laserCount, 5, 15);
		
		
	}
	

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
      		mouseClick = event.getPoint();
			repaint();
			laserDone = false;
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
   
   public class Butn1Handler implements ActionListener {
       public void actionPerformed(ActionEvent e) {
    	  laserCount = 0;
       }
   }

}

