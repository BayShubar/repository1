package inexactUnitCalculatorMain;

import inexactUnitCalculator.InexactUnitCalculator;

import javax.swing.SwingUtilities;

/**
 * <p>
 * Title: InexactCalculatorMain Class - A component of the Inexact Calculator Program
 * </p>
 *
 * <p>
 * Description: A controller object class that launches the calculator's GUI
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2011
 * </p>
 *
 * @author Duisebay Yerkebulan 1603-csse(21580)
 * @version 1.00
 */
public class InexactUnitCalculatorMain {
    
    public static void main(String[] args) {
    	// Schedule this job for the event dispatch thread: creating and showing this application's GUI.
    	SwingUtilities.invokeLater(new Runnable() { public void run() { new InexactUnitCalculator(); } });
    }
    
    /**
     * The "invokeLater" method is being passed an object that must contain a method named "run" with no 
     * parameters.  When the Swing execution thread has finished loading all of the objects it needs to 
     * run properly. (Using Swing components and creating graphical interfaces (GUI) will be discussed 
     * in Chapter 12.)
     * 
     * It then calls this "run" method within the object that was passed to "invokeLater" method.  If 
     * you have initialization that you need to perform that does not involve any Swing element, you can
     * do that work within this class’ "main" method and have them run in parallel.  
     * 
     * Position the code before the "invokeLater" call if it must be performed prior to the start of the 
     * GUI.  If some of this work must be done after the start of the GUI, the code must be invoked at 
     * the end of the constructor.
     * 
     * The "new IntegerCalculator()" command causes a new IntegerCalculator object to be created.  When it 
     * is created, the standard instantiation process is followed that initializes all of the class 
     * attributes and runs the constructor for the class (in this case, the default constructor, as there 
     * are no parameters listed).   The initialization of the class attributes sets up all of the GUI 
     * elements and the execution of the constructor completes the process.  By the time the constructor 
     * is done, all of the GUI elements have been defined and positioned in the application's window and 
     * all of the buttons have been linked to methods.  
     * 
     * The final act is to make the window visible.  Now the application waits for the user to do something: 
     * add text to a text field or push a button.  Either of those actions directs the execution to a method 
     * within the IntergerCalculator class and the code for that method determines what actions will be 
     * performed. This applications does not have a Quit button or a quit menu item, so the only way to quit 
     * the program is to close the application's window manually.  (You can also ask the Operating System
     * to terminate this job, but that is overkill.)
     **/

}
