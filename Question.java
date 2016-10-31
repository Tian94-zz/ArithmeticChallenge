/****************************************************************
   PROGRAM:   ARITHMETIC CHALLENGE GAME
   AUTHOR:    Huitian Zhang
   STUDENT:   1100038016
   DUE DATE:  19/09/2016

   FUNCTION:  an arithmetic challenge game involving an instructor and student

   INPUT:     Challenging mathematical questions for the student.

   OUTPUT:    Doubly linked list of all questions, sorted lists, binary trees,
              behavioral graph of student and questions for the students.

   NOTES:     THIS CLASS IS FOR THE QUESTIONS WHICH IS STORED IN THE DNODES AND BINARY TREE
   CLASS:     QUESTION
****************************************************************/
package arithmeticchallengegame;

public class Question {
    String FirstNumber;     /*First number in the equation */
    String Operator;        /*Operator of the equation */
    String SecondNumber;    /*Second number in the equation */
    String Equals;          /*Equals symbol */    
    String Answer;          /*Answer of the equation */

/****************************************************************

   FUNCTION:   Create Question

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Default constructor for a question, sets default values to strings of what should be entered.
****************************************************************/
    public Question()
    {
        FirstNumber = "First Number";
        Operator = "Operator +-X/";
        SecondNumber = "SecondNumber";
        Equals = "=";
        Answer = "Answer";
    }        

/****************************************************************

   FUNCTION:   Create A Question With Arguments

   ARGUMENTS:  First Number, Operator, Second Number, Equals, Answer

   RETURNS:    Question with parsed in values

   NOTES:      Constructor of a question which assigns the properties to the correct values.
****************************************************************/
    public Question(String firstnumber, String operator, String secondnumber, String equals, String answer)
    {
        FirstNumber = firstnumber;
        Operator = operator;
        SecondNumber = secondnumber;
        Equals = equals;
        Answer = answer;        
    }        
}
