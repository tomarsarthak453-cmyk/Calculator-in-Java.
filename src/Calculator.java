import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // In Java, the asterisk (*) is a wildcard symbol that means "everything."When you use .* at the end of an import statement, you are telling the Java compiler: "Import all the public classes inside this specific package so I can use them import so we don't have to write  java.awt.Toolkit; import java.awt.Dimension; etc everything


public class Calculator {

    int boardWidth = 350 ;
    int boardHeight = 540 ;
    //we are using the JFrame class that we imported from javax.swing library and declare an object the string "Calculator" is the title for the window or for the  frame
    JFrame frame = new JFrame("Calculator");
    /* What is a Label?
   A Label is a basic component used exclusively to display static text or images on the screen that the user cannot directly edit or type into.
    • The Analogy: A name tag, a signpost, or a sticky note.
    • What it is used for: Displaying the calculator's current calculation result, showing a title like "Username:", or outputting an error message like "Invalid Password."
    • How the code translates:
    • In Java Swing: You use the JLabel class (e.g., JLabel title = new JLabel("My Calculator");).
    • In Web Development (HTML): You use the <label> tag or a simple text container like <span> or <p>.*/
    JLabel diplayLabel = new JLabel();
    /*What is a Panel?
    A Panel is an invisible, structural container used to group multiple components (like buttons, labels, and text fields) together into a single layout section.
     • The Analogy: A tray inside a drawer, a cardboard divider box, or a layout folder.
     • What it is used for: If you are building a calculator, you don't throw all your number buttons loosely into the main window (JFrame). Instead, you drop an invisible Panel into the window, configure that panel to act as a mathematical grid, and snap your number keys neatly inside it.
     • How the code translates:
     • In Java Swing: You use the JPanel class.
     • In Web Development (HTML): You use a <div> tag (which stands for "division"), which acts exactly like an invisible panel layout box.
     */
     JPanel displayPanel = new JPanel();
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


    }



}
