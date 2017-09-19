/**
 * 
 */
package upmath;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Duisebay Yerkebulan 1603(21580)
 * 21580
 *
 */
public class Exercise05 {
	static final String DATA_PATH = "datafile.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner will read in the file.
		//In Eclipse, if you "right click" the word Scanner and choose "Open Declaration",
		//you can see the class methods available to you
		Scanner dataReader = null;
		try {
			// Try opening the file and set up a scanner to read it.  If the file is there,
			// the program will continue to the statement following this try block.
			dataReader = new Scanner(new File(DATA_PATH));
			//Print out a trace of the program as it is running
			System.out.println("Debug: Scanner is open ");
		} catch (FileNotFoundException e) {
			// If the file is not there, an exception will be thrown and the program flow
			// will directed here.  An error message is displayed and the program stops.
			System.out.println("The file "+DATA_PATH+" was not found!");
			System.out.println("The program terminates now.");
			System.exit(0);
		}
		//////////////////////////////////////
		// THIS is the computation of average with doubles
		//////////////////////////////////////
		//setup a number format
		DecimalFormat df = new DecimalFormat("#0.00");
		//read the data
		int cntr= 0;
		double [] data = new double[100];
		//System.out.println(dataReader.nextLine());
		
		while (dataReader.hasNext()) {
		   String tem =  dataReader.nextLine();
		   data[cntr] = Double.parseDouble(tem);
		   cntr++;
		}
		double average = 0;
		//compute average
		double sum = 0;
		for(int i=0; i < cntr;i++) {
			sum += data[i];
		}
		average = sum/cntr;
		

//STUDENT TODO
		
		System.out.println("Average: "+df.format(average));
		//////////////////////////////////////
		// THIS is the computation of average with unlimited precision numbers
		// using the same data
		//////////////////////////////////////
		UNumber [] udata = new UNumber[cntr];
		UNumber uaverage = null;
		
		//convert data to udata
		UNumber cntrU =  new UNumber(0);
		System.out.println("Usage of unamber");
		for(int i=0; i < cntr;i++) {
			udata[i] = new UNumber(data[i]);
			cntrU.add(new UNumber(1));
		}
		
		
		
//STUDENT TODO
		
		//compute average
		UNumber sumU = new UNumber();
		for(int i=0; i<cntr; i++) {
			sumU.add(udata[i]);
		}
		sumU.div(cntrU);
		System.out.println("Avarage: "+ sumU);

	}

}
