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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author student
 */
public class frmStudent  {
    
  public static void main(String s[]) {
		JFrame frmStudent = new JFrame("JFrame Source Demo"); /*Creates a new frame*/
                frmStudent.setLocationRelativeTo(null);                 /*Sets the location of frame*/
                frmStudent.setResizable(false);                         /*Sets resizeable to false*/
                frmStudent.setTitle("Arithmetic Game - Student");       /*Adjusts frame title*/
                frmStudent.setPreferredSize(new Dimension(550,300));    /*Retitles the frame*/
		// Add a window listner for close button
		frmStudent.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// This is an empty content area in the frame
                Student StudentMenu = new Student();                    /*Adds a student menu*/
                frmStudent.getContentPane().add(StudentMenu);           /*Attaches Student Menu To Frame*/
		frmStudent.pack();
		frmStudent.setVisible(true);  
                
	}
}
