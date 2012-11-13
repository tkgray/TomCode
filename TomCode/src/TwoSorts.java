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

public class TwoSorts extends Applet {

	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600; // to make the applet size
	private final int colNum = 15;
	int[] insertion = new int[colNum];
	int[] selection = new int[colNum];
	int[] selectionForPaint = new int[4];
	public Random generator;  // random numbers class
	public int randomNum;
	public Button butn1 = new Button("Sort Arrays"); // buttons
	public int countLoops = 0;
	public int selectionCount = 0;
	int temp = 0;
	

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
		g.setColor(Color.white);
		g.drawString ("Count: " + selectionCount, 5, 595);
	
		int xs = 50, ys = 100, width = 40, heights = 0;
		
		for (int count = 0; count < colNum + 1; count++ ) {
		g.setColor(Color.green);
		heights = selection[count];
		g.fillRect(xs, ys, width, heights);
		xs = xs + width + 2;
		}
	}

	public void reorderSelection() {
		int min = selectionCount;
		for (int scan = selectionCount + 1; scan < selection.length; scan++) {
			if (selection[scan] < selection[min]) 
				min = scan;
			
			temp = selection[min];
			selection[min] = selection[selectionCount];
			selection[selectionCount] = temp;
	    
	    }
		selectionCount++;
		
	}


	//-----------------------------------------------------
	//  Button 1 Listener and instructions
	//-----------------------------------------------------
	public class Butn1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reorderSelection();	
			repaint();
			
			}
	    }

}
