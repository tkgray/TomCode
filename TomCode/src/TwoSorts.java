/* Name: Thomas Gray
* Date: 11/14/12
* Assignment Number: Lesson 9
* Email: tom.k.gray@gmail.com
* Work Load:
* Thoughts:
*/


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;   
//import Butn1Handler;
//import SpaceShip.MouseHandler;
//import SpaceShip.MouseMotionHandler;




public class TwoSorts extends Applet {
	
	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600; // to make the applet size
	private final int colNum = 15;
	int[] insertion = new int[colNum];
	int[] selection = new int[colNum];
	public Random generator;  // random numbers class
	public int randomNum;
	public Button butn1 = new Button("Sort"); // buttons
	public int countLoops = 0;

	public void init()
		{
		
		setBackground (Color.black);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		generator = new Random();
				
		for (int column = 0; column < colNum; column++)  // Creates the two arrays
			{
		 		randomNum = generator.nextInt(100) + 5;
				insertion[column] = randomNum;
				selection[column] = randomNum;
			}
	
		butn1.addActionListener(new Butn1Handler());
		butn1.setBackground(Color.blue);
		add(butn1);
	
	
		}
	
	
	public void paint(Graphics g) {
	
		int xi = 50, yi = 100, width = 40, heighti;
//		int xs = 50, ys = 400, heights;
		int temp = 0, min = 100;
		
		for (int count = 1; count < colNum + 1; count++ )
		{
			heighti = selection[count -1];
			g.setColor(Color.green);
			g.fillRect(xi, yi, width, heighti);
			xi = xi + width + 2;
			
			for (int scan = count+1; scan < colNum; scan++)
				if (selection[count] < min )
	               min = count;

	         // Swap the values
	        temp = selection[min];
	        selection[min] = selection[count];
	        selection[count] = temp;
	         }
		}
		
/*		for (int count = 1; count < colNum + 1; count++ )
		{
			heights = insertion[count -1];
			g.setColor(Color.green);
			g.fillRect(xs, ys, width, heights);
			xs = xs + width + 2;
		}
		*/
	
	
	
	
	
	//-----------------------------------------------------
	//  Button 1 Listener and instructions
	//-----------------------------------------------------
	public class Butn1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	    }
				   
}
	