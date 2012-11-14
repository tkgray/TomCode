/* Name: Thomas Gray
* Date: 11/14/12
* Assignment Number: Lesson 9
* Email: tom.k.gray@gmail.com
* Work Load: 20 hours
* Thoughts:  I give up on the selection sort. I'm off by one somewhere?
*/


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;   

public class TwoSorts extends Applet {

	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 600; // to make the applet size
	private final int colNum = 15; // how many columns
	int[] insertion = new int[colNum]; //insertion array for column heights
	int[] selection = new int[colNum]; // insertion array for column heights
	public Random generator;  // random numbers class
	public int randomNum; // random number
	public Button butn1 = new Button("Sort Arrays"); // buttons
	public int selectionCount = 0; // how many times press the sort button
	boolean selectionFlag, insertionFlag;  // to stop looping when done

	//**********************************************************************
	//* init starts the whole shebang
	//**********************************************************************
		
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

	//*************************************************************************
	// Draws the columns
	//************************************************************************
	public void paint(Graphics g) {
		//g.setColor(Color.white);                         // debugging code
		//g.drawString ("Count: " + selectionCount, 5, 595);
		
		g.drawString("Selection Sort", 5, 220);
		g.drawString("Insertion Sort", 5, 420);
	
		int xs = 50, ys = 100, width = 40, heights = 0;  // for the loops
		int xi = 50, yi = 300, heighti = 0;
		
		if ( insertionFlag == false && selectionFlag == false)
		{
			for (int count = 0; count < colNum + 1; count++ ) {
				g.setColor(Color.green);
				heights = selection[count];
				heighti = insertion[count];
				g.fillRect(xs, ys, width, heights);
				g.fillRect(xi, yi, width, heighti);
				xs = xs + width + 2;
				xi = xi + width + 2;
			}
		}
		else
		{
			g.setColor(Color.white);
			g.drawString ("Sort is Done!", 5, 495);
			for (int count = 0; count < colNum + 1; count++ ) {
				g.setColor(Color.gray);
				heights = selection[count];
				heighti = insertion[count];
				g.fillRect(xs, ys, width, heights);
				g.fillRect(xi, yi, width, heighti);
				xs = xs + width + 2;
				xi = xi + width + 2;
				}
			}
	}
	//*****************************************************************************
	//* Method to sort the array by Selection method
	//******************************************************************************
	
	public void reorderSelection() {
		int min = 0;
		int temp;
		
		for (int scan = selectionCount; scan < selection.length; scan++) {
			if (selection[scan] < selection[min]) 
				min = scan;
			
			temp = selection[min];
			selection[min] = selection[selectionCount];
			selection[selectionCount] = temp;
	    }
	}
	//*****************************************************************************
	//* Method to sort the arrary by Insertion method
	//******************************************************************************
	
	public void reorderInsertion() {
		int key = insertion[selectionCount];
		int position = selectionCount;
		while (position > 0 && key < (insertion[position-1]))
        {
           insertion[position] = insertion[position-1];
           position--;
        }
		insertion[position] = key;
	}

	//-----------------------------------------------------
	//  Button 1 Listener and instructions
	//-----------------------------------------------------
	public class Butn1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reorderSelection();
			reorderInsertion();
			repaint();
			selectionCount++;
			if (selectionCount > 14)
					selectionFlag = true;
			if (selectionCount > 15)
				insertionFlag = true;
			
			}
	    }
}
