import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // In Java, the asterisk (*) is a wildcard symbol that means "everything."When you use .* at the end of an import statement, you are telling the Java compiler: "Import all the public classes inside this specific package so I can use them import so we don't have to write  java.awt.Toolkit; import java.awt.Dimension; etc everything


public class Calculator {
    //instance variables
    int boardWidth = 350 ;
    int boardHeight = 540 ;
    Color customLightgrey = new Color(212,212,210) ;
    Color customDarkGrey = new Color (80, 80,80);
    Color customBlack = new Color (28 ,28,28);
    Color customOrange = new Color (255,149,0);
    //we are using the JFrame class that we imported from javax.swing library and declare an object the string "Calculator" is the title for the window or for the  frame
    JFrame frame = new JFrame("Calculator");
    /* What is a Label?
   A Label is a basic component used exclusively to display static text or images on the screen that the user cannot directly edit or type into.
    • The Analogy: A name tag, a signpost, or a sticky note.
    • What it is used for: Displaying the calculator's current calculation result, showing a title like "Username:", or outputting an error message like "Invalid Password."
    • How the code translates:
    • In Java Swing: You use the JLabel class (e.g., JLabel title = new JLabel("My Calculator");).
    • In Web Development (HTML): You use the <label> tag or a simple text container like <span> or <p>.*/
    JLabel displayLabel1 = new JLabel();

    /*What is a Panel?
    A Panel is an invisible, structural container used to group multiple components (like buttons, labels, and text fields) together into a single layout section.
     • The Analogy: A tray inside a drawer, a cardboard divider box, or a layout folder.
     • What it is used for: If you are building a calculator, you don't throw all your number buttons loosely into the main window (JFrame). Instead, you drop an invisible Panel into the window, configure that panel to act as a mathematical grid, and snap your number keys neatly inside it.
     • How the code translates:
     • In Java Swing: You use the JPanel class.
     • In Web Development (HTML): You use a <div> tag (which stands for "division"), which acts exactly like an invisible panel layout box.
     */
     JPanel displayPanel = new JPanel();
     JPanel buttonPanel = new JPanel();

     String [] buttonValues = {
             "AC", "+/-", "%", "÷",
             "7", "8", "9", "×",
             "4", "5", "6", "-",
             "1", "2", "3", "+",
             "0", ".", "√", "="
     };

     /*
      DISCRIPTION FOR CONSTRUCTOR
      now as we have made an object we will use constructor as a constructor consists of already declared objects so we will use the functions of the class JFrame for which we made the object
      a constructor consists of functions , already declared objects
     */


    Calculator (){
        frame.setVisible(true);//if enter false here the screen will not be visible
        frame.setSize(boardWidth , boardHeight);
        frame.setLocationRelativeTo(null);//what this does is that it places the frame in the center of the screen
        frame.setResizable(false);//freezes the size of your window so that the user cannot resize, stretch, or shrink it.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// by not  using  this the program will still run after closing the window
        //JFrame.EXIT_ON_CLOSE	Closes the window and completely kills the program.	Your main window (like a Calculator).
        //JFrame.DISPOSE_ON_CLOSE	Closes and destroys only that specific window, but keeps the rest of the application alive.	Pop-up windows (like an About Page or Settings Panel).
        //JFrame.HIDE_ON_CLOSE	(Default) Hides the window from view, but leaves it entirely in memory so you can reopen it later.	Tab-heavy apps or apps meant to stay open in the system tray.
        //JFrame.DO_NOTHING_ON_CLOSE	Ignore the click entirely. The window stays open.	For displaying a pop-up confirmation message like "Are you sure you want to exit without saving?" first.
        displayLabel1.setBackground(customBlack);
        displayLabel1.setForeground(Color.white);
        /*
         * This programming technique is called creating an anonymous object (or an inline object).
           Instead of writing multiple lines of code to build the font first and then pass it to the label, you compress everything into a single, clean line of code.
        *
        */
        displayLabel1.setFont(new Font("Arial",Font.PLAIN,80));
        displayLabel1.setText("0");
        displayLabel1.setHorizontalAlignment(JLabel.RIGHT);
        /*

        *  — The component is solid and paints its entire background. Swing uses this as a performance optimization so it knows it does not need to paint underlying components
        *
        *An underlying component is any UI element positioned physically behind another component on the screen
        *
           How the Layers Stack

            • Bottom Layer (Parent Container) — Your main window (JFrame) or a background container (JPanel) sits at the bottom. It might hold a solid background color, a gradient, or a wallpaper image.
            • Middle Layer (Sub-Panels) — Another JPanel placed inside that main container sits directly on top of it.
            • Top Layer (Child Controls) — Buttons, text fields, or labels (JLabel) placed inside that sub-panel sit on the very top layer.
        *
        *
        * */
        displayLabel1.setOpaque(true);




        displayPanel.setLayout(new BorderLayout());
        /* BorderLayout is a layout manager that divides a container into five fixed compass regions: North, South, East, West, and Center.

        * Structure	-5 fixed regions (NORTH, SOUTH, EAST, WEST, CENTER)
        * Component -Sizing	Unequal. CENTER takes all remaining space, while edges only stretch in one direction.
        * Capacity	-Holds up to 5 components (one per region; adding a second overwrites the first).
        * Adding -Components	Requires a position constant: panel.add(comp, BorderLayout.NORTH)
        * Default For-	JFrame, JDialog, and JWindow.
        *
        *  */
        displayPanel.add(displayLabel1);
        frame.add(displayPanel);
        // Add the panel to the NORTH (top) region of the frame
         frame.add(displayPanel, BorderLayout.NORTH);
        /*
         GridLayout is a layout manager that arranges components in a rectangular grid of equally sized rows and columns.
     Structure   - A customizable grid of rows and columns (e.g., 4x4).
     Component   - Sizing  Strictly Equal. Every cell is forced to the exact same width and height
     Capacity    - Holds unlimited components (automatically adds columns or rows as needed).
     Adding Components - Added sequentially left-to-right, top-to-bottom: panel.add(comp)
     Default For - None (must be explicitly set using setLayout(new GridLayout(...))).
           */
        buttonPanel.setLayout(new GridLayout(5,4));
        buttonPanel.setBackground(customBlack);
        frame.add(buttonPanel);
         for(int i =0;i<=buttonValues.length;i++){
             /*
             * The JButton class in Java creates a clickable push-button for graphical user interfaces (GUIs). It is part of the javax.swing package and triggers specific actions in your application when a user clicks it or presses a keyboard shortcut
             * */
             JButton button = new JButton ();
             button.setFont(new Font("Arial",Font.PLAIN,30));
             button.setText(buttonValues[i]);
             buttonPanel.add(button);

             button.addActionListener( e -> {
                 String currentValue = displayLabel1.getText();
                 String buttonValue = button.getText();
                 /*
                 *
                  1. Why displayLabel1.getText().equals("0") is CORRECT

                   1. displayLabel1.getText() runs first. Its job is to fetch the text on the screen, so it returns a String (for example, "0").
                   2. Next, Java attaches .equals("0") onto that returned String ("0".equals("0")).
                   3. Because a String has an .equals() method that returns a boolean (true or false), the if statement is completely happy.

                  2. Why displayLabel1.setText("0").equals("0") is INCORRECT

                   1. displayLabel1.setText("0") runs first. Its job is only to update the screen, so its return type is void (nothing/empty).
                   2. Next, Java tries to run .equals("0") on void (void.equals("0")).
                   3. Because "nothing" (void) is not an object and has no .equals() method, Java immediately stops and throws a compile error.
                 *
                 *
                 *
                 * */

                 if (displayLabel1.getText().equals("0")){
                     displayLabel1.setText(buttonValue);
                 } else {
                     displayLabel1.setText(currentValue+buttonValue);}
             });

                 //  if(!displayLabel1.getText().contains(".")){
                  //      displayLabel1.setText(currentValue);










         }





    }



}
