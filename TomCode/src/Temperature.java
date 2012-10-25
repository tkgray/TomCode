// Written by: Thomas Gray
// Due 101512
// Email: tom.k.gray@gmail.com
// Assignment  Lesson 6 Programming Assignment
// Work Load: 20 hours or more? I got stuck for two days
// putting double quotes where I needed single quotes
// Thoughts: I wrote an extra credit user input method

import java.util.Scanner;


public class Temperature {
	
	double degrees, d, convertedC, convertedF;
	char type;
	Scanner scan = new Scanner(System.in);
	
	//----------------------------------------------------
	// Constructors for Temperature class
	//----------------------------------------------------
	
	public Temperature ( )
	{
		type = 'c';
		d = 0.0;
	}
	
	public Temperature ( double degrees, char T )
	{
		d = degrees;
		type = T;
	}
	
	public Temperature ( double degrees )
	{
		d = degrees;
		type = 'c';
	}
	
	public Temperature ( char T )
	{
		type = T;
		d = 0.0;
	}
			
	//-------------------------------------------------------
	// displays degrees and type
	//-------------------------------------------------------
	
	public void writeOutput ()
	{
		System.out.println("The degrees equal: " + d);
		System.out.println("The type is " +  type);

	}
	//------------------------------------------------------
	// mutator to set the degrees
	//------------------------------------------------------
	
	public void readInput()
	{
		System.out.println("Enter in degrees");
		d = scan.nextDouble();
	}
	
    //--------------------------------------------------------
	// mutator to set the type to Celcius
	//--------------------------------------------------------
	
	public void writeC()
	{
		double calculatedDegrees;
		if ( type == 'c' || type == 'C' )
		{
			System.out.println("The temperature is " + d + " Celcius");
		}
		else if ( type == 'F' || type == 'f' )
		{
			calculatedDegrees = ( d - 32) * 0.555555556;
			System.out.println("The temperature is " + Math.round(calculatedDegrees*10)/10.0 
					+ " Celcius");
		}
		else
		{
			System.out.println( "The temperature is " + d );
		}
	}
	
	//--------------------------------------------------------
	// mutator to set the type to Fahrenheit
	//--------------------------------------------------------
		
	public void writeF()
	{
		double calculatedDegrees;
		if ( type == 'f' || type == 'F' )
		{
			System.out.println("The temperature is " + d + " Fahrenheit");
		}
		else if ( type == 'c' || type == 'C' )
		{
			calculatedDegrees = ((d * 9) / 5) + 32;
			System.out.println("The temperature is " + Math.round(calculatedDegrees*10)/10.0 
					+ " Fahrenheit");
		}
		else
		{
			System.out.println( "The temperature is " + d );
		}
	}
	
	//-------------------------------------------------------
	// mutator to set return the degree value in Celsius
	//---------------------------------------------------------
	
	public double getC()
	{
		double rCelcius, calculatedDegrees;
		if ( type == 'c' || type == 'C' )
		{
			rCelcius = Math.round(d*10)/10.0;
			return rCelcius;
		}
		else if ( type == 'F' || type == 'f' )
		{
			calculatedDegrees = ( d - 32) * 0.555555556;
			rCelcius = Math.round(calculatedDegrees*10)/10.0;
			return rCelcius;
		}
		else
		{
			rCelcius = Math.round(d*10)/10.0;
			return rCelcius;	
		}
		
	}
	
	//-------------------------------------------------------
	// mutator to set returen the degree value in Celsius
	//---------------------------------------------------------
		
		public double getF()
		{
			double rFahrenheit, calculatedDegrees;
			if ( type == 'f' || type == 'F' )
			{
				rFahrenheit = Math.round(d*10)/10.0;
				return rFahrenheit;
			}
			else if ( type == 'C' || type == 'c' )
			{
				calculatedDegrees = ((d * 9) / 5) + 32;
				rFahrenheit = Math.round(calculatedDegrees*10)/10.0;
				return rFahrenheit;
			}
			else
			{
				rFahrenheit = Math.round(d*10)/10.0;
				return rFahrenheit;	
			}
			
		}
		
	//--------------------------------------------------------------
	// set three overloaded methods to set the degrees and type
	//--------------------------------------------------------------
		
		public void set(double degrees)
		{
			d = degrees;
		}
		
		public void set( char T)
		{
			type = T;
		}
		
		public void set( double degrees, char T)
		{
			d = degrees;
			type = T;
		}
	
	//-----------------------------------------------------------------
	// equals() Returns true if temperature is equal to temperature2
	//-----------------------------------------------------------------
		
		public boolean equals(Temperature t2)
		{
			double temp1;
			boolean result;
			if ( type == 'f' || type == 'F' )
				temp1 = 'T';
			else
				temp1 = getF();
			
			if ( temp1 == t2.getF() )
				result = true;
			else
				result = false;
			
			return result;
		}
		
	//-------------------------------------------------------------------
	// toString() outputs the temperature
	// ------------------------------------------------------------------
		
		public String toString()
		{
			double output = getF();
			return "temperature " + output + " F";
		}
		
	//------------------------------------------------------------------
	// readInput() Asks for user numbers
	//-------------------------------------------------------------------
		
		public void readUserInput ()
		{
			
	
			
			System.out.println("Celcius or Fahrenheit? C or F: ");
			String userInput = scan.nextLine();
			type = userInput.charAt(0);
			
			System.out.println("Enter in a temperature: ");
			d = scan.nextDouble();
				
		}
}