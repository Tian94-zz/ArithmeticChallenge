/****************************************************************
   PROGRAM:   ARITHMETIC CHALLENGE GAME
   AUTHOR:    Huitian Zhang
   STUDENT:   1100038016
   DUE DATE:  19/09/2016

   FUNCTION:  an arithmetic challenge game involving an instructor and student

   INPUT:     Challenging mathematical questions for the student.

   OUTPUT:    Doubly linked list of all questions, sorted lists, binary trees,
              behavioral graph of student and questions for the students.

   NOTES:     
****************************************************************/
package arithmeticchallengegame;

import java.awt.*;
import java.awt.event.*;
import javafx.scene.chart.Chart;
import javax.swing.*;

public class frmMain {
    public static void main(String s[]) {
		JFrame frmMain = new JFrame("Arithmetic Game - Instructor"); /*Creates a new frame*/
                frmMain.setPreferredSize(new Dimension(850,625));               /*Adjusting frame size*/
                frmMain.setTitle("Arithmetic Game - Instructor");               /*Set frame title*/
		// Add a window listner for close button    
		frmMain.addWindowListener(new WindowAdapter() {                 
                        
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// This is an empty content area in the frame
                Instructor InstructorMenu = new Instructor();                       /*Adds instructor panel*/
                frmMain.getContentPane().add(InstructorMenu, BorderLayout.WEST);    /*Attaches the panel to the main frame*/
		frmMain.pack();
		frmMain.setVisible(true);  
                
                
                
                
	}
    
    
}
