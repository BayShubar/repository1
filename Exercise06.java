/**
 * 
 */
package exercise06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Duisebay Yerkebulan 1603--csse(21580)
 *
 */
public class Exercise06 {
	static final String DATA_PATH = "datafile.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner dataReader = null;
		try {
			// Try opening the file and set up a scanner to read it.  If the file is there,
			// the program will continue to the statement following this try block.
			dataReader = new Scanner(new File(DATA_PATH));
		} catch (FileNotFoundException e) {
			// If the file is not there, an exception will be thrown and the program flow
			// will directed here.  An error message is displayed and the program stops.
			System.out.println("The file "+DATA_PATH+" was not found!");
			System.out.println("The program terminates now.");
			System.exit(0);
		}
		
//		ArrayList<String> numbers = new ArrayList();
//		int i=0;
		while(dataReader.hasNext()) {
			String temNum = dataReader.next();
			System.out.println("This number: "+temNum);
			System.out.println("mantissa: " + getMantisa(temNum));
			System.out.println("characteristic: "+ getCharacteristic(temNum));
			System.out.println("sign: "+ getSign(temNum));
			System.out.println();
			System.out.println("-------------------------------------------------------------");
			System.out.println();
			
		}
		
		
		
			
//YOUR code goes here
				
		
	}

	private static String getSign(String temNum) {
		if(temNum.substring(0, 1).equals("-"))
			return "-";
		else 
			return "+";
	}
	
	
	
	private static String getCharacteristic(String temNum) {
		if(position(temNum, 'e')!=-1) {
			return temNum.substring(position(temNum, 'e'), temNum.length());
		}else {
			if(position(temNum, '.') != -1)
				return Integer.toString((temNum.length() - position(temNum, '.'))*-1);
			else return "0";
		}
	}
	
	
	

	private static String getMantisa(String temNum) {
		String res="";
		for(int i=0; i<temNum.length(); i++) {
			String tem = temNum.substring(i, i+1);
			if(!tem.equals("-") && !tem.equals("."))
				if(tem.equals("e")) break;
				else res+=tem;
		}
		return res;
	}
	
	/*
	 * This is helper methode return position of given character
	 */
	private static int position(String s, char c) {
		for(int i=0; i < s.length(); i++)
			if(s.charAt(i) == c)
				return i+1;
		return -1;
	}
		

}
