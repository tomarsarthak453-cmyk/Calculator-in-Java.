import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // In Java, the asterisk (*) is a wildcard symbol that means "everything."When you use .* at the end of an import statement, you are telling the Java compiler: "Import all the public classes inside this specific package so I can use them import so we don't have to write  java.awt.Toolkit; import java.awt.Dimension; etc everything

import javax.swing.border.LineBorder;

public class Calculator {

    int boardWidth = 350 ;
    int boardHeight = 540 ;
    //we are using the JFrame class that we imported from javax.swing library and declare an object the string "Calculator" is the title for the window or for the  frame
    JFrame frame = new JFrame("Calculator");
    // now as we have made an object we will use constructor as a constructor consists of already declared objects so we will use the functions of the class JFrame for which we made the object
    // a constructor consists of functions , already declared objects
    Calculator (){
        frame.setVisible(true);
        frame.setSize(boardWidth , boardHeight);

    }



}
