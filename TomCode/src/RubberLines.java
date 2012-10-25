//*************************************************************
//  RubberLines.java       Author: Lewis and Loftus
//			   Upate: Constance Conner
//  Demonstrates mouse events and listeners using inner classes.
//*************************************************************

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class RubberLines extends Applet 
{
   private final int APPLET_WIDTH = 200;
   private final int APPLET_HEIGHT = 200;

   private Point point1 = null;
   private Point point2 = null;

   //--------------------------------------------------------
   //  Applet registers listeners for all mouse related events.
   //--------------------------------------------------------
   public void init()
   {
      addMouseListener (new MouseHandler());
      addMouseMotionListener (new MouseMotionHandler());

      setBackground (Color.black);
      setSize (APPLET_WIDTH, APPLET_HEIGHT);
   }

   //--------------------------------------------------------
   //  Draws the current line from the intial mouse down point
   //   to the current position of the mouse.
   //--------------------------------------------------------
   public void paint (Graphics page)
   {
      page.setColor (Color.green);
      if (point1 != null && point2 != null)
         page.drawLine (point1.x, point1.y, point2.x, point2.y);
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
      		point1 = event.getPoint();
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
	public void mouseDragged (MouseEvent event)
   	{
      		point2 = event.getPoint();
      		repaint();
	}
   	//----------------------------------------------------
   	//  Provide empty definitions for unused event methods
   	//----------------------------------------------------
	public void mouseMoved (MouseEvent event) {}
    }
 } //end RubberLines class