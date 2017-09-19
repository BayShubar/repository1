package inexactUnitCalculator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * <p>
 * Title: InexactCalculator Class - A component of the Inexact Calculator Program
 * </p>
 *
 * <p>
 * Description: A controller object class that implements the calculator's GUI window and computation
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2011
 * </p>
 *
 * @author Duisebay Yerkebulan 1603-csse(21580)
 * @version 1.00
 */
public class InexactUnitCalculator extends JFrame {
	/**
	 * These are the class attributes
	 */
	private static int windowWidth = 750;			// The width of the window in pixels
	private static int windowHeight = 400;			// The height of the window in pixels
	private static Dimension frameSize = new Dimension(windowWidth, windowHeight);
	
	private static final String plusMinusStr = ('\u00b1' + " ");
	private static final char power2 = '\u00b2';
	private static final char power3 = '\u00b3';
	
	private static final String[] unitNames = {" ", "mm", "cm", "m", "mm"+power2, "cm"+power2, "m"+power2, "mm"+power3, "cm"+power3, "m"+power3,
		"g", "kg", "s", "min", "hr", "A", "K", "mol", "cd"};

	// This establishes the user's screen size so we can center the window on the screen
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		

	// These attributes establish the calculator's labels and text input/output fields
	private JLabel msgIntegerCalculator = new JLabel("Inexact Units Calculator");
	private JLabel msgUnits = new JLabel("Units");
	private JLabel msgOperand1 = new JLabel("First operand");
	private JTextField fldOperand1 = new JTextField();
	private JLabel msgOperand1Err = new JLabel(plusMinusStr);
	private JTextField fldOperand1Err = new JTextField();
	private JComboBox fldOperand1Units = new JComboBox(unitNames);
	private JLabel msgOperand2 = new JLabel("Second operand");
	private JTextField fldOperand2 = new JTextField();
	private JLabel msgOperand2Err = new JLabel(plusMinusStr);
	private JTextField fldOperand2Err = new JTextField();
	private JComboBox fldOperand2Units = new JComboBox(unitNames);
	private JLabel msgResult = new JLabel("Result");
	private JTextField fldResult = new JTextField();
	private JLabel msgResultErr = new JLabel("");
	private JButton btnAdd = new JButton();
	private JButton btnSub = new JButton();
	private JButton btnMpy = new JButton();
	private JButton btnDiv = new JButton();
	private JLabel errOperand1 = new JLabel("");
	private JLabel errOperand2 = new JLabel("");

	// These attributes are the values for the calculator and are tied to the GUI text fields
	private CalculatorValue operand1;
	private CalculatorValue operand2;
	private CalculatorValue result;
	boolean operandError;
	
	private int units1;
	private int units2;

	// This listener calls "checkForErrors" any time a change is made to either of the two 
	// operand input fields
	DocumentListener fieldChangeListener = new DocumentListener() {
		public void changedUpdate(DocumentEvent de){ checkForErrors(); }
		public void insertUpdate(DocumentEvent de){ checkForErrors(); }
		public void removeUpdate(DocumentEvent de){ checkForErrors(); }
	};
	

	/**********
	 * This constructor creates the JFrame, populates the frame with the calculator's fields,
	 * centers it on the user's screen, and makes it visible
	 */
	public InexactUnitCalculator() {
		
		// Set the window title and terminate on close of the window
		this.setTitle("Duisebay Yerkebulan");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// This is the label at the top of the content portion of the window
		msgIntegerCalculator.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgIntegerCalculator.setBounds(new Rectangle(275, 00, 300, 24));

		/***
		 * These initialization commands set the font, size, and location of the field
		 */
		// The label for the units label
		msgUnits.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgUnits.setBounds(new Rectangle(640, 35, 50, 24));
		
		/* 
		 * The first operand
		 */
		// The label for the operand
		msgOperand1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgOperand1.setBounds(new Rectangle(10, 75, 140, 24));
		msgOperand1.setHorizontalAlignment(JTextField.RIGHT);
		
		// The text field for the operand
		fldOperand1.setText("");
		fldOperand1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand1.setBounds(new Rectangle(160, 72, 300, 30));
		fldOperand1.getDocument().addDocumentListener(fieldChangeListener);
		// When a character changes inside of Operand2, the method "fieldChangeListener" is called
		
		// The label for the operand error term
		msgOperand1Err.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgOperand1Err.setBounds(new Rectangle(455, 75, 40, 24));
		msgOperand1Err.setHorizontalAlignment(JTextField.RIGHT);
		
		// The text field for the operand error term
		fldOperand1Err.setText("");
		fldOperand1Err.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand1Err.setBounds(new Rectangle(500, 72, 90, 30));
		fldOperand1Err.getDocument().addDocumentListener(fieldChangeListener);
		
		// The text field for the operand units term
		fldOperand1Units.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand1Units.setBounds(new Rectangle(600, 67, 140, 40));
		fldOperand1Units.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {setUnits1(ae);}});
		
		
		// The error message for the operand
		errOperand1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		errOperand1.setBounds(new Rectangle(160, 105, 250, 24));
		errOperand1.setForeground(Color.red);
		
		

		/* 
		 * The second operand
		 */
		// The label for the operand
		msgOperand2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgOperand2.setBounds(new Rectangle(10, 150, 140, 24));
		msgOperand2.setHorizontalAlignment(JTextField.RIGHT);
		
		// The text field for the operand
		fldOperand2.setText("");
		fldOperand2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand2.setBounds(new Rectangle(160, 147, 300, 30));
		fldOperand2.getDocument().addDocumentListener(fieldChangeListener);
		// When a character changes inside of Operand2, the method "fieldChangeListener" is called
		
		// The label for the operand error term
		msgOperand2Err.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgOperand2Err.setBounds(new Rectangle(455, 150, 40, 24));
		msgOperand2Err.setHorizontalAlignment(JTextField.RIGHT);
		
		// The text field for the operand error term
		fldOperand2Err.setText("");
		fldOperand2Err.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand2Err.setBounds(new Rectangle(500, 147, 90, 30));
		fldOperand2Err.getDocument().addDocumentListener(fieldChangeListener);
		
		// The text field for the operand units term
		fldOperand2Units.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		fldOperand2Units.setBounds(new Rectangle(600, 142, 140, 40));
		fldOperand2Units.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {setUnits2(ae);}});
		
		// The error message for the operand
		errOperand2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		errOperand2.setBounds(new Rectangle(160, 180, 250, 24));
		errOperand2.setForeground(Color.red);
		

		
		/* 
		 * The calculator buttons
		 */
		// Addition "+"
		btnAdd.setText("+");
		btnAdd.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		btnAdd.setBounds(new Rectangle(175, 220, 60, 50));
		btnAdd.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {addOperands(ae);}});
		// When the add button is pressed, the method "addOperands" is called

		// Subtraction "-"
		btnSub.setText("-");
		btnSub.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		btnSub.setBounds(new Rectangle(295, 220, 60, 50));
		btnSub.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {subOperands(ae);}});
		// When the add button is pressed, the method "subOperands" is called

		// Multiplication "*"
		btnMpy.setText("*");
		btnMpy.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		btnMpy.setBounds(new Rectangle(415, 220, 60, 50));
		btnMpy.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {mpyOperands(ae);}});
		// When the add button is pressed, the method "mpyOperands" is called

		// Division "/"
		btnDiv.setText("/");
		btnDiv.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		btnDiv.setBounds(new Rectangle(535, 220, 60, 50));
		btnDiv.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {divOperands(ae);}});
		// When the add button is pressed, the method "divOperands" is called

		/* 
		 * The result
		 */
		// The label for the result
		msgResult.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgResult.setBounds(new Rectangle(10, 300, 140, 24));
		msgResult.setHorizontalAlignment(JTextField.RIGHT);
		
		// The text field for the result - the user cannot directly edit it, but can copy the contents
		fldResult.setText("");						// Clear the contents of the text field
		fldResult.setFont(new java.awt.Font("Dialog", Font.BOLD, 18));
		fldResult.setBounds(new Rectangle(160, 297, 580, 30));
		fldResult.setEditable(false);				// Allow a copy of but not a change to the field
		
		
		
		
		// The label for the operand error term
		msgResultErr.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		msgResultErr.setBounds(new Rectangle(160, 330, 200, 24));
		msgResultErr.setHorizontalAlignment(JTextField.LEFT);
		msgResultErr.setForeground(Color.red);


		/* 
		 * These commands add each GUI element to the layout so they will be displayed
		 */
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);				// No layout manager, we will manually do it
		contentPane.add(msgIntegerCalculator);		// Add in all of the GUI elements to the contentPane
		contentPane.add(msgUnits);       
		contentPane.add(msgOperand1);       
		contentPane.add(fldOperand1);
		contentPane.add(msgOperand1Err);       
		contentPane.add(fldOperand1Err);
		contentPane.add(fldOperand1Units);
		contentPane.add(errOperand1);
		contentPane.add(msgOperand2);
		contentPane.add(fldOperand2);       
		contentPane.add(msgOperand2Err);       
		contentPane.add(fldOperand2Err);
		contentPane.add(fldOperand2Units);
		contentPane.add(errOperand2);       
		contentPane.add(btnAdd);
		contentPane.add(btnSub);
		contentPane.add(btnMpy);
		contentPane.add(btnDiv);
		contentPane.add(msgResult);
		contentPane.add(fldResult);
		contentPane.add(msgResultErr);

		/* 
		 * Center the window on the user's screen (and make sure it fits)
		 */
		if (windowHeight > screenSize.height) { frameSize.height = screenSize.height; }
		if (windowWidth > screenSize.width) { frameSize.width = screenSize.width; }
		this.setSize(frameSize.width + 10, frameSize.height + 10); // + 10 for Windows computers
		this.setLocation( (screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		/* 
		 * Make this window visible
		 */
		this.setVisible(true);
	}

	/**********
	 * During initialization listener methods were established for the four calculation buttons.  The
	 * following routines perform the various calculator operations.
	 */

	/**********
	 * This routine checks the first operand and returns it.  If the value is invalid, a value of zero 
	 * is returned, but more importantly, a red error message is displayed next to the text field.
	 * If the value is valid, it resets the error field and returns the actual value.
	 */
	private UNumber convertOperand1() {
		
		// Fetch the string the user entered into the operatand's text field
		String temp = fldOperand1.getText();		// Get the text from the input field
		if (temp.length() == 0) {					// If there is nothing there,
			errOperand1.setText("");				// reset the error message
			fldResult.setText("");					// clear the result text field
			msgResult.setText("Result");			// clear the result text field
			return new UNumber(0.0);								// and return a zero value
		}

		// If the first character is a plus sign, ignore it.
		int start = 0;								// Start at character position zero
		boolean negative = false;					// Assume the value is not negative
		if (temp.charAt(start) == '+')				// See if the first character is '+'
			 start++;								// If so, skip it and ignore it
		
		// If the first character is a minus sign, skip over it, but remember it
		else if (temp.charAt(start) == '-'){		// See if the first character is '-'
			start++;								// if so, skip it
			negative = true;						// but do not ignore it
		}
		
		// See if the user-entered string can be converted into double value
		Scanner tempScanner = new Scanner(temp.substring(start));	// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {							// See if the next token is a valid
			errOperand1.setText("Invalid value"); 					// double value.  If not, signal there
			operandError = true;									// is an error in this operand and 
			return new UNumber(0.0);												// return a zero
		}
		
		// Convert the user-entered string to a double value
		UNumber theValue =new UNumber(tempScanner.nextDouble()); 
		if (tempScanner.hasNext()) {								// See if the next token is a valid
			errOperand1.setText("Excess data"); 					// double value.  If so, signal there
			operandError = true;									// is an error in this operand and 
			return new UNumber(0.0);											// return a zero
		}
		fldResult.setText("");										// Clear the result field
		errOperand1.setText("");									// Reset the error message

		// Determine whether or not to negative the result 
		if (negative) {								// Return the proper value based
			theValue.mpy(new UNumber(-1));	
			return 	theValue;						// on the state of the flag that
		}
		else 										// says whether or not a '-' was
			return theValue;						// seen as the first character
		}	

	/**********
	 * This routine checks the first operand error and returns it.  If the value is invalid, a value of 
	 *  zero is returned, but more importantly, a red error message is displayed next to the text field.
	 * If the value is valid, it returns the actual value.
	 */
	private double convertOperand1Err() {
		
		// Fetch the string the user entered into the operatand's text field
		String temp = fldOperand1Err.getText();		// Get the text from the input field

		// If there is a value at all.  If not, return zero
		if (temp.length() == 0) {
			return 0.0;
		}
		
		// See if the user-entered string can be converted into double value
		Scanner tempScanner = new Scanner(temp);	// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {			// See if the next token is a valid
			errOperand1.setText("Invalid value"); 	// double value.  If not, signal there
			operandError = true;					// is an error in this operand and 
			return 0.0;								// return a zero
		}
		
		// Convert the user-entered string to a double value
		Double theValue = tempScanner.nextDouble();
		if (tempScanner.hasNext()) {				// See if the next token is a valid
			errOperand1.setText("Excess data"); 	// double value.  If so, signal there
			operandError = true;					// is an error in this operand and 
			return 0.0;								// return a zero
		}

		return theValue;							// seen as the first character
		}	
	
	/**********
	 * This routine checks the second operand and returns it.  If the value is invalid, a value of zero 
	 * is returned, but more importantly, a red error message is displayed next to the text field.
	 * If the value is valid, it resets the error field and returns the actual value.
	 */
	private UNumber convertOperand2() {
		
		// Fetch the string the user entered into the operatand's text field
		String temp = fldOperand2.getText();		// Get the text from the input field
		if (temp.length() == 0) {					// If there is nothing there,
			errOperand2.setText("");				// reset the error message
			fldResult.setText("");					// clear the result text field
			msgResult.setText("Result");			// clear the result text field
			return new UNumber(0.0);								// and return a zero value
		}

		// If the first character is a plus sign, ignore it.
		int start = 0;								// Start at character position zero
		boolean negative = false;					// Assume the value is not negative
		if (temp.charAt(start) == '+')				// See if the first character is '+'
			 start++;								// If so, skip it and ignore it
		
		// If the first character is a minus sign, skip over it, but remember it
		else if (temp.charAt(start) == '-'){		// See if the first character is '-'
			start++;								// if so, skip it
			negative = true;						// but do not ignore it
		}
		
		// See if the user-entered string can be converted into double value
		Scanner tempScanner = new Scanner(temp.substring(start));	// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {							// See if the next token is a valid
			errOperand2.setText("Invalid value"); 					// double value.  If not, signal there
			operandError = true;									// is an error in this operand and 
			return new UNumber(0.0);											// return a zero
		}
		
		// Convert the user-entered string to a double value
		UNumber theValue =new UNumber( tempScanner.nextDouble());
		if (tempScanner.hasNext()) {								// See if the next token is a valid
			errOperand2.setText("Excess data"); 					// double value.  If so, signal there
			operandError = true;									// is an error in this operand and 
			return new UNumber(0.0);											// return a zero
		}
		fldResult.setText("");										// Clear the result field
		errOperand2.setText("");									// Reset the error message

		// Determine whether or not to negative the result 
		if (negative) {								// Return the proper value based
			theValue.mpy(new UNumber(-1));
			return theValue;						// on the state of the flag that
		}
		else 										// says whether or not a '-' was
			return theValue;						// seen as the first character
	}

	/**********
	 * This routine checks the first operand error and returns it.  If the value is invalid, a value of 
	 *  zero is returned, but more importantly, a red error message is displayed next to the text field.
	 * If the value is valid, it returns the actual value.
	 */
	private double convertOperand2Err() {
		
		// Fetch the string the user entered into the operatand's text field
		String temp = fldOperand2Err.getText();		// Get the text from the input field

		// If there is a value at all.  If not, return zero
		if (temp.length() == 0) {
			return 0.0;
		}
		
		// See if the user-entered string can be converted into double value
		Scanner tempScanner = new Scanner(temp);	// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {			// See if the next token is a valid
			errOperand2.setText("Invalid value"); 	// double value.  If not, signal there
			operandError = true;					// is an error in this operand and 
			return 0.0;								// return a zero
		}
		
		// Convert the user-entered string to a double value
		Double theValue = tempScanner.nextDouble();
		if (tempScanner.hasNext()) {				// See if the next token is a valid
			errOperand2.setText("Excess data"); 	// double value.  If so, signal there
			operandError = true;					// is an error in this operand and 
			return 0.0;								// return a zero
		}

		return theValue;							// seen as the first character
		}	

	/**********
	 * This listener is established to check the input after each and every change to either of this 
	 * input fields.  Each time a change is made, the corresponding operands are set.  The actual 
	 * computation of the result only takes place when one of the buttons is pressed.
	 */
	private void checkForErrors(){
		operandError = false;						// Reset the error flag
		msgResult.setText("Result");				// Set the default result message
		operand1 = new CalculatorValue(convertOperand1(), convertOperand1Err(), units1);				
		operand2 = new CalculatorValue(convertOperand2(), convertOperand2Err(), units2);
	}
	
	
	private void setUnits1(ActionEvent ae){
		units1 = fldOperand1Units.getSelectedIndex();
		checkForErrors();
	}
	
	private void setUnits2(ActionEvent ae){
		units2 = fldOperand2Units.getSelectedIndex();
		checkForErrors();
	}

	/*********************************************************************************
	 * This portion of the class defines the computation that takes place when the
	 * various calculator buttons (add, subtract, multiply, and divide are pressed).
	 */

	/**********
	 * This is the add routine
	 * 
	 * @param ae	This routine ignores the ae parameter
	 */
	private void addOperands(ActionEvent ae){
		if (operandError)										// If there is an operand error just return
			return;
		errOperand2.setText("");								// Reset the "divide by zero error"
		result = CalculatorValue.add(operand1, operand2);
		fldResult.setText(result.toString());					// Converts the result to string
		msgResult.setText("Sum");								// Specify the result is a sum
		if (result.getUnits() < 0) 
			msgResultErr.setText("Units mismatch");
		else
			msgResultErr.setText("");
	}

	/**********
	 * This is the subtract routine
	 * 
	 * @param ae	This routine ignores the ae parameter
	 */
	private void subOperands(ActionEvent ae){
		if (operandError)										// If there is an operand error just return
			return;
		errOperand2.setText("");								// Reset the "divide by zero error"
		result = CalculatorValue.sub(operand1, operand2);
		fldResult.setText(result.toString());					// Converts the result to string
		msgResult.setText("Difference");						// Specify the result is a difference
		if (result.getUnits() < 0) 
			msgResultErr.setText("Units mismatch");
		else
			msgResultErr.setText("");
	}

	/**********
	 * This is the multiply routine
	 * 
	 * @param ae	This routine ignores the ae parameter
	 */
	private void mpyOperands(ActionEvent ae){
		if (operandError)										// If there is an operand error just return
			return;
		errOperand2.setText("");								// Reset the "divide by zero error"
		result = CalculatorValue.mpy(operand1, operand2);
		fldResult.setText(result.toString());					// Converts the result to string
		msgResult.setText("Product");							// Specify the result is a product
		if (result.getUnits() < 0) 
			msgResultErr.setText("Units mismatch");
		else
			msgResultErr.setText("");
	}

	/**********
	 * This is the divide routine.  If the divisor is zero or close to zero, the divisor is declared to be invalid.
	 * 
	 * @param ae	This routine ignores the ae parameter
	 */
	private void divOperands(ActionEvent ae){
		if (operandError)										// If there is an operand error just return
			return;
		if (Math.abs(operand2.getValue().getDouble()) <= 1.0E-50) {					// Check to see if divide by zero
			errOperand2.setText("Divide by zero");				// If this is a divide by zero
			fldResult.setText("");								// display the error message
		} else {
			errOperand2.setText("");							// Reset the "divide by zero error"
			result = CalculatorValue.div(operand1, operand2);
			fldResult.setText(result.toString());					// Converts the result to string
			msgResult.setText("Quotient");						// Specify the result is a quotient
			if (result.getUnits() < 0) 
				msgResultErr.setText("Units mismatch");
			else
				msgResultErr.setText("");
		}
	}
}
