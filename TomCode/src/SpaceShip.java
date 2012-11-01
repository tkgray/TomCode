/* Name:Thomas Gray
 * Date: 11/2/12
 * Assignment Number: Lesson 8
 * email: tgray@ccsf.edu
 * Work Load: 30 hours
 * Thoughts: The java applet confused me for a while. I was thinking 
 * that I had to extend a class after reading the assigned chapter and
 * your instructions about uploading 3 class files.       
 */


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;   // for random numbers
import java.applet.AudioClip;  // for sound


public class SpaceShip extends Applet {
	
	private Point clickPoint = null, mouseClick = null; // for the mouse actions
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600; // to make the applett size
	private final int RADIUS = 64;  // makes the spaceship size
	public Random generator;  // random numbers class
	public int randomX, randomY; // random point
	public boolean laserDone, sound = false; // the flags 
	public int laserCount = 0, laserCountMod; // how many clicks
	public String lineColor; // changes the color of laser
	public Button butn1 = new Button("Reset Counter"); // buttons
	public Button butn2 = new Button("Sound On");
	private AudioClip sound1; // for the sound file
	
	//--------------------------------------------------------
	// initiates the applet
	//--------------------------------------------------------
	public void init()
	{
		addMouseMotionListener (new MouseMotionHandler());
		addMouseListener (new MouseHandler());
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		
		butn1.addActionListener(new Butn1Handler());
		butn1.setBackground(Color.white);
		add(butn1);
		
		butn2.addActionListener(new Butn2Handler());
		butn2.setBackground(Color.white);
		add(butn2);
		
		sound1 = getAudioClip(getDocumentBase(), "bonk.au");   // loads audio file for laser
	}
	
	//-----------------------------------------------------
	// does the paint of the Spaceship and the laser
	//-----------------------------------------------------
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
				 	
		g.drawLine (mouseClick.x, mouseClick.y, (randomX + 50), (randomY + 50)); // the actual laser line
			 			 			 	
		laserCount++;            // count of clicks
		laserDone = true;       // keeps the laser off when you move the spaceship
		 			
		}
		
		g.setColor(Color.white);
		g.drawString ("Count: " + laserCount, 5, 595);
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
      		if (sound != false)
      			sound1.play();
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
   //-----------------------------------------------------
   //  Button 1 Listener and instructions
   //-----------------------------------------------------
   public class Butn1Handler implements ActionListener {
       public void actionPerformed(ActionEvent e) {
    	  laserCount = 0;
       }
    }
   //-----------------------------------------------------
   //   Button 2 Listener and instructions
   //------------------------------------------------------
   public class Butn2Handler implements ActionListener {
       public void actionPerformed(ActionEvent e) {
    	  if ( sound == false)
    		  sound = true;
    	  else
    		  sound = false;
       }
    }
}

